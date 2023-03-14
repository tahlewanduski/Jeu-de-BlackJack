package cartes.monJeu.vue;

import java.awt.event.*;

/**
 * Classe PaquetListener permettant de gerer les clics de souris dans un bouton qui commande le paquet.
 */
public class PaquetListener implements ActionListener {
    private VuePaquetVisible source;
    private boolean asc;

    /**
     * Constructeur de la classe PaquetListener.
     * @param source La vue du paquet.
     * @param asc Un boolean qui dit si le paquet doit être trié par ordre croissant ou décroissant.
     */
    public PaquetListener(VuePaquetVisible source, boolean asc) {
        this.source = source;
        this.asc = asc;
    }

    /**
     * Methode permettant de trier part ordre croissant ou décroissant lors d'un clic sur le bouton.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(this.asc) {
            this.source.trierCroissant();
        } else {
            this.source.trierDecroissant();
        }
    }
    
}
