package sort;

import model.Tropa;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static List<Tropa> ordenar(List<Tropa> tropas) {

        List<Tropa> tropasCopia = new ArrayList<>(tropas);
        for (int i = 1; i < tropasCopia.size(); i++){
            Tropa tropaAtual = tropasCopia.get(i);
            int j = i - 1;
            while (j >= 0 && tropasCopia.get(j).getPrioridade() > tropaAtual.getPrioridade()) {
                tropasCopia.set(j + 1, tropasCopia.get(j));
                j--;
            }
            tropasCopia.set(j + 1, tropaAtual);
            }
        return tropasCopia;
    }
}
