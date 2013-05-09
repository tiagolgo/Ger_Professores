package modelo.curricular;

import java.util.ArrayList;

public class Serie {

    private ArrayList<Integer> serie;

    public Serie() {
        serie = new ArrayList();
        serie.add(1);
        serie.add(2);
        serie.add(3);
        serie.add(4);
        serie.add(5);
        serie.add(6);
        serie.add(7);
        serie.add(8);
        serie.add(9);
    }

    public boolean verificaSerie(int s) {

        if (serie.contains(s)) {
            return true;
        }
        return false;
    }
}
