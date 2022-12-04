package Classes;

public class Controller {
    public boolean validaSemNum (String entrada) {
        for (int i = 0; i<entrada.length(); i++) {
            if (Character.isDigit(entrada.charAt(i))) {
                return true; 
            }
        }
        return false;
    }
}