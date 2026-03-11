package config;

public class ValidarParametros {
    public static Configuracao validar(String[] args) throws IllegalArgumentException {
        if (args.length < 3) {
            System.err.println("Erro: Parametros insuficientes use: a=... t=... u=...");
            return null;
        }

        String[] a = args[0].split("=", 2);
        if (a.length != 2 || !a[0].equalsIgnoreCase("a")) {
            System.err.println("Erro: Parametro invalido para algoritmo use: a=...");
            return null;
        }
        String algoritmo = a[1].trim();
        if (!algoritmo.equalsIgnoreCase("i") && !algoritmo.equalsIgnoreCase("s") &&
                !algoritmo.equalsIgnoreCase("b") && !algoritmo.equalsIgnoreCase("q") &&
                !algoritmo.equalsIgnoreCase("m")) {
            System.err.println("Erro: Use i (Insertion), s (Selection), b (Bubble), q (Quick) ou m (Merge)");
            return null;
        }


        String[] t = args[1].split("=", 2);
        if (t.length != 2 || !t[0].equalsIgnoreCase("t")) {
            System.err.println("Erro: Parametro invalido para tipo de lista use: t=...");
            return null;
        }
        String tipoLista = t[1].trim();
        if (!tipoLista.equalsIgnoreCase("n") && !tipoLista.equalsIgnoreCase("c")) {
            System.err.println("Erro: Tipo de lista invalido use: n para numeros ou c para caracteres");
            return null;
        }


        int tamanhoCampo = 10;
        for (String arg : args) {
            if (arg.startsWith("f=")) {
                try {
                    tamanhoCampo = Integer.parseInt(arg.substring(2));
                } catch (NumberFormatException e) {
                    System.err.println("Erro: Valor de f deve ser numerico");
                    return null;
                }
            }
        }


        if (tamanhoCampo < 5 || tamanhoCampo > 1000) {
            System.err.println("Tamanho do campo de batalha invalido");
            return null;
        }


        String[] u = args[2].split("=", 2);
        if (u.length != 2 || !u[0].equalsIgnoreCase("u")) {
            System.err.println("Erro: Parametro invalido para unidades use: u=");
            return null;
        }

        String unidadesStr = u[1].trim();
        int[] unidades = new int[5];
        try {
            String[] unidadesArray = unidadesStr.split(",");
            if (unidadesArray.length != 5) {
                System.err.println("Erro: O parametro u deve conter 5 valores (ex: 1,1,2,3,5)");
                return null;
            }

            int totalUnidades = 0;
            for (int i = 0; i < 5; i++) {
                unidades[i] = Integer.parseInt(unidadesArray[i].trim());
                if (unidades[i] < 0) {
                    System.err.println("Erro: Valores de unidades nao podem ser negativos");
                    return null;
                }
                totalUnidades += unidades[i];
            }


            int capacidadeMaxima = tamanhoCampo * tamanhoCampo;
            if (totalUnidades > capacidadeMaxima) {
                System.err.println("Erro: Total de unidades (" + totalUnidades + ") excede a capacidade do campo " + tamanhoCampo + "x" + tamanhoCampo);
                return null;
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro: Valores de unidades devem ser numeros inteiros");
            return null;
        }


        String orientacao = "s";
        for (String arg : args) {
            if (arg.startsWith("o=")) {
                String[] o = arg.split("=", 2);
                if (o.length == 2) {
                    orientacao = o[1].trim().toLowerCase();
                    if (!orientacao.equals("n") && !orientacao.equals("s") &&
                            !orientacao.equals("e") && !orientacao.equals("w")) {
                        System.err.println("Erro: Orientacao invalida use: n, s, e ou w");
                        return null;
                    }
                }
            }
        }

        return new Configuracao(algoritmo, tipoLista, orientacao, unidades, tamanhoCampo);
    }
}