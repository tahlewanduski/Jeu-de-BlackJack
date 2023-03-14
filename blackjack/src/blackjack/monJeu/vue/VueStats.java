package blackjack.monJeu.vue;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import blackjack.monJeu.modele.Game;

/**
 * Classe permettant d'afficher les statistiques du jeu.
 */
public class VueStats extends JPanel {

    public VueStats(Game game, MainFrame frame) {
        super();
        // this.setLayout(new GridLayout(1, 3));
        this.setLayout(null);
        JButton b = new JButton("Passer");
        this.add(b);
        b.setBounds(25, 25, 100, 50);
        b.addActionListener(new ClickListener(game, frame)); 
        JLabel l = new JLabel("Stats : " + game.getPlayerScore().get(0)+ " victoire et " + game.getPlayerScore().get(1) + " defaite");
        this.add(l);
        l.setBounds(150, 0, 500, 100);
        JButton b2 = new JButton("Quitter");
        this.add(b2);
        b2.setBounds(599, 25, 100, 50);
        b2.addActionListener(e -> System.exit(0)); 
        this.setVisible(true);
        this.setBackground(new Color(10, 200, 10, 150));
        // this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

    }

}