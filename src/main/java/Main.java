import java.util.List;
import config.ValidarParametros;
import config.Configuracao;
import util.GeradorTropas;
import util.ImprimirCampo;
import sort.InsertionSort;
import sort.SelectionSort;
import sort.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        Configuracao config = ValidarParametros.validar(args);
        if (config == null) {
            System.err.println("Erro: Parametros invalidos. Encerrando");
            return;
        }

        List<Tropa> tropas = GeradorTropas.gerarTropas(config);


        ImprimirCampo.imprimir(
                tropas,
                config.getTamanhoCampo(),
                config.getTipoLista(),
                "INICIAL",
                config.getUnidades(),
                config.getAlgoritmo(),
                config.getOrientacao()
        );

        List<Tropa> ordenadas;
        String alg = config.getAlgoritmo().toLowerCase();
        if (alg.equals("s")) {
            ordenadas = SelectionSort.ordenar(tropas);
        } else if (alg.equals("b")) {
            ordenadas = BubbleSort.ordenar(tropas);
        } else if (alg.equals("q")) {
            ordenadas = QuickSort.ordenar(tropas);
        } else if (alg.equals("m")) {
            ordenadas = MergeSort.ordenar(tropas);
        } else {
            ordenadas = InsertionSort.ordenar(tropas);
        }
        ImprimirCampo.imprimir(
                ordenadas,
                config.getTamanhoCampo(),
                config.getTipoLista(),
                "FINAL",
                config.getUnidades(),
                config.getAlgoritmo(),
                config.getOrientacao()
        );
    }
}