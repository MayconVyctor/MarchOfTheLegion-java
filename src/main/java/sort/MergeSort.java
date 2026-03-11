package sort;
import java.util.List;
import java.util.ArrayList;
import model.Tropa;

public class MergeSort {
    public static List<Tropa> ordenar(List<Tropa> tropas) {
        if (tropas.size() <= 1) return tropas;

        int meio = tropas.size() / 2;
        List<Tropa> esquerda = new ArrayList<>(tropas.subList(0, meio));
        List<Tropa> direita = new ArrayList<>(tropas.subList(meio, tropas.size()));

        return mesclar(ordenar(esquerda), ordenar(direita));
    }

    private static List<Tropa> mesclar(List<Tropa> esq, List<Tropa> dir) {
        List<Tropa> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < esq.size() && j < dir.size()) {
            if (esq.get(i).getPrioridade() <= dir.get(j).getPrioridade()) {
                resultado.add(esq.get(i++));
            } else {
                resultado.add(dir.get(j++));
            }
        }
        resultado.addAll(esq.subList(i, esq.size()));
        resultado.addAll(dir.subList(j, dir.size()));
        return resultado;
    }
}