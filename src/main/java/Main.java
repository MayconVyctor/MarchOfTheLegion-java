import config.ValidarParametros;
import config.Configuracao;

public class Main {
    public static void main(String[] args) {
        Configuracao config = ValidarParametros.validar(args);
        if (config == null) {
            System.out.println();
            return;
        }

    }
}