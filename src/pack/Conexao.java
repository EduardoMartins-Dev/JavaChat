package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection con = null;
 
       public static void Conectar() {
       System.out.println("Conectando ao banco...");
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/c","root","usbw");
            System.out.println("Conectado.");
       } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
       } catch(SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao Conectar" + e,"ERRO",JOptionPane.INFORMATION_MESSAGE);
        throw new RuntimeException(e);
    }
    
   }
}
