import java.util.ArrayList;
import java.util.List;
import config.ValidarParametros;
import config.Configuracao;
import util.GeradorTropas;
import sort.InsertionSort;
import model.*;

public class Main {
    public static void main(String[] args) {
        Configuracao config = ValidarParametros.validar(args);
        if (config == null) {
            System.err.println("Erro: Parametros invalidos. Encerrando...");
            return;
        }
        List<Tropa> tropas = GeradorTropas.gerarTropas(config);
        System.out.println("Total de tropas geradas: " + tropas.size());

        List<Tropa> teste = new ArrayList<>();
        teste.add(new Infantaria());
        teste.add(new Comandante());
        teste.add(new Tanque());

        List<Tropa> ordenado = InsertionSort.ordenar(teste);

        System.out.print("Ordem final: ");
        for (Tropa t : ordenado) {
            System.out.print(t.getPrioridade() + " ");
        }
// Saída esperada: "1 21 41"
    }
}