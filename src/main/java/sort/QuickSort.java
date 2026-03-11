package sort;
import java.util.List;
import model.Tropa;

public class QuickSort {
    public static List<Tropa> ordenar(List<Tropa> tropas) {
        quickSort(tropas, 0, tropas.size() - 1);
        return tropas;
    }

    private static void quickSort(List<Tropa> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIdx = particionar(lista, inicio, fim);
            quickSort(lista, inicio, pivoIdx - 1);
            quickSort(lista, pivoIdx + 1, fim);
        }
    }

    private static int particionar(List<Tropa> lista, int inicio, int fim) {
        int pivo = lista.get(fim).getPrioridade();
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            if (lista.get(j).getPrioridade() <= pivo) {
                i++;
                Tropa temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        Tropa temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, temp);
        return i + 1;
    }
}