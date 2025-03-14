package pack;

import static pack.Conexao.con;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import static pack.Login.idenv;
import static pack.Login.idrec;
public class mensagens extends javax.swing.JFrame {
    
    
    String msg;
    String contatoselec;
    public mensagens() {
        initComponents();
        //Conexao.Conectar();
        System.out.println(idenv);
        txtArea.setVisible(false);
        jPanel1.setVisible(false);
        
        DefaultListModel<String> listacont = new DefaultListModel<>();
        
        String sql;
        
        try{
        sql = "SELECT nome FROM contatos WHERE id != " + idenv;
            System.out.println(sql);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()){
        
        listacont.addElement(rs.getString("nome"));
        
        }
        listacontatos.setModel(listacont);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar, tente novamente " + e
                    ,"ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }
 public void verMsg(){
    Timer timer1 = new Timer();
    int delay=0; //delay 0seg
    int interval = 2000;//intervalo
    
    timer1.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        txtArea.setText("");
        
        try{
            //System.out.println(idreceb);
            String sql = "select * from mensagens where (idreceb =" + idrec + " and idenvio = " + idenv + ") or (idreceb = " +idenv 
                        + " and idenvio = " + idrec + ") order by data asc";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
    if (rs.getInt("idenvio") == idenv) {
        // Mostrar "Você" como remetente
        txtArea.append(rs.getString("data") + " " + rs.getString("hora")+" Você: " + rs.getString("mensagens")+ "\n");
    } else {
        // Mostrar o nome do contato como remetente
        String nomeRemetente = getNomeDoContatoPeloID(rs.getInt("idenvio"));
        txtArea.append(rs.getString("data") + " " + rs.getString("hora") +" "+ nomeRemetente + ": " + rs.getString("mensagens") + "\n");
    }
}

     } catch(SQLException e) {
             
     }
             } 

        private String getNomeDoContatoPeloID(int id) {
            
            try {
        String sql = "SELECT nome FROM contatos WHERE id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            return rs.getString("nome");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Nao obtivemos o nome do contato: " + e, "ERRO", JOptionPane.INFORMATION_MESSAGE);
    }
            
        return "Desconhecido";   
        }
         }, delay, interval);
}    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfmsg = new javax.swing.JTextField();
        lblnomemsg = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listacontatos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfmsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmsgActionPerformed(evt);
            }
        });
        tfmsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfmsgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfmsgKeyReleased(evt);
            }
        });
        jPanel1.add(tfmsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 330, -1));

        lblnomemsg.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        lblnomemsg.setText("Nome");
        jPanel1.add(lblnomemsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jButton2.setText("Clear Chat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 420, 310));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 430, 400));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel1.setText("Conversas");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        listacontatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listacontatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listacontatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 228, 400));

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel2.setText("Selecione a conversa desejada");
        jLabel2.setFocusable(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 370, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfmsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmsgActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        verMsg();
        String sql;
        msg = tfmsg.getText();
        
        String dataNova = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        String hora = dataNova.substring(11,19);
        String data = dataNova.substring(0,10);
        if (msg == null || msg.isEmpty()){
            JOptionPane.showMessageDialog(null, "A caixa de texto esta vazia",null,JOptionPane.ERROR_MESSAGE);
        }
        else if(idrec != idenv){
                appendMessage( data +" "+ hora +" Você: " + msg );
                
        System.out.println("hora: "+hora);
        System.out.println("data: " +data);
        

            sql = "insert into mensagens(idenvio, idreceb, data, hora, mensagens) values "
                    + "('" + idenv +"','" + idrec + "','" + data +"','" + hora +"','" + msg +"')";
        System.out.println("sql:"+sql);
        
        try{
            Statement stm = con.prepareStatement(sql);
            stm.execute(sql);
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro ao incluir, tente novamente" + e,"ERRO",JOptionPane.ERROR_MESSAGE);
            
        }
        
        tfmsg.setText("");
        msg = null;
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void listacontatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listacontatosMouseClicked
    txtArea.setText("");
        verMsg();
    // pega o clique na tabela
    int selected = listacontatos.getSelectedIndex();
    
    if (selected != -1) {
        contatoselec = listacontatos.getModel().getElementAt(selected);
        // consulta o id e o nome do contato
        String sql1 = "SELECT id, nome FROM contatos WHERE nome = ?";
        
        //  mostra o chat do contato selecionado
        txtArea.setText("");
        jPanel1.setVisible(true);
        txtArea.setVisible(true);
        
        // coloca o nome do contato selecionado no chat
        lblnomemsg.setText(contatoselec);
        
        //id e nome do contato selecionado na lista 
        try {
            PreparedStatement stm = con.prepareStatement(sql1);
            //substitui o primeiro ? do select sql1
            stm.setString(1, contatoselec);
            ResultSet rs1 = stm.executeQuery();
            
             
            if (rs1.next()) {
                
                System.out.println("Voce esta conversando com: ");
                System.out.println("nome: "+rs1.getString("nome"));
                System.out.println("idreceb: "+rs1.getString("id"));
                
                idrec = Integer.parseInt(rs1.getString("id"));
                //consulta as msg q eu enviei pro contato e as que o contato me enviou
                String sqlmsg = "select * from mensagens where (idreceb =" + idrec + " and idenvio = " + idenv + ") or (idreceb = " +idenv 
                        + " and idenvio = " + idrec + ") order by data desc limit 0,10";
                
                //System.out.println(sqlmsg);
                PreparedStatement stm1 = con.prepareStatement(sqlmsg);
                ResultSet rs2 = stm1.executeQuery();
                
                while (rs2.next()) {
    

            int idcontato = rs2.getInt("idreceb");

                String sqlnm = "SELECT c.nome FROM contatos c INNER JOIN mensagens m ON c.id = m.idreceb WHERE m.idreceb = ?";

                PreparedStatement stm4 = con.prepareStatement(sqlnm);
                stm4.setInt(1, idcontato);
                ResultSet rs4 = stm4.executeQuery();
        
            if (rs4.next()) {
            
                txtArea.append("  "+ rs4.getString(""+"nome") + rs2.getString("data") + ": " + rs2.getString("hora") + ": " + rs2.getString("mensagens") + "\n");
    
                txtArea.setCaretPosition(txtArea.getDocument().getLength());
        }
}
    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o ID do contato: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }


       
    }//GEN-LAST:event_listacontatosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        txtArea.setText("");
    
    String sql = "delete from mensagens where (idreceb =" + idrec + " and idenvio = " + idenv + ") or (idreceb = " +idenv 
                        + " and idenvio = " + idrec + ")"; 
    try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute(sql);
     
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao excluir " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
   JOptionPane.showMessageDialog(null, "historico de mensagens excluido com sucesso!", "Exclusão", JOptionPane.ERROR_MESSAGE);
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfmsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfmsgKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
        verMsg();    
        String sql;
        msg = tfmsg.getText();
        
        String dataNova = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        String hora = dataNova.substring(11,19);
        String data = dataNova.substring(0,10);
        if (msg == null || msg.isEmpty()){
            JOptionPane.showMessageDialog(null, "A caixa de texto esta vazia",null,JOptionPane.ERROR_MESSAGE);
        }
        else if(idrec != idenv){
                appendMessage( data +" "+ hora + " "+"Você: " + msg);
                
        System.out.println("hora: "+hora);
        System.out.println("data: " +data);
        

            sql = "insert into mensagens(idenvio, idreceb, data, hora, mensagens) values "
                    + "('" + idenv +"','" + idrec + "','" + data +"','" + hora +"','" + msg +"')";
        System.out.println("sql:"+sql);
        
        try{
            Statement stm = con.prepareStatement(sql);
            stm.execute(sql);
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro ao incluir, tente novamente" + e,"ERRO",JOptionPane.ERROR_MESSAGE);
            
        }

        tfmsg.setText("");
        msg = null;
        }}
    }//GEN-LAST:event_tfmsgKeyPressed

    private void tfmsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfmsgKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmsgKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jPanel1.setVisible(false);
        txtArea.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked
private void  appendMessage(String message) {
    
        txtArea.append(message + "\n");
        txtArea.setCaretPosition(txtArea.getDocument().getLength());
    }
   
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mensagens().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblnomemsg;
    private javax.swing.JList<String> listacontatos;
    private javax.swing.JTextField tfmsg;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
