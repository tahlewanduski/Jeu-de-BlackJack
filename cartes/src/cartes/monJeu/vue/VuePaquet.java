package cartes.monJeu.vue;

import java.awt.*;

import javax.swing.*;

import cartes.monJeu.modele.Carte;
import cartes.monJeu.modele.Paquet;
import cartes.util.*;

/**
 * Classe VuePaquet representant une vue d'un paquet de cartes.
 * 
 */
public abstract class VuePaquet extends JPanel implements EcouteurModele {
    protected int dx, dy;
    protected Paquet paquet, destination;
    protected boolean visible;
    protected int largeurCarte;
    protected JFrame fenetre;
    protected boolean playable;

    /**
     * Constructeur de la classe VuePaquet.
     * 
     * @param paquet Le paquet de cartes.
     * @param destination Le paquet de destination (pour les methodes piocher et deplacer une carte).
     * @param visible Un boolean qui dit si le paquet est visible.
     */
    public VuePaquet(Paquet paquet, Paquet destination, boolean visible) {
        super();
        this.paquet = paquet;
        this.destination = destination;
        this.visible = visible;
        this.largeurCarte = 73;
        this.setSize(800, 300);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        this.setLayout(null);
        this.setVisible(true);
        this.paquet.ajoutEcouteur(this);
    }
    
    
    /** 
     * @return Le paquet de cartes.
     */
    public Paquet getPaquet() {
        return paquet;
    }

    public void setPaquet(Paquet paquet) {
        this.paquet = paquet;
    }
    
    
    /** 
     * Methode permettant de dessiner le paquet de cartes.
     * @param v Un boolean qui dit si le paquet est visible.
     * @param paquet Le paquet de cartes.
     */
    public void paquet(boolean v, Paquet paquet){
        this.visible = v;
        int x = 10;
        int y = 10;
        if(!v) {
            x += paquet.getJeu().size()*dx;
            y += paquet.getJeu().size()*dy;
        }
        for(Carte carte : paquet.getJeu()) {
            VueCarte c = new VueCarte(carte, v, x, y, 73, 97);
            this.add(c);
            c.addMouseListener(new ClickListener(this, true, c));
            if(v) {
                x += dx;
                y += dy;
            } else {
                x -= dx;
                y -= dy;
            }
        }
    }

    
    /** 
     * Methode permettant d'afficher le paquet de cartes utilisant la methode {@link #paquet(boolean, Paquet) paquet}.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.removeAll();
        // g.fillRect(0, 0, this.getWidth(), this.getHeight());
        paquet(this.visible, this.paquet);
    }
    
    public abstract void onClick(VueCarte c, boolean v);

    
    /** 
     * Methode permettant de mettre en surbrillance une carte lorsqu'on la survole.
     * @param c La vue de la carte en question.
     * @param v Un boolean qui dit si la carte est visible.
     * @param in Un boolean qui dit si la souris est dans la carte.
     */
    public void onHover(VueCarte c, boolean v, boolean in) {
        if(visible) {
            c.setBorder(in ? BorderFactory.createLineBorder(Color.GREEN, 1) : BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        } else {
            if(c.getCarte().equals(this.paquet.getJeu().get(0))) {
                c.setBorder(in ? BorderFactory.createLineBorder(Color.GREEN, 1) : BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            }
        }
    }

    
    /** 
     * Methode permettant de mettre a jour la vue.
     * @param source le modele qui a été mis a jour
     */
    @Override
    public void modeleMisAJour(Object source) {
        if(source instanceof Paquet) {
            this.paquet = (Paquet) source;
        }
        this.repaint();
        if(this.fenetre != null) {
            this.fenetre.repaint();
        }
    }

    
    /** 
     * Methode permettant de definir la fenetre pour la mettre à jour en même temps que les vues.
     * @param fenetre La fenetre dans laquelle se trouve la vue.
     */
    public void setFenetre(JFrame fenetre) {
        this.fenetre = fenetre;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "VuePaquet [paquet=" + paquet + "]";
    }
}