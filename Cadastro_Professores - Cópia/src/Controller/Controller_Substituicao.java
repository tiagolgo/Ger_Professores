/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Disciplinas;
import Entidades.Professora;
import Entidades.Substituica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Controller_Substituicao {

    private StringBuilder not = new StringBuilder();

    public void persiste(Substituica s) {
    }

    public Substituica deleta(Substituica s) {
        for (Disciplinas disciplinas : s.getDisciplinas()) {
            s.getSubstituto().getDisciplinas().remove(disciplinas);
            disciplinas.setSuprida(false);
            s.getSubstituto().getDisciplinas();
        }
        for (Object object : s.getSubstituto().getDisciplinas()) {
        }
        return s;
    }

    public StringBuilder verificaCHSubstituto(Professora s, List<Disciplinas> disciplina) {
        //pegar a carga horária do substituto, adicionar com a carga horária das discipllinas
        //e verificar se a carga horária extrapola a ch permitida
        int ch = s.getCargaHoraria();

        int total = 0;
        for (Disciplinas d : disciplina) {
            total += d.getCargaHoraria();
        }

        if ((ch + total) > 42) {
            this.not.append("Não é possível realizar a substituição. O Substituto possui excesso na Carga Horária de " + total + "H/A");
        }
        return not;
    }
}
