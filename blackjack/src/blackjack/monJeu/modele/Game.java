package blackjack.monJeu.modele;

import java.util.*;

import cartes.monJeu.modele.*;

import cartes.util.AbstractModeleEcoutable;

/**
 * Classe permettant de gérer le jeu.
 */
public class Game extends AbstractModeleEcoutable {
    private Integer nbPlayers;
    private Paquet paquet;
    private PlayerIA banquier;
    private PlayerIA player;
    private List<PlayerIA> ia;
    private List<PlayerIA> playerOnBoard;
    private String winner;

    /**
     * Constructeur de la classe Game.
     * @param nbPlayers Le nombre de joueurs.
     * @param nbCards Une booléen indiquant s'il y a 52 ou 32 cartes.
     */
    public Game(Integer nbPlayers, boolean nbCards) {
        this.ecouteurs = new LinkedList<>();
        this.nbPlayers = nbPlayers;
        if(nbCards) {
            this.paquet = PaquetFactory.paquet52();
        }
        else {
            this.paquet = PaquetFactory.paquet32();
        }
        this.banquier = new PlayerIA(new Paquet(), true, 2);
        this.player = new PlayerIA(new Paquet(), false, 0);
        this.ia = new ArrayList<PlayerIA>();
        for (int i = 0; i < this.nbPlayers-2; i++) {
            this.ia.add(new PlayerIA(new Paquet(),true,1));
        }
        this.playerOnBoard = new ArrayList<>();
        this.playerOnBoard.add(this.banquier);
        this.playerOnBoard.add(this.player);
        this.playerOnBoard.addAll(this.ia);
        this.winner = "";
    }

    /**
     * Permet d'obtenir la valeur d'une carte.
     * @param cartes La carte
     * @return La valeur de la carte
     */
    public static int value_cards(Carte cartes){
        if(cartes==null){
            return 0;
        }
        if (cartes.getNumero() <= 10 && cartes.getNumero() > 1){
            return cartes.getNumero();
        }
        else if (cartes.getNumero() > 10){
            return 10;
        }
        return 11;
    }



    /** 
     * Permet d'obtenir la valeur d'un paquet de cartes.
     * @param paquet Le paquet de carte
     * @return La valeur du paquet
    */
    public static int value_Deck(Paquet paquet){
        if(paquet == null || paquet.getJeu().size() == 0 ) {
            return 0;
        }
        int value = 0;
        
        for (int i = 0; i < paquet.getJeu().size(); i++) {
            value += value_cards(paquet.getJeu().get(i));
        }
        if(value>21){
            for (int j = 0; j < paquet.getJeu().size(); j++) {
                System.out.println("ooo");
                if(paquet.getJeu().get(j).getNumero() == 11){
                    value = value -10;
                    System.out.println("ici");
                }
            }
        }
        return value;
    }

    /**
     * Permet de savoir si un joueur peut jouer.
     * @param player Le joueur
     * @return Un booléen indiquant si le joueur peut jouer.
     */
    // utilisé dans le controlleur, si renvoie false appelle play
    public boolean canPlay(PlayerIA p){
        if(value_Deck(p.getDeck()) < 21){
            return true;
        }
        return false;
    }

    /**
     * Permet de savoir quel joueur a gagné.
     * @param score Un dictionnaire contenant les scores des joueurs.
     * @return Le joueur qui a gagné.
     */
    public PlayerIA winner(HashMap<PlayerIA,Integer>score) {
        PlayerIA winner = null;
        int bestScore = 0;
        for (PlayerIA player : score.keySet()){
            if(winner==null){
                if(score.get(player) != null && score.get(player) > bestScore && score.get(player) <= 21){
                    // System.out.println(player + " " + score.get(player));
                    winner = player;
                    bestScore = score.get(player);
                }
            }
            else if(score.get(player) != null && bestScore < score.get(player) && score.get(player) <= 21){
                // System.out.println("new " + player + " " + score.get(player));
                winner = player;
                bestScore = score.get(player);
            }
        }
        return winner;    
    }

    /**
     * Permet d'initialiser le jeu
     */
    public void start(){
        this.player.setDeck(new Paquet());
        this.banquier.setDeck(new Paquet());

        this.paquet = PaquetFactory.paquet52();
        this.paquet.melanger();
        this.paquet.retirerCarte(0);
        this.paquet.retirerCarte(0); 

        if (this.nbPlayers>1){
            for(PlayerIA p:this.ia) {
                p.setDeck(new Paquet());
                p.take_card(this.paquet);
                p.take_card(this.paquet);
            }
        }

        player.take_card(this.paquet);
        player.take_card(this.paquet);
        banquier.take_card(this.paquet);
        banquier.take_card(this.paquet);

        this.fireChangement();
    }

    /**
     * Permet de jouer.
     */
    public void play(){
        if(this.ia.size() >0) {
            for(PlayerIA p:this.ia){
                while (p.getIA().howPlay()) {
                    if (canPlay(p)){
                        p.take_card(this.paquet);
                    }
                    else{
                        break;
                    }
                }
            }

        }

        while (this.banquier.getIA().howPlay()) {
            if (canPlay(this.banquier)){
                    this.banquier.take_card(this.paquet);
                 }
                else{
                     break;
                }
                
        }
        HashMap<PlayerIA,Integer> score = new HashMap<PlayerIA,Integer>();
        for(PlayerIA p:this.playerOnBoard) {
            score.put(p,value_Deck(p.getDeck()));
        }


        PlayerIA winnerPlayer = winner(score);
        winnerPlayer.incrementStats(0);
        for(PlayerIA p:this.playerOnBoard) {
            if(p != winner(score)) {
                p.incrementStats(1);
            }
        }
        if (this.playerOnBoard.get(0) == winnerPlayer){
            this.winner = "croupier";
        }
        for (int i = 1; i < this.playerOnBoard.size(); i++) {
            if (this.playerOnBoard.get(i) == winnerPlayer){
                this.winner = "joueur "+i;
            }
        }
        this.fireChangement();
    }

    public PlayerIA getBanquier() {
        return this.banquier;
    }

    public PlayerIA getPlayer() {
        return this.player;
    }

    public List<PlayerIA> getIa() {
        return this.ia;
    }
    
    public Paquet getPaquet() {
        return this.paquet;
    }

    public Paquet getDeckBanquier() {
        return this.banquier.getDeck();
    }

    public Paquet getDeckPlayer() {
        return this.player.getDeck();
    }

    public List<Paquet> getDeckIa() {
        List<Paquet> list = new ArrayList<>();
        for(PlayerIA p:this.ia) {
            list.add(p.getDeck());
        }
        return list;
    }

    public String getWinner() {
        return this.winner;
    }

    public List<PlayerIA> getPlayerOnBoard() {
        return this.playerOnBoard;
    }

    public ArrayList<Integer> getPlayerScore(){
        return this.player.getStats();
    }
}