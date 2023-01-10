package debitregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class BuscaCPF {
    
    public BuscaCPF(){
        Connection con = ConnectionBD.getConnection();
        String name = JOptionPane.showInputDialog(null, "Informe o nome do cliente:","Busca", 3);
        String nome = "SELECT CPF FROM Cliente WHERE Nome = '"+name+"'";
        
        try {
            PreparedStatement stmt = con.prepareStatement(nome);
            ResultSet result = stmt.executeQuery();
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "CPF não cadastrado!", "Aviso", 0);
            }
            
            while (result.next()){
                String CPF = result.getString("CPF");
                System.out.println("O CPF de "+name+" eh "+CPF);
            }
            
            stmt.close();
            result.close();
            con.close();
            
        } catch (SQLException e) {
        }
    }
}
