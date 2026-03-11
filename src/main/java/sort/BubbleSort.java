package sort;

import java.util.List;
import model.Tropa;

public class BubbleSort {
    public static List<Tropa> ordenar(List<Tropa> tropas) {
        int n = tropas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tropas.get(j).getPrioridade() > tropas.get(j + 1).getPrioridade()) {
                    // Troca (Swap)
                    Tropa temp = tropas.get(j);
                    tropas.set(j, tropas.get(j + 1));
                    tropas.set(j + 1, temp);
                }
            }
        }
        return tropas;
    }
}

