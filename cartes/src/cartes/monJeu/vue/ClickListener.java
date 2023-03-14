package cartes.monJeu.vue;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

/**
 * Classe ClickListener permettant de gerer les clics de souris dans une carte.
 */
public class ClickListener implements MouseInputListener {
    private VuePaquet vue;
    protected boolean visible;
    protected VueCarte carte;

    /**
     * Constructeur de la classe ClickListener.
     * @param vue La vue du paquet dans laquelle se trouve la carte.
     * @param visible Un boolean qui dit si la carte est visible.
     * @param carte La vue de la carte en question.
     */
    public ClickListener(VuePaquet vue, boolean visible, VueCarte carte) {
        this.vue = vue;
        this.visible = visible;
        this.carte = carte;
    }

    
    /**
     * Methode permettant de gerer le clic de souris.
     * @param e L'evenement de la souris.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        this.vue.onClick(this.carte, this.visible);
    }

    
    /** 
     * Methode permettant de mettre en surbrillance une carte lorsqu'on la survole.
     * @param e L'evenement de la souris.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.vue.onHover(this.carte, this.visible, true);
    }

    
    /** 
     * Methode permettant de retirer la surbrillance d'une carte lorsqu'on la survole.
     * @param e L'evenement de la souris.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.vue.onHover(this.carte, this.visible, false);
    }

    
    /** 
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    
    /** 
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    
    /** 
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    
    /** 
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
