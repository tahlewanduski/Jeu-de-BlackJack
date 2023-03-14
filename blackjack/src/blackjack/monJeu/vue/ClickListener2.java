package blackjack.monJeu.vue;

import java.awt.event.*;

import blackjack.monJeu.control.GameController;
import blackjack.monJeu.modele.Game;

/**
 * Classe permettant de gérer les clics sur le bouton "Rejouer".
 */
public class ClickListener2 implements ActionListener {
    private GameController controller;

    public ClickListener2(Game game, AndWeHaveAWinnerView view) {
        this.controller = new GameController(game, view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.start();
    }
    
}
