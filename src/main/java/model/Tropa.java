package model;

public abstract class Tropa {
    protected int prioridade;
    protected char simbolo;

    public Tropa(int prioridade, char simbolo) {
        this.prioridade = prioridade;
        this.simbolo = simbolo;
    }

    public int getIndiceLinha() {
        if (this.prioridade == 1) return 0;
        if (this.prioridade == 11) return 1;
        if (this.prioridade == 21) return 2;
        if (this.prioridade == 31) return 3;
        if (this.prioridade == 41) return 4;
        return 0;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String getRepresentacao(String tipoLista) {
        if (tipoLista.equalsIgnoreCase("n")) {
            return String.valueOf(prioridade);
        } else {
            return String.valueOf(simbolo);
        }
    }
}
