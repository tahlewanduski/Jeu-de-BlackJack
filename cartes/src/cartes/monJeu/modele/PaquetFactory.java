package cartes.monJeu.modele;

import java.util.*;

/**
 * Classe PaquetFactory permettant de creer des paquets de cartes courants (comme le paquet de 52 cartes).
 */
public class PaquetFactory {

    /**
     * Permet de creer un paquet de 52 cartes.
     * @return Le paquet de 52 cartes.
     */
    public static Paquet paquet52() {
        LinkedList<Carte> res = new LinkedList<>();
        LinkedList<String> couleur = new LinkedList<>();
        HashMap<String, Integer> numero = new HashMap<>();
        couleur.add("c");
        couleur.add("d");
        couleur.add("h");
        couleur.add("s");
        numero.put("a", 1);
        numero.put("2", 2);
        numero.put("3", 3);
        numero.put("4", 4);
        numero.put("5", 5);
        numero.put("6", 6);
        numero.put("7", 7);
        numero.put("8", 8);
        numero.put("9", 9);
        numero.put("t", 10);
        numero.put("j", 11);
        numero.put("q", 12);
        numero.put("k", 13);
        
        for(String i : couleur) {
            for(String j : numero.keySet()) {
                res.add(new Carte(j,  i, numero.get(j)));
            }
        }
        return new Paquet(res);
    }

    /**
     * Permet de creer un paquet de 32 cartes.
     * @return Le paquet de 32 cartes.
     */
    public static Paquet paquet32() {
        LinkedList<Carte> res = new LinkedList<>();
        LinkedList<String> couleur = new LinkedList<>();
        HashMap<String, Integer> numero = new HashMap<>();
        couleur.add("c");
        couleur.add("d");
        couleur.add("h");
        couleur.add("s");
        numero.put("a", 1);
        numero.put("7", 7);
        numero.put("8", 8);
        numero.put("9", 9);
        numero.put("t", 10);
        numero.put("j", 11);
        numero.put("q", 12);
        numero.put("k", 13);
        
        for(String i : couleur) {
            for(String j : numero.keySet()) {
                res.add(new Carte(j,  i, numero.get(j)));
            }
        }
        return new Paquet(res);
    }
}
