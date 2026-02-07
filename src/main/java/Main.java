import java.util.Collections;
import java.util.List;
import config.ValidarParametros;
import config.Configuracao;
import util.GeradorTropas;
import util.ImprimirCampo;
import sort.InsertionSort;
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
                config.getAlgoritmo()
        );


        List<Tropa> ordenadas = InsertionSort.ordenar(tropas);
        ImprimirCampo.imprimir(
                ordenadas,
                config.getTamanhoCampo(),
                config.getTipoLista(),
                "FINAL",
                config.getUnidades(),
                config.getAlgoritmo()
        );
    }
}