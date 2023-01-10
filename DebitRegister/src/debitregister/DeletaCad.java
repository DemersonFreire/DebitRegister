package debitregister;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeletaCad {
    
    public DeletaCad(){
        
        Connection con = ConnectionBD.getConnection();
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:","Busca", 3);
        String Confirma = "SELECT Nome FROM Cliente WHERE CPF ='"+cpf+"'";
        String limpa = "DELETE FROM Cliente WHERE CPF ='"+cpf+"'";
        
        try {
            PreparedStatement stmt = con.prepareStatement(Confirma);
            ResultSet result = stmt.executeQuery();
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "CPF não cadastrado! Tente novamente.", "Aviso", 0);
            }else{
                Statement stm = con.createStatement();
                int res = stm.executeUpdate(limpa);
                JOptionPane.showMessageDialog(null, "Cliente deletado do banco de dados!", "Aviso", 1);
                
                stm.close();
            } 
            
            stmt.close();
            result.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
