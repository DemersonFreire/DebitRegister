package debitregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BuscaDebito {
    
    String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:","Busca", 3);
    String busca = "SELECT nome, valor, to_char(dia, 'DD/MM/YYYY') as \"Dia\" FROM Cliente, Compra WHERE Cliente.CPF = '"+ cpf +"' AND Compra.CPF = '"+ cpf +"'";
    String soma = "SELECT SUM (Valor) FROM Compra WHERE CPF = '"+cpf+"'";
    
    public List<Compra> Listar(){
        
        List <Compra> compras = new ArrayList<>();
        Connection con = ConnectionBD.getConnection();
        
        
        try {
            PreparedStatement stmt = con.prepareStatement(busca);
            PreparedStatement stmt2 = con.prepareStatement(soma);
            ResultSet result = stmt.executeQuery();
            ResultSet result2 = stmt2.executeQuery();
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!", "Aviso", 0);
            }
            
            while (result2.next()){
                String Soma = result2.getString("sum");
                
                String Somatorio = (Soma);
               
                System.out.println("Valor total: "+Somatorio);
            }
            
            while (result.next()){
                
                Compra compra = new Compra();
                
                compra.setNome(result.getString("Nome"));
                compra.setValor(result.getString("Valor"));
                compra.setDia(result.getString("Dia"));
               
                compras.add(compra);
                
            }
          
            stmt.close();
            result.close();
            stmt2.close();
            result2.close();
            con.close();
            
        } catch (SQLException ErroSQL) {
            return null;
        }
        return compras;
        
    }    
    
}
