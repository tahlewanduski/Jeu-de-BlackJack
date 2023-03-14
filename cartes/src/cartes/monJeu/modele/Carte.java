package cartes.monJeu.modele;

/**
 * Classe Carte qui représente une carte de jeu (quelque soit le type de jeu de cartes).
 * Une carte est caractérisée par une valeur et une couleur.
 * La valeur est un string qui peut être "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi".
 * La couleur est un string qui peut être "coeur", "carreau", "pique", "trefle".
 * Le numero est la valeur numérique de la carte qui peut changer pour certains jeux de cartes.
 * 
 */
public class Carte implements Comparable<Carte>{
    protected String valeur, couleur;
    protected int numero;

    /**
     * Constructeur de la classe Carte.
     * @param valeur La valeur de la carte.
     * @param couleur La couleur de la carte.
     * @param numero Le numero de la carte.
     */
    public Carte(String valeur, String couleur, int numero) {
        this.couleur = couleur;
        this.valeur = valeur;
        this.numero = numero;
    }

    
    /** 
     * @return Valeur de la carte
     */
    public String getValeur() {
        String valeur;
        switch (this.valeur) {
            case "a":
                valeur = "As";
                break;
            case "t":
                valeur = "10";
                break;
            case "j":
                valeur = "Valet";
                break;
            case "q":
                valeur = "Dame";
                break;
            case "k":
                valeur = "Roi";
                break;
            default:
                valeur = this.valeur;
                break;
        }
        return valeur;
    }

    
    /** 
     * @return Couleur de la carte
     */
    public String getCouleur() {
        String couleur;
        switch (this.couleur) {
            case "c":
                couleur = "Trefle";
                break;
            case "d":
                couleur = "Carreau";
                break;
            case "h":
                couleur = "Coeur";
                break;
            case "s":
                couleur = "Pique";
                break;
            default:
                couleur = this.couleur;
                break;
        }
        return couleur;
    }

    
    /** 
     * @return Numero de la carte
     */
    public int getNumero() {
        return this.numero;
    }

    public int setNumero(int numero) {
        return this.numero = numero;
    }
    
    /** 
     * Compare la carte courante avec une autre carte.
     * @param c La carte à comparer.
     * @return 0 si les deux cartes sont identiques, i>0 si la carte courante a une valeur supérieure à la carte passée en paramètre, i<0 sinon.
     */
    @Override
    public int compareTo(Carte c) {
        if(this.numero == c.getNumero()) {
            return this.couleur.compareTo(c.getCouleur());
        }
        return this.numero - c.getNumero();
    }

    @Override
    public String toString() {
        return this.valeur + this.couleur;
    }
}