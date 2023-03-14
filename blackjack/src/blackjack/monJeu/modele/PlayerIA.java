package blackjack.monJeu.modele;

import java.util.*;

import cartes.monJeu.modele.*;
import cartes.util.AbstractModeleEcoutable;

/**
 * Classe permettant de gérer les joueurs
 */
public class PlayerIA extends AbstractModeleEcoutable {

        /*la main du joueur */

        private Paquet deck;

        /*stats victoires/défaites */

        private ArrayList<Integer> stats;

        /*insérer une ia*/

        private boolean isIA;

        private IA iA;

        private Integer difficulty;

        /**
         * Constructeur de la classe PlayerIA.
         * @param deck La main du joueur.
         * @param isIA Un booléen indiquant si le joueur est une IA.
         * @param difficulte L'indice de difficulté de l'IA.
         */
        public PlayerIA(Paquet deck, boolean isIA, Integer difficulte) {
                super();
                this.deck = deck;
                this.stats = new ArrayList<Integer>();
                this.stats.add(0);
                this.stats.add(0);
                this.difficulty = difficulte;
                if(isIA) {
                        this.iA = new IA(this);
                }
                else {
                        this.iA = null;
                }
        }

        public Integer getDifficulty() {
                return difficulty;
        }

        /**
         * Permet de piocher une carte et de la mettre dans la main du joueur.
         * @param pioche La pioche du jeu.
         */
        public void take_card(Paquet pioche) {
                this.deck.ajouterCarte(pioche.piocheCarte());
                fireChangement();
        }

        @Override
        public String toString() {
                return "PlayerIA [deck=" + this.deck + ", stats=" + this.stats + "]";
        }
        
        public Paquet getDeck() {
                return deck;
        }
        
        public void setDeck(Paquet deck) {
                this.deck = deck;
                fireChangement();
        }

        public ArrayList<Integer> getStats() {
                return stats;
        }
        
        public void setStats(ArrayList<Integer> stats) {
                this.stats = stats;
                fireChangement();
        }

        public boolean isIA() {
                return isIA;
        }

        public void setIA(IA ia) {
                this.iA = ia;
        }

        public IA getIA() {
            return this.iA;
        }

        /**
         * Permet de mettre à jour les statistiques du joueur.
         * @param indice l'indice de la statistique à mettre à jour (0 : victoires, 1 : defaites).
         */
        public void incrementStats(int indice) {
                this.stats.set(indice, this.stats.get(indice)+1);
        }
        
}