package blackjack.monJeu.vue;

import java.awt.*;

import javax.swing.*;

import blackjack.monJeu.modele.*;
import cartes.util.EcouteurModele;

/**
 * Fenetre principale de l'application
 */
public class MainFrame extends JFrame implements EcouteurModele {
    private Game game;
    private int nbPlayers;
    private JPanel pv;
    private Container c;

    /**
     * Constructeur de la fenetre principale
     */
    public MainFrame() {
        super("Blackjack");
        this.setSize(800, 700);
        this.c = this.getContentPane();
        this.nbPlayers = 4;
        this.game = new Game(this.nbPlayers, true);
        this.game.start();
        this.pv = new PlateauView(this.game, this, this.nbPlayers);
        c.add(this.pv);
        
        this.game.getPaquet().ajoutEcouteur(this);
        this.game.getDeckPlayer().ajoutEcouteur(this);
        this.game.getDeckBanquier().ajoutEcouteur(this);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        
    }

    /**
     * Methode permettant d'afficher la fenetre de fin de partie
     */
    public void winnerView(){
        this.c.remove(this.pv);
        System.out.println("mf" + this.game.getWinner());
        this.pv = new AndWeHaveAWinnerView(this.game, this);
        this.c.add(this.pv);
        this.c.validate();
        this.repaint();

    }

    /**
     * Methode permettant de réafficher le jeu après une fin de partie
     */
    public void PlateauView(){
        this.c.remove(this.pv);
        this.pv = new PlateauView(this.game, this, this.nbPlayers);
        this.c.add(this.pv);
        this.c.validate();
        this.repaint();
    }

    public JPanel getPv() {
        return pv;
    }

    @Override
    public void modeleMisAJour(Object source) {
        this.repaint();
    }
}
