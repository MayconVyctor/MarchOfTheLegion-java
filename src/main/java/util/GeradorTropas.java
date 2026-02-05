package util;

import model.*;
import config.Configuracao;
import java.util.List;
import java.util.ArrayList;

public class GeradorTropas {

    public static List<Tropa> gerarTropas(Configuracao configuracao) {
        List<Tropa> tropas = new ArrayList<>();

        for (int i = 0; i < configuracao.getUnidades()[0]; i++){
            tropas.add(new Comandante());
        }
        for (int i = 0; i < configuracao.getUnidades()[1]; i++) {
            tropas.add(new Medico());
        }
        for (int i = 0; i < configuracao.getUnidades()[2]; i++) {
            tropas.add(new Tanque());
        }
        for (int i = 0; i < configuracao.getUnidades()[3]; i++) {
            tropas.add(new Atirador());
        }
        for (int i = 0; i < configuracao.getUnidades()[4]; i++) {
            tropas.add(new Infantaria());
        }
        return tropas;
    }
}
