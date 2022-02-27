package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {

        /* Injection des dépendances par instanciation statique*/
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
