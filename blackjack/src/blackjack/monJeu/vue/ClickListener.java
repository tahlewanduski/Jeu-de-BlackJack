package blackjack.monJeu.vue;

import java.awt.event.*;

import blackjack.monJeu.control.GameController;
import blackjack.monJeu.modele.Game;

/**
 * Classe permettant de gérer les clics sur le bouton "Passer".
 */
public class ClickListener implements ActionListener {
    private GameController controller;

    public ClickListener(Game game, MainFrame frame) {
        this.controller = new GameController(game, frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.play();
    }
    
}
