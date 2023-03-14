package cartes;


import javax.swing.*;

import cartes.monJeu.modele.*;
import cartes.monJeu.vue.*;

public class MainAffichage {
    public static void cards() {
        Carte carte1 = new Carte("10", "pique", 10);
        JFrame f = new JFrame(" test");
        VueCarte v = new VueCarte(carte1, true, 0, 0, 100, 200);
        VueCarte v2 = new VueCarte(carte1, false, 110, 0, 100, 200);
        f.add(v);
        f.add(v2);
        f.setSize(800,1000);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//     public static void windows() {
//         JFrame f = new JFrame("test");
//         Carte carte1 = new Carte("10", "pique", 10);
//         Carte carte2 = new Carte("10", "coeur", 10);
//         Carte carte3 = new Carte("10", "trefle", 10);
//         Carte carte4 = new Carte("10", "carreau", 10);
//         Paquet paquet = new Paquet();
//         paquet.ajouterCarte(carte1);
//         paquet.ajouterCarte(carte2);
//         paquet.ajouterCarte(carte3);
//         paquet.ajouterCarte(carte4);
//         Container c = f.getContentPane();
//         c.setLayout(null);
//         VuePaquet v = new VuePaquetCache(PaquetFactory.paquet52());
//         VuePaquet v2 = new VuePaquetVisible(paquet);
//         v.setBounds(0, 0, 800, 300);
//         v2.setBounds(0, 300, 800, 300);
//         c.add(v);
//         c.add(v2);
//         // f.pack();
//         f.setSize(800,1000);
//         f.setLayout(null);
//         f.setLocationRelativeTo(null);
//         f.setVisible(true);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
}
