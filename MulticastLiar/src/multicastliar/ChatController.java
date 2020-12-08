package multicastliar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author farid,kevin,lexy,reza
 */
public class ChatController {
    private GUIChat view;
    private MulticastSocket sendMulticast = null, listenMulticast = null;
    private InetAddress group;
    private InetAddress broadcast;
    int port = 0;
    String msg;
    private Thread t;

    public ChatController(GUIChat view) {
        this.view = view;
        this.view.getConnectBtn().addActionListener(new ActionListener() { //button connect untuk melakukan connect ke ip
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect();
                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.view.getDisconnectBtn().addActionListener(new ActionListener() { //button disconnect untuk melakukan disconnect ke ip dengan cara leave Group
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                try {
                    sendMulticast.leaveGroup(group);
                    listenMulticast.leaveGroup(group);

                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sendMulticast.close();
                listenMulticast.close();
            }
        });
        this.view.getSendBtn().addActionListener(new ActionListener() { //button send untuk mengirim pesan ke group
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendChat();
                } catch (IOException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getSendFile().addActionListener(new ActionListener() { //button sendFile untuk mengirim file ke group
            @Override
            public void actionPerformed(ActionEvent e) {
                sendFile();
            }
        });
    }

    void Connect() throws UnknownHostException, IOException { //method Connect()
        t = new Thread(new ListenChat());
        try {
            group = InetAddress.getByName(this.view.getInputIP().getText()); //untuk mengambil host/ip yang kita inputkan
            port = Integer.parseInt(this.view.getInputPort().getText()); //untuk mengambil port yang kita inputkan
            broadcast = InetAddress.getByName("234.5.6.7"); //inet addressnya 234.5.6.7 yang kita simpan di variabel broadcast

            sendMulticast = new MulticastSocket(port); //buat variabel sendMulticast berisi multicastSocket yang berparameter port
            sendMulticast.joinGroup(group); //kemudian panggil method joinGroup 
            sendMulticast.setBroadcast(true); 
            sendMulticast.setTimeToLive(5);

            listenMulticast = new MulticastSocket(port); //buat variable listenMulticast berisi multicastSocket yang perameter port
            listenMulticast.joinGroup(group); //kemudian panggil method joinGroup dari listenMulticast
            listenMulticast.setTimeToLive(5);

            t.start();
            this.view.getDisplayChat().append("Listening...\n"); //untuk menampilkan text jika kita melakukan joinGroup
        } catch (UnknownHostException ux) {
           
        }
    }

    private class ListenChat implements Runnable {
        @Override
        public void run() {
            try {
                listenChat();
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void listenChat() throws IOException { // method listeChat()
        byte[] buffer = new byte[8192]; //definisikan variable buffer dari array byte dengan byte 8192
        while (true) { //perulangan while 
            DatagramPacket ReceivePacket = new DatagramPacket(buffer, buffer.length); //definisikan variabel ReceivePacket dari DatagramPacket yang berparameter buffer
            ReceivePacket.setLength(ReceivePacket.getLength()); //panggil setLength dari ReceivePacket untuk menetapkan jumlah karakter string yang akan dikirim sesuai dari jumlah chat yang kita kirim
            listenMulticast.receive(ReceivePacket);  //panggil method receive yang berparameter ReceivePacket tadi dari listenMulticast untuk mengirim pesan
            String IPSender = ReceivePacket.getAddress().getHostAddress(); // IpSender untuk mengambil IP 
            String s = new String(ReceivePacket.getData(), 0, ReceivePacket.getLength());
            this.view.getDisplayChat().append(IPSender + " -> " + s + "\n"); // disini akan menampilkan pesan yang dikirim
        }
    }

    void sendChat() throws IOException { //method sendChat
        msg = this.view.getMessageInput().getText(); //variabel msg untuk mengambil pesan yang diinputkan
        byte[] msgByte = msg.getBytes(); //kemudian rubah ke byte
        DatagramPacket sendPacket = new DatagramPacket(msgByte, msgByte.length, broadcast, port); //definisikan variabel sendPacket dari DatagramPacket yang berparameter tersebut
        sendMulticast.send(sendPacket); //panggil method send untuk mengirim isi variable sendPacket
        msg = "";
        this.view.getMessageInput().setText("");
        if (this.view.getMessageInput().getText().equalsIgnoreCase("exit")) { //jika membaca ada inputan "exit" maka akan melakukan leaveGroup / disconnect
            sendMulticast.leaveGroup(group);
            sendMulticast.close();
            System.exit(1);
        }
    }

    void sendFile() { //method sendFile
        JFileChooser loadFile = view.getLoadFile(); //inisiasikan JFileChooser
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            BufferedInputStream reader = null;
            try {
                reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
                int temp = 0;
                List<Integer> list = new ArrayList<>();
                while ((temp = reader.read()) != -1) {
                    list.add(temp);
                }
                if (!list.isEmpty()) {
                    byte[] readFile = new byte[list.size()];
                    int i = 0;
                    for (Integer integer : list) {
                        readFile[i] = integer.byteValue();
                        i++;
                    }
                    String isiFile = new String(readFile); //untuk mengirim isiFile
                    String sendedMessage = "isi file: " + isiFile; // untuk menampilkan isiFile yang dikirim
                    byte[] sendFile = sendedMessage.getBytes(); // rubah isi file ke byte array
                    JOptionPane.showMessageDialog(view, "File berhasil dikirim!!!", "Informasi", JOptionPane.INFORMATION_MESSAGE); // tampilkan pesan 
                    DatagramPacket sendPacket = new DatagramPacket(sendFile, sendFile.length, broadcast, port); //definisikan variabel sendPacket dari DatagramPacket yang berparameter sendFile
                    sendMulticast.send(sendPacket); //panggil method send untuk mengirim variable SendPacket
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
