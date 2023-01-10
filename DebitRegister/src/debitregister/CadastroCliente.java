package debitregister;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroCliente {
    
    public CadastroCliente(){
        Connection con = ConnectionBD.getConnection();
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:","Busca", 3);
        String nome = JOptionPane.showInputDialog(null, "Informe o nome do cliente:","Busca", 3);
        String InsertCadastro = "INSERT INTO Cliente (CPF, Nome) VALUES ("+ cpf +", '"+ nome +"');";
        
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(InsertCadastro);
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado!", "Aviso", 1);
            
            stm.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
    }

   
}
