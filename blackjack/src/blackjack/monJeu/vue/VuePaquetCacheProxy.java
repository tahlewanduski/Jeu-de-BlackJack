package blackjack.monJeu.vue;

import cartes.monJeu.vue.*;
import blackjack.monJeu.modele.Game;
import cartes.monJeu.modele.*;

/**
 * Proxy pour la vue du paquet caché pour prendre en compte le fait que la valeur de la main du joueur est suppérieure à 21 auquel cas on arrête de piocher.
 */
public class VuePaquetCacheProxy extends VuePaquetCache {

    public VuePaquetCacheProxy(Paquet paquet, Paquet destination) {
        super(paquet, destination);
    }
    
    @Override
    public void onClick(VueCarte c, boolean v) {
        if(Game.value_Deck(destination) <= 21) {
            this.removeAll();
            this.controleur.piocher();
        }
    }

    public void setDestination(Paquet destination) {
        this.destination = destination;
    }
}
