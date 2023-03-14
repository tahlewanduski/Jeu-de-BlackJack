package cartes;

import cartes.monJeu.vue.MainFrame;
import cartes.monJeu.vue.PiocheFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame v = new MainFrame();
        new PiocheFrame(v.getPioche().getPaquet(), v.getPaquet().getPaquet());
    }
}
