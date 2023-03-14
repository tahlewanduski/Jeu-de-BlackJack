package cartes.monJeu.vue;

import javax.swing.*;
import java.awt.*;

import cartes.monJeu.modele.*;

/**
 * Classe PiocheFrame representant la fenêtre de pioche visible.
 * 
 */
public class PiocheFrame extends JFrame {
    /**
     * Constructeur de la classe PiocheFrame affichant les cartes dans la pioche.
     * @param pioche La pioche
     * @param paquet Le paquet de destination
     */
    public PiocheFrame(Paquet pioche, Paquet paquet) {
        super("Pioche");
        Container c = this.getContentPane();

        VuePaquetVisible piocheVisible = new VuePaquetVisible(pioche, paquet);
        piocheVisible.setFenetre(this);
        piocheVisible.setBounds(0, 0, 800, 250);
        c.add(piocheVisible);

        this.setSize(800, 250);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
