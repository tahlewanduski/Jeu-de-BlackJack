package blackjack.monJeu.vue;
import java.awt.*;
import javax.swing.*;

import blackjack.monJeu.modele.Game;
import cartes.util.EcouteurModele;

/**
 * Classe permettant d'afficher le gagnant du jeu ainsi que les valeurs des mains des autres joueurs.
 */
public class AndWeHaveAWinnerView extends JPanel implements EcouteurModele {
    private MainFrame frame;
    private JLabel l;
    
    public AndWeHaveAWinnerView(Game game, MainFrame frame) {
        super();
        // this.setLayout(new GridLayout(1, 3));
        this.setLayout(null);
        this.setSize(800, 700);
        this.setBackground(new Color(10, 200, 10));
        //this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        JButton b = new JButton("Rejouer");
        
        String text = "Le "+game.getWinner() + " a gagné.";
        this.l = new JLabel(text);
        l.setBounds(150, 0, 500, 100);
        this.add(l);
        this.add(b);
        b.setBounds(25, 25, 100, 50);
        b.addActionListener(new ClickListener2(game, this)); 
        JButton b2 = new JButton("Quitter");
        this.add(b2);
        b2.setBounds(599, 25, 100, 50);
        b2.addActionListener(e -> System.exit(0)); 
        this.frame = frame;
        JLabel l2 = new JLabel("Valeur des cartes : ");
        this.add(l2);
        l2.setBounds(20, 75, 500, 25);
        JLabel playerScore = new JLabel("Joueur 1 : " + Game.value_Deck(game.getDeckPlayer()));
        JLabel banquierScore = new JLabel("Banquier : " + Game.value_Deck(game.getDeckBanquier()));
        this.add(playerScore);
        this.add(banquierScore);
        playerScore.setBounds(25, 100, 200, 25);
        banquierScore.setBounds(25, 125, 200, 25);
        for (int i = 0; i < game.getDeckIa().size(); i++) {
            JLabel card = new JLabel("Joueur " + (i+2) + " : " + Game.value_Deck(game.getDeckIa().get(i)));
            this.add(card);
            card.setBounds(25,  150 + i * 25, 200, 25);
        }

    }

    public void rejouer(){
        this.repaint();
        frame.PlateauView();
    }

    @Override
    public void modeleMisAJour(Object source) {
        this.repaint();
    }
}
