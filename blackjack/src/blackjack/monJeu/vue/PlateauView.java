package blackjack.monJeu.vue;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import blackjack.monJeu.modele.*;
import cartes.monJeu.modele.*;
import cartes.monJeu.vue.*;
import cartes.util.EcouteurModele;

/**
 * Classe permettant d'afficher le jeu du blackjack.
 */
public class PlateauView extends JPanel implements EcouteurModele {
    private Game game;
    private VuePaquetVisible croupier;
    private VuePaquetCacheProxy pioche;
    private VuePaquetVisible joueur;
    private java.util.List<VuePaquetVisible> ia;
    private int nbPlayers;

    public PlateauView(Game game, MainFrame frame ,int nbPlayers) {
        super();
        //this.setBackground(new ImageIcon("assets/images/background/background.jpg"));
        this.setSize(800, 700);
        this.nbPlayers = nbPlayers;
        this.game = game;
        VueStats stats = new VueStats(this.game, frame);
        this.add(stats);
        stats.setBounds(0, 0, 724, 100);
        this.game.start();
        this.game.getPaquet().ajoutEcouteur(this);
        this.game.getDeckPlayer().ajoutEcouteur(this);
        this.game.getDeckBanquier().ajoutEcouteur(this);
        this.pioche = new VuePaquetCacheProxy(this.game.getPaquet(), this.game.getDeckPlayer());
        this.joueur = new VuePaquetVisible(this.game.getDeckPlayer(), this.game.getPaquet(), 19, false);
        this.croupier = new VuePaquetVisible(this.game.getDeckBanquier(), this.game.getPaquet(), false);
        this.ia = new ArrayList<VuePaquetVisible>();
        for (Paquet p : game.getDeckIa()) {
            this.ia.add(new VuePaquetVisible(p, this.game.getPaquet(), 19, false));
            p.ajoutEcouteur(this);
        }
        this.add(this.pioche);
        this.pioche.setBounds(0, 100, 300, 250);
        //this.pioche.setFenetre(this);
        this.add(this.croupier);
        this.croupier.setBounds(300, 100, 300, 200);
        //this.croupier.setFenetre(this);
        this.add(this.joueur);
        this.joueur.setBounds(0, 400, 210, 200);
        //this.joueur.setFenetre(this);
        int dx = 200;
        for (VuePaquet v : this.ia) {
            this.add(v);
            v.setBounds(dx, 400, 200, 200);
            dx+=200;
        }
        this.game.ajoutEcouteur(this);
        this.game.ajoutEcouteur(this.pioche);
        this.game.ajoutEcouteur(this.croupier);
        this.game.ajoutEcouteur(this.joueur);
        for (VuePaquet v : this.ia) {
            this.game.ajoutEcouteur(v);
        }

        // affichage des valeurs des paquets en dessous des paquets
        VueValueDeck valueCroupier = new VueValueDeck(this.game.getBanquier(), false);
        this.add(valueCroupier);
        valueCroupier.setBounds(300, 220, 300, 100);
        this.game.getBanquier().ajoutEcouteur(valueCroupier);

        VueValueDeck valueJoueur = new VueValueDeck(this.game.getPlayer(), true);
        this.add(valueJoueur);
        valueJoueur.setBounds(0, 520, 200, 100);
        this.game.getPlayer().ajoutEcouteur(valueJoueur);

        for(int i = 0; i < this.nbPlayers - 2; i++) {
            VueValueDeck valueIa = new VueValueDeck(this.game.getIa().get(i), i+2);
            this.add(valueIa);
            valueIa.setBounds(200 + i*200, 520, 200, 100);
            this.game.getIa().get(i).ajoutEcouteur(valueIa);
        }


        this.setLayout(null);

        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("assets/images/background/background.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void modeleMisAJour(Object source) {
        this.repaint();
        if(source instanceof Game){
            this.game = (Game)source;
            this.pioche.setPaquet(this.game.getPaquet());
            this.joueur.setPaquet(this.game.getDeckPlayer());
            this.pioche.setDestination(this.game.getDeckPlayer());
            this.croupier.setPaquet(this.game.getDeckBanquier());
            for(int i = 0; i < this.nbPlayers-2; i++){
                this.ia.get(i).setPaquet(this.game.getDeckIa().get(i));
            }
        }
    }

}
