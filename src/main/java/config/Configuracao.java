package config;

public class Configuracao {
    private String algoritmo;
    private String tipoLista;
    private int[] unidades;
    private int tamanhoCampo;

    public Configuracao(String algoritmo, String tipoLista, int[] unidades, int tamanhoCampo){
        this.algoritmo = algoritmo;
        this.tipoLista = tipoLista;
        this.unidades = unidades;
        this.tamanhoCampo = tamanhoCampo;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getTipoLista() {
        return tipoLista;
    }

    public int[] getUnidades() {
        return unidades;
    }

    public int getTamanhoCampo() {
        return tamanhoCampo;
    }
}
