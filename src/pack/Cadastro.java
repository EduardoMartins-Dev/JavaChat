package pack;

import pack.mensagens;
import static pack.Conexao.con;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Cadastro extends javax.swing.JFrame {

    public static int sqlID;
    public Cadastro() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btncadastro = new javax.swing.JButton();
        tfnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        tftelefone = new javax.swing.JTextField();
        cbtermos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 300));

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        jLabel4.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        jLabel6.setText("Telefone");

        btncadastro.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        btncadastro.setText("Cadastrar");
        btncadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastroActionPerformed(evt);
            }
        });

        tfnome.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        tfnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfnomeFocusGained(evt);
            }
        });
        tfnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfnomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfnomeKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel2.setText("Cadastre-se");

        tfemail.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N

        tftelefone.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N

        cbtermos.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        cbtermos.setText("Aceitar Termos e condicoes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbtermos)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btncadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(tfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(tftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cbtermos)
                .addGap(6, 6, 6)
                .addComponent(btncadastro)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        String sql, nome = tfnome.getText(), email = tfemail.getText(), telefone = tftelefone.getText();

    if (cbtermos.isSelected()) {
        Conexao.Conectar();
        
        // verificar se o número de telefone ja existe na tabela contatos
        String verTel = "select id from contatos where telefone = '" + telefone + "'";
        try {
            Statement stmVer = con.createStatement();
            ResultSet rs = stmVer.executeQuery(verTel);
            
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Este numero de telefone ja foi cadastrado", "telefone ja cadastrado", JOptionPane.ERROR_MESSAGE);
            } else {
                // numero de telefone nao existe, pode continuar com o cadastro
                sql = "insert into contatos(nome, email, telefone) value ('" + nome + "','" + email + "','" + telefone + "')";
                System.out.println(sql);
                
                mensagens mensagens = new mensagens();
                mensagens.setVisible(true);
                
                Login cadastro = new Login();
                cadastro.setVisible(false);
                
                try {
                    Statement stm = con.createStatement();
                    stm.execute(sql);
                    tfnome.setText("");
                    tfemail.setText("");
                    tftelefone.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao incluir, tente novamente" + e, null, JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer a verificação do numero de telefone: " + e, null, JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Marque a caixa de seleção para continuar", "Termos e Condições", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_btncadastroActionPerformed

    private void tfnomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfnomeFocusGained
        tfnome.setText("");
    }//GEN-LAST:event_tfnomeFocusGained

    private void tfnomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnomeKeyPressed

    }//GEN-LAST:event_tfnomeKeyPressed

    private void tfnomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnomeKeyTyped

    }//GEN-LAST:event_tfnomeKeyTyped

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastro;
    private javax.swing.JCheckBox cbtermos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfnome;
    private javax.swing.JTextField tftelefone;
    // End of variables declaration//GEN-END:variables
}
