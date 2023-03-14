package blackjack.monJeu.control;

import blackjack.monJeu.modele.*;
import blackjack.monJeu.vue.*;

/**
 * Classe permettant de controler les clics sur les boutons "Passer" et "Rejoueu".
 */
public class GameController {
    private Game game;
    private MainFrame frame;
    private AndWeHaveAWinnerView view;

    /**
     * Constructeur de la classe pour la vue du plateau.
     */
    public GameController(Game game, MainFrame frame) {
        this.game = game;
        this.frame = frame;
    }

    /**
     * Constructeur de la classe pour la vue de fin de partie.
     */
    public GameController(Game game, AndWeHaveAWinnerView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Methode permettant de lancer une nouvelle partie.
     */
    public void start() {
        this.game.start();
        this.view.rejouer();
    }

    /**
     * Methode permettant de passer son tour et faire jouer les IA.
     */
    public void play() {
        this.game.play();
        this.frame.getPv().repaint();
        this.frame.winnerView();
    }
}
