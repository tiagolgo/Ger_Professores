/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validações;

import Entidades.Disciplinas;
import Entidades.Professora;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Valida_CargaHoraria {

    public boolean verificaCH(Professora p, List<Disciplinas> l) {

        List<Disciplinas> d = p.getDisciplinas();

        int chp = 0;

        for (Disciplinas disciplina : d) {
            chp = chp + disciplina.getCargaHoraria();
        }

        int cha = 0;

        for (Disciplinas disc : l) {
            cha = cha + disc.getCargaHoraria();
        }

        if (chp + cha > 32) {
            return false;
        } else {
            return true;
        }

    }
}
