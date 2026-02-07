package util;

import model.Tropa;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ImprimirCampo {

    private static final Random random = new Random();

    public static void imprimir(List<Tropa> tropas, int tamanhoCampo, String tipoLista, String titulo, int[] unidades, String algoritmo) {

        if (titulo.equals("INICIAL")) {
            System.out.println("Algorithm=" + algoritmo);
            System.out.println("Type=" + tipoLista);

            for (int i = 0; i < unidades.length; i++) {
                System.out.print(unidades[i]);
                if (i < unidades.length - 1) System.out.print(",");
            }
            System.out.println();
            System.out.println("Battlefield=" + tamanhoCampo);
            System.out.println();
        }

        System.out.println("Posicao " + titulo.toLowerCase() + ":");

        String[][] campo = new String[tamanhoCampo][tamanhoCampo];
        for (int linha = 0; linha < tamanhoCampo; linha++) {
            for (int coluna = 0; coluna < tamanhoCampo; coluna++) {
                campo[linha][coluna] = "*";
            }
        }

        if (titulo.equals("INICIAL")) {
            List<Integer> posicoes = new ArrayList<>();
            for (int i = 0; i < tamanhoCampo * tamanhoCampo; i++) {
                posicoes.add(i);
            }

            Collections.shuffle(posicoes, random);

            for (int i = 0; i < tropas.size(); i++) {
                int posicao = posicoes.get(i);
                int linha = posicao / tamanhoCampo;
                int coluna = posicao % tamanhoCampo;
                campo[linha][coluna] = tropas.get(i).getRepresentacao(tipoLista);
            }
        }
        else {
            for (Tropa tropa : tropas) {
                String rep = tropa.getRepresentacao(tipoLista);
                int linhaAlvo = -1;

                if (rep.equals("1") || rep.equals("0") || rep.equalsIgnoreCase("C")) {
                    linhaAlvo = tamanhoCampo - 1;
                }
                else if (rep.startsWith("1") || rep.equalsIgnoreCase("M")) {
                    linhaAlvo = tamanhoCampo - 2;
                }
                else if (rep.startsWith("2") || rep.equalsIgnoreCase("T")) {
                    linhaAlvo = tamanhoCampo - 3;
                }
                else if (rep.startsWith("3") || rep.equalsIgnoreCase("S")) {
                    linhaAlvo = tamanhoCampo - 4;
                }
                else if (rep.startsWith("4") || rep.equalsIgnoreCase("I")) {
                    linhaAlvo = tamanhoCampo - 5;
                }

                if (linhaAlvo >= 0 && linhaAlvo < tamanhoCampo) {
                    for (int col = tamanhoCampo - 1; col >= 0; col--) {
                        if (campo[linhaAlvo][col].equals("*")) {
                            campo[linhaAlvo][col] = rep;
                            break;
                        }
                    }
                }
            }
        }

        for (int linha = 0; linha < tamanhoCampo; linha++) {
            for (int coluna = 0; coluna < tamanhoCampo; coluna++) {
                if (coluna > 0) System.out.print(" ");
                System.out.print(campo[linha][coluna]);
            }
            System.out.println();
        }
    }
}