package sort;

import java.util.List;
import model.Tropa;

public class SelectionSort {

    public static List<Tropa>  ordenar(List<Tropa> tropas) {
        int n = tropas.size();

        for (int i = 0; i < n - 1; i++) {
            int menorValor = i;
            for (int j = i + 1; j < n; j++) {
                if (tropas.get(j).getPrioridade() < tropas.get(menorValor).getPrioridade()) {
                    menorValor = j;
                }
            }
            Tropa temp = tropas.get(menorValor);
            tropas.set(menorValor, tropas.get(i));
            tropas.set(i, temp);
        }
        return tropas;
    }
}

