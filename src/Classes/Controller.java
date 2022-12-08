package Classes;

public class Controller {

    String nomeEstab = "Loja de manutencao - LTDA"; 
    String cnpjEstab = "15.487.963/0001-51";
    String enderecoEstab = "Av. Tupi, 295, Pato Branco - PR";
    String telefoneEstab = "3556-4879";
    String emailEstab = "loja@manutencao.com";
    
    public boolean validaSemNum (String entrada) {
        for (int i = 0; i<entrada.length(); i++) {
            if (Character.isDigit(entrada.charAt(i))) {
                return true; 
            }
        }
        return false;
    }
}