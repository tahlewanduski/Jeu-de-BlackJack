package cartes.monJeu.vue;

import java.awt.event.*;

/**
 * Classe PiocheListener permettant de gerer les clics de souris dans un bouton qui commande la pioche.
 */
public class PiocheListener implements ActionListener {
    private VuePaquetCache source;

    /**
     * Constructeur de la classe PiocheListener qui va controller le clic sur le bouton melanger.
     * @param source La vue du paquet.
     */
    public PiocheListener(VuePaquetCache source) {
        this.source = source;
    }

    /**
     * Methode permettant de melanger le paquet lors d'un clic sur le bouton.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.source.melanger();
    }
    
}
