package model;

public abstract class Tropa {
    protected int prioridade;
    protected char simbolo;
    protected int linha;
    protected int coluna;

    public Tropa(int prioridade, char simbolo) {
        this.prioridade = prioridade;
        this.simbolo = simbolo;
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

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getRepresentacao(String tipoLista) {
        if (tipoLista.equalsIgnoreCase("n")) {
            return String.valueOf(prioridade);
        } else {
            return String.valueOf(simbolo);
        }
    }
}
