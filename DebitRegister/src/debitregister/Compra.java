package debitregister;

import javax.swing.JOptionPane;

public class Compra {
    
    private String Nome;
    private String Valor;
    private String Dia;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }
    
    public void MostraBusca(){
        System.out.println("Nome :"+getNome());
        System.out.println("Valor :"+getValor());
        System.out.println("Data :"+getDia());
       
    }
}
