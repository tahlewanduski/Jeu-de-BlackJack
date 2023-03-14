package blackjack.monJeu.modele;

import java.util.*;

/**
 * Classe permettant de gérer les IA (les decisions qu'elles prennent).
 */
public class IA{

    /**
     1 => random
     2 => random ne pas depasser la limite
     */
    private Integer difficulty;
    private PlayerIA player;

    /**
     * Constucteur de la classe IA.
     * @param player Le joueur.
     */
    public IA(PlayerIA player) {
        this.difficulty = player.getDifficulty();
        this.player = player;
    }

    /**
     * Permet de savoir si l'IA doit piocher ou non.
     * @return Un booléen indiquant si l'IA doit piocher ou non.
     */
    public boolean howPlay() {
        if (this.difficulty == 1) {
            Random rand = new Random();
            return rand.nextBoolean();
        }
        else if (this.difficulty == 2) {
            int limites = (new Random()).nextInt(5)+17; // random(17,21);
            // if(Game.value_Deck(this.player.getDeck()) < limites) {
            //     return true;
            // }
            // else {
            //     return false;
            // }
            return Game.value_Deck(this.player.getDeck()) < limites;
        }
        return false;
    }
    
    /**
     * @param difficulty L'indice de difficulté d l'IA
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDifficulty() {
        return this.difficulty;
    }
}