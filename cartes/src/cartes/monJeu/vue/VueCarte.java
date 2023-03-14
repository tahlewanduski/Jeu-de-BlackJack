package cartes.monJeu.vue;

import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.LineBorder;

import cartes.monJeu.modele.Carte;

/**
 * Classe VueCarte permettant de gerer l'affichage d'une carte.
 */
public class VueCarte extends JPanel {
    private Carte carte;
    private boolean v;
    private Integer l, h;
    
    /**
     * Constructeur de la classe VueCarte.
     * @param carte La carte en question.
     * @param v Un boolean qui dit si la carte est visible.
     * @param x La position en x de la carte.
     * @param y La position en y de la carte.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     */
    public VueCarte(Carte carte, boolean v, int x, int y, int largeur, int hauteur) {
        super();
        this.carte = carte;
        this.v = v;
        // this.setLayout(new BoxLayout(this, 1));
        // this.setSize(largeur, hauteur);
        if(l == null || h == null) {
            this.l = largeur;
            this.h = hauteur;
        }
        this.setBounds(x, y, this.l, this.h);
        // this.setBackground(null);
        this.setBorder(new LineBorder(Color.DARK_GRAY));
        if(this.v) {
            if(!((new File("assets/images/cartes/" + this.carte.toString() + ".png")).exists())) {
                this.setBackground(Color.ORANGE);
                JLabel l = new JLabel(this.carte.toString());
                l.setFont(new Font("Arial", Font.BOLD, 20));
                this.add(l);
            }
        } else {
            if(!((new File("assets/images/cartes/dos.png")).exists())) {
                this.setBackground(Color.BLUE);
                JLabel l = new JLabel("Dos");
                l.setFont(new Font("Arial", Font.BOLD, 10));
                this.add(l);
            }
        }
    }
    
    
    /** 
     * Methode permettant de dessiner la carte.
     * @param graphics
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if(!this.v) {
            // if((new File("assets/images/cartes/dow-bleu.png")).exists()) {
                ImageIcon image = new ImageIcon("assets/images/cartes/dos-bleu.png");
                graphics.drawImage(image.getImage(), 0, 0, this.l, this.h, this);
            // }
        } else {
            // if((new File("assets/images/cartes/" + this.carte.toString() + ".png")).exists()) {
                ImageIcon image = new ImageIcon("assets/images/cartes/" + this.carte.toString() + ".gif");
                graphics.drawImage(image.getImage(), 0, 0, this.l, this.h, this);
            // }
        }
    }

    
    /** 
     * Methode permettant de mettre la carte en surbrillance ou de retirer la surbrillance.
     * @param on Un boolean qui dit si on met la carte en surbrillance ou non.
     */
    public void surbrillance(boolean on) {
        if(on) {
            this.setBorder(new LineBorder(Color.GREEN));
        } else {
            this.setBorder(new LineBorder(Color.DARK_GRAY));
        }
    }

    
    /** 
     * @return La carte de la vue
     */
    public Carte getCarte() {
        return carte;
    }


}