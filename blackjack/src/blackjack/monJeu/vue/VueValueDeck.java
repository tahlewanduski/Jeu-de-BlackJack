package blackjack.monJeu.vue;

import java.awt.*;

import javax.swing.*;

import blackjack.monJeu.modele.*;
import cartes.util.EcouteurModele;

/**
 * Classe permettant d'afficher les valuers des paquets enn dessous de ces derniers.
 */
public class VueValueDeck extends JPanel implements EcouteurModele {
    private PlayerIA p;
    private JLabel value;
    private Integer i;

    /* Pour les joueurs */
    public VueValueDeck(PlayerIA p,Integer i){
        super();
        this.i = i;
        this.p = p;
        this.p.ajoutEcouteur(this);
        this.setLayout(null);
        this.value = new JLabel("J"+ this.i +" value: "+ Game.value_Deck(p.getDeck()));
        this.add(this.value);
        this.value.setBounds(10, 0, 200, 100);
        this.value.setFont(new Font("Arial", Font.BOLD, 20));
        this.value.setForeground(Color.WHITE);
        this.setBackground(new Color(0,0,0,0));
        // this.value.setBounds(i*100, 0, 200, 1100);
        this.setVisible(true);
    }
    
    /*Pour le banquier */ 
    public VueValueDeck(PlayerIA p, boolean joueur){
        super();
        this.p = p;
        this.p.ajoutEcouteur(this);
        this.setLayout(null);
        if(joueur){
            this.value = new JLabel("J1 value: "+ Game.value_Deck(p.getDeck()));
            this.value.setBounds(10, 0, 200, 100);
            this.value.setForeground(Color.WHITE);
        }else{
            this.value = new JLabel("Banquier value: "+ Game.value_Deck(p.getDeck()));
            this.value.setBounds(0, 0, 300, 100);
            this.value.setForeground(Color.BLACK);
        }
        this.value.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(this.value);
        this.setBackground(new Color(0,0,0,0));
        // this.value.setBounds(325, 0, 250, 500);
        this.setVisible(true);
    }

    @Override
    public void modeleMisAJour(Object source) {
        if(source instanceof PlayerIA){
            if(i != null) {
                this.value.setText("J"+ this.i +" value: "+ Game.value_Deck(p.getDeck()));
            } else {
                this.value.setText("Banquier value: "+ Game.value_Deck(p.getDeck()));
            }
            this.repaint();
        }
    }
    
}
