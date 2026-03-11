package util;

import model.Tropa;
import java.util.*;

public class ImprimirCampo {

    public static void imprimir(List<Tropa> tropas, int tamanhoCampo, String tipoLista, String titulo, int[] unidades, String algoritmo, String orientacao) {

        if (titulo.equals("INICIAL")) {
            System.out.println("Algoritomo = " + algoritmo);
            System.out.println("Type = " + tipoLista);

            for (int i = 0; i < unidades.length; i++) {
                System.out.print(unidades[i]);
                if (i < unidades.length - 1) System.out.print(",");
            }
            System.out.println();
            System.out.println("Battlefield = " + tamanhoCampo);
            System.out.println();
        }

        System.out.println("Posição " + titulo.toLowerCase() + ":");

        String[][] campo = new String[tamanhoCampo][tamanhoCampo];
        for (String[] linha : campo) Arrays.fill(linha, "*");

        if (titulo.equals("INICIAL")) {
            distribuirAleatorio(campo, tropas, tamanhoCampo, tipoLista);
        } else {

            for (Tropa t : tropas) {
                String rep = t.getRepresentacao(tipoLista);
                int idx = t.getIndiceLinha();

                switch (orientacao.toLowerCase()) {
                    case "s": preencher(campo, idx, -1, rep, tamanhoCampo); break;
                    case "n": preencher(campo, (tamanhoCampo - 1) - idx, -1, rep, tamanhoCampo); break;
                    case "e": preencher(campo, -1, idx, rep, tamanhoCampo); break;
                    case "w": preencher(campo, -1, (tamanhoCampo - 1) - idx, rep, tamanhoCampo); break;
                }
            }
        }
        desenhar(campo);
    }

    private static void preencher(String[][] campo, int linhaAlvo, int colAlvo, String rep, int tam) {
        if (linhaAlvo != -1) {
            for (int c = tam - 1; c >= 0; c--) {
                if (campo[linhaAlvo][c].equals("*")) {
                    campo[linhaAlvo][c] = rep;
                    return;
                }
            }
        } else {
            for (int l = tam - 1; l >= 0; l--) {
                if (campo[l][colAlvo].equals("*")) {
                    campo[l][colAlvo] = rep;
                    return;
                }
            }
        }
    }

    private static void distribuirAleatorio(String[][] campo, List<Tropa> tropas, int tam, String tipo) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < tam * tam; i++) pos.add(i);
        Collections.shuffle(pos);
        for (int i = 0; i < tropas.size(); i++) {
            int p = pos.get(i);
            campo[p / tam][p % tam] = tropas.get(i).getRepresentacao(tipo);
        }
    }

    private static void desenhar(String[][] campo) {
        for (String[] linha : campo) {
            for (int j = 0; j < linha.length; j++) {
                System.out.print(linha[j] + (linha[j].length() > 1 ? " " : "  "));
            }
            System.out.println();
        }
        System.out.println();
    }
}