/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastliar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author farid,kevin,lexy,reza
 */
public class GUIChat extends javax.swing.JFrame {

    ChatController controller;

    public GUIChat() {
        initComponents();
        controller = new ChatController(this);
    }

    public JButton getConnectBtn() {
        return ConnectBtn;
    }

    public JButton getDisconnectBtn() {
        return DisconnectBtn;
    }

    public JTextArea getDisplayChat() {
        return DisplayChat;
    }

    public JTextField getInputIP() {
        return InputIP;
    }

    public JTextField getInputPort() {
        return InputPort;
    }

    public JTextField getMessageInput() {
        return MessageInput;
    }

    public JButton getSendBtn() {
        return btnsend;
    }

    public JButton getOpenFile() {
        return btnsendfile;
    }

    public JFileChooser getLoadFile() {
        return jFileChooser;
    }

    public JButton getSendFile() {
        return btnsendfile;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayChat = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        InputIP = new javax.swing.JTextField();
        InputPort = new javax.swing.JTextField();
        DisconnectBtn = new javax.swing.JButton();
        ConnectBtn = new javax.swing.JButton();
        btnsend = new javax.swing.JButton();
        btnsendfile = new javax.swing.JButton();
        MessageInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Multicast Chat");

        DisplayChat.setColumns(20);
        DisplayChat.setRows(5);
        jScrollPane1.setViewportView(DisplayChat);

        jLabel5.setText("Host");

        jLabel6.setText("Port");

        InputIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputIPActionPerformed(evt);
            }
        });

        InputPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPortActionPerformed(evt);
            }
        });

        DisconnectBtn.setText("Disconnect");
        DisconnectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectBtnActionPerformed(evt);
            }
        });

        ConnectBtn.setText("Connect");

        btnsend.setText("Send");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        btnsendfile.setText("Send File");
        btnsendfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MessageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnsend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsendfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InputIP, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InputPort, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(ConnectBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DisconnectBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(InputIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisconnectBtn)
                    .addComponent(ConnectBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsend)
                    .addComponent(btnsendfile)
                    .addComponent(MessageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPortActionPerformed

    private void DisconnectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectBtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DisconnectBtnActionPerformed

    private void InputIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputIPActionPerformed

    }//GEN-LAST:event_InputIPActionPerformed

    private void btnsendfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsendfileActionPerformed

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnectBtn;
    private javax.swing.JButton DisconnectBtn;
    private javax.swing.JTextArea DisplayChat;
    private javax.swing.JTextField InputIP;
    private javax.swing.JTextField InputPort;
    private javax.swing.JTextField MessageInput;
    private javax.swing.JButton btnsend;
    private javax.swing.JButton btnsendfile;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
