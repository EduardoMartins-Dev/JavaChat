package pack;

import static pack.Cadastro.sqlID;
import pack.mensagens;
import java.sql.ResultSet;
import static pack.Conexao.con;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static int idenv;
    public static int idrec;
    
    public Login() {
        initComponents();
        Conexao.Conectar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblentre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tftel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(330, 245));
        setMinimumSize(new java.awt.Dimension(330, 245));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 234, -1, -1));

        lblentre.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        lblentre.setText("Cadastre-se");
        lblentre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblentreMouseClicked(evt);
            }
        });
        getContentPane().add(lblentre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        jLabel7.setText("Não tem cadastro?");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 120, -1));

        btEntrar.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 150, -1));

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        jLabel2.setText("telefone:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 20));

        tftel.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        tftel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tftelKeyPressed(evt);
            }
        });
        getContentPane().add(tftel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, -1));

        jLabel12.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel12.setText("Login");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblentreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblentreMouseClicked
        Login cadastro = new Login();
        cadastro.setVisible(false);
        
        Cadastro login = new Cadastro();
        login.setVisible(true);
    }//GEN-LAST:event_lblentreMouseClicked

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        String sql;

        try{
            sql = "select * from contatos where telefone = '" + tftel.getText() + "'";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()){

                //tftelefone.setText(rs.getString("telefone"));
                System.out.println("logado como: " + rs.getString("nome"));
                System.out.println("id de login: " +rs.getString("id"));
                
                idenv = Integer.parseInt(rs.getString("id"));
                System.out.println("idenvio: "+idenv);  
                
                mensagens mensagens = new mensagens();
                mensagens.setVisible(true);
 
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Esse banco de dados nao existe"
                ,"numero nao existe ou erta errado",JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao entrar, tente novamente"
                ,"ERRO",JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btEntrarActionPerformed

    private void tftelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String sql;

        try{
            sql = "select * from contatos where telefone = '" + tftel.getText() + "'";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()){

                tftel.setText(rs.getString("telefone"));
                System.out.println("logado como: " + rs.getString("nome"));
                System.out.println("id de login: " +rs.getString("id"));
                
                idenv = Integer.parseInt(rs.getString("id"));
                mensagens mensagens = new mensagens();
                mensagens.setVisible(true);
                
                
                this.dispose();

            } else {
                System.out.println("nao encontrado");
            }

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao entrar, tente novamente"
                ,"ERRO",JOptionPane.ERROR_MESSAGE);
        }


        }
    }//GEN-LAST:event_tftelKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblentre;
    private javax.swing.JTextField tftel;
    // End of variables declaration//GEN-END:variables
}
