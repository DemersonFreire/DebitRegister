package debitregister;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;;

public class RegistraCompra {
    
    RegistraCompra(){
        
        Connection con = ConnectionBD.getConnection();
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:","Busca", 3);
        String valor = JOptionPane.showInputDialog(null, "Informe o valor da compra:","Busca", 3);
        String Confirma = "SELECT Nome FROM Cliente WHERE CPF ='"+cpf+"'";
        String compra = "INSERT INTO Compra VALUES ("+ cpf +", "+ valor +", CURRENT_DATE);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(Confirma);
            ResultSet result = stmt.executeQuery();
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "CPF não cadastrado! Tente novamente.", "Aviso", 0);
            }else{
                Statement stm = con.createStatement();
                int res = stm.executeUpdate(compra);
                JOptionPane.showMessageDialog(null, "Compras registradas!", "Aviso", 1);
                
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
