package cartes.monJeu.vue;

import java.awt.*;
import javax.swing.*;

import cartes.monJeu.modele.*;

/**
 * Classe MainFrame representant la fenêtre de jeu.
 * 
 */
public class MainFrame extends JFrame{
    private VuePaquet pioche, paquet, defausse;

    public MainFrame() {
        super("Jeu de cartes");
        this.setContentPane(new JLabel(new ImageIcon("assets/images/background/background.jpg")));
        Container c = this.getContentPane();

        Paquet paquet = new Paquet();
        Paquet defausse = new Paquet();
        Paquet pioche = PaquetFactory.paquet52();
        
        pioche.melanger();
        // pioche.trierCroissant();
        // pioche.trierDecroissant();

        paquet.ajouterCarte(pioche.piocheCarte());
        paquet.ajouterCarte(pioche.piocheCarte());
        paquet.ajouterCarte(pioche.piocheCarte());
        paquet.ajouterCarte(pioche.piocheCarte());

        this.pioche = new VuePaquetCache(pioche, paquet);
        this.paquet = new VuePaquetVisible(paquet, defausse);
        this.defausse = new VuePaquetVisible(defausse, pioche);

        this.pioche.setFenetre(this);
        this.paquet.setFenetre(this);
        this.defausse.setFenetre(this);

        this.pioche.setBounds(0, 0, 800, 250);
        this.paquet.setBounds(0, 300, 800, 250);
        this.defausse.setBounds(0, 600, 800, 250);

        c.add(this.pioche);
        c.add(this.paquet);
        c.add(this.defausse);

        JButton melange = new JButton("Melanger pioche");
        melange.setBounds(225, 250, 250, 50);
        melange.addActionListener(new PiocheListener((VuePaquetCache) this.pioche));
        c.add(melange);

        JButton trierCroissantPaquet = new JButton("Trier croissant");
        trierCroissantPaquet.setBounds(175, 550, 175, 50);
        trierCroissantPaquet.addActionListener(new PaquetListener((VuePaquetVisible) this.paquet, true));
        c.add(trierCroissantPaquet);

        JButton trierDecroissantPaquet = new JButton("Trier decroissant");
        trierDecroissantPaquet.setBounds(350, 550, 175, 50);
        trierDecroissantPaquet.addActionListener(new PaquetListener((VuePaquetVisible) this.paquet, false));
        c.add(trierDecroissantPaquet);

        JButton trierCroissantDefausse = new JButton("Trier croissant");
        trierCroissantDefausse.setBounds(175, 850, 175, 50);
        trierCroissantDefausse.addActionListener(new PaquetListener((VuePaquetVisible) this.defausse, true));
        c.add(trierCroissantDefausse);

        JButton trierDecroissantDefausse = new JButton("Trier decroissant");
        trierDecroissantDefausse.setBounds(350, 850, 175, 50);
        trierDecroissantDefausse.addActionListener(new PaquetListener((VuePaquetVisible) this.defausse, false));
        c.add(trierDecroissantDefausse);

        this.setSize(800,1000);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Methode get pour {@link PiocheFrame#PiocheFrame(Paquet, Paquet) PiocheFrame}.
     * @return La pioche
     */
    public VuePaquet getPioche() {
        return this.pioche;
    }

    /**
     * Methode get pour {@link PiocheFrame#PiocheFrame(Paquet, Paquet) PiocheFrame}.
     * @return Le paquet
     */
    public VuePaquet getPaquet() {
        return this.paquet;
    }
}
