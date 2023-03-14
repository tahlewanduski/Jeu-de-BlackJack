package cartes.monJeu.modele;

import java.util.*;

import cartes.util.AbstractModeleEcoutable;

/**
 * Classe Paquet representant un paquet de cartes.
 */
public class Paquet extends AbstractModeleEcoutable {
    protected LinkedList<Carte> jeu;

    /**
     * Constructeur de la classe Paquet initialisant un paquet vide.
     */
    public Paquet() {
        this.jeu = new LinkedList<>();
        super.ecouteurs = new LinkedList<>();
    }
    
    /**
     * Constructeur de la classe Paquet initialisant un paquet avec une liste de cartes.
     * @param jeu La liste des cartes.
     */
    public Paquet(LinkedList<Carte> jeu) {
        this.jeu = jeu;
        super.ecouteurs = new LinkedList<>();
    }

    /**
     * @return La liste des cartes du paquet.
     */
    public LinkedList<Carte> getJeu() {
        return this.jeu;
    }

    public void melanger() {
        Collections.shuffle(this.jeu);
        fireChangement();
    }

    
    /** 
     * Permet de piocher une carte du paquet en la retirant de celle-ci.
     * @return la carte au dessus du paquet
     */
    public Carte piocheCarte() {
        Carte res = this.jeu.pop();
        fireChangement();
        return res;
    }

    /**
     * Trie le paquet de cartes par ordre croissant.
     */
    public void trierCroissant() {
        Collections.sort(this.jeu);
        fireChangement();
    }

    /**
     * Trie le paquet de cartes par ordre decroissant.
     */
    public void trierDecroissant() {
        Collections.sort(this.jeu, Collections.reverseOrder());
        fireChangement();
    }

    
    /** 
     * Retire une carte du paquet
     * @param i L'indice de la carte a retirer
     */
    public void retirerCarte(int i) {
        if(this.jeu.remove(i) != null) {
            fireChangement();
        }
    }

    
    /** 
     * Retire une carte du paquet
     * @param c La carte à retirer
     */
    public void retirerCarte(Carte c) {
        if(this.jeu.remove(c)) {
            fireChangement();
        }
    }

    
    /** 
     * Ajoute une carte au paquet
     * @param c La carte à ajouter
     */
    public void ajouterCarte(Carte c) {
        this.jeu.add(c);
        fireChangement();
    }

    /**
     * Coupe le paquet de cartes (crée deux paquets a partir du premier qu'il va rassembler).
     */
    public void couperPaquet() {
        int i = (int) (Math.random() * (this.jeu.size() - 1) + 1);
        LinkedList<Carte> res = new LinkedList<>();
        for(int j = 0; j < i; j++) {
            res.add(this.jeu.pop());
        }
        this.jeu.addAll(res);
        fireChangement();
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Paquet " + this.jeu.toString();
    }
}
