package blackjack.monJeu.test;

 import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import blackjack.monJeu.modele.*;
import cartes.monJeu.modele.Carte;
import cartes.monJeu.modele.Paquet;
 
 public class GameTest {

 	@Test
 	public void testGame() throws Exception {
 		// Arrange
 		// Act
 		Game game = new Game(2, true);
 		Game game32 = new Game(3, false);
 		// Assert
 		assertEquals((Integer)game.getPaquet().getJeu().size(), (Integer)52);
 		assertEquals((Integer)game.getBanquier().getDeck().getJeu().size(), (Integer)0);
 		assertEquals((Integer)game.getPlayer().getDeck().getJeu().size(), (Integer)0);
 		assertEquals((Integer)game.getIa().size(), (Integer)0);
 		assertEquals((Integer)game32.getPaquet().getJeu().size(), (Integer)32);
 		assertEquals((Integer)game32.getBanquier().getDeck().getJeu().size(), (Integer)0);
 		assertEquals((Integer)game32.getPlayer().getDeck().getJeu().size(), (Integer)0);
 		assertEquals((Integer)game32.getIa().size(), (Integer)1);
 	}

 	@Test
 	public void testValue_cards() throws Exception {
 		// Arrange
 		Carte c = new Carte("2", "h", 2);
 		//Act
 		int v = Game.value_cards(c);
 		//Assert
 		assertEquals(Game.value_cards(null),0);
 		assertEquals(v,2);
 	}

 	@Test
 	public void testValue_Deck() throws Exception {
		// Arrange
 		Carte c = new Carte("2", "h", 2);
 		Carte c1 = new Carte("2", "c", 2);
 		Paquet p = new Paquet();
 		p.ajouterCarte(c);
 		p.ajouterCarte(c1);
 		//Act
 		int v = Game.value_Deck(p);
 		//Assert
 		assertEquals(Game.value_Deck(null),0);
 		assertEquals(v,4);
 	}

 	@Test
 	public void testCanPlay() throws Exception {
 		// Arrange
 		Game game = new Game(2, true);
 		Paquet p = new Paquet();
 		Paquet pa = new Paquet();
 		PlayerIA p1 = new PlayerIA(p,false,0);
 		Carte c = new Carte("10", "h", 10);
 		Carte c1 = new Carte("10", "c", 10);
 		Carte c2 = new Carte("10", "s", 10);
 		pa.ajouterCarte(c2);
 		pa.ajouterCarte(c1);
 		pa.ajouterCarte(c);
 		PlayerIA p2 = new PlayerIA(pa,false,0);
 		// Act
 		
 		// Assert
 		assertEquals((Boolean)game.canPlay(p1), (Boolean)true);
 		assertEquals((Boolean)game.canPlay(p2), (Boolean)false);
 	}

 	@Test
 	public void testWinner() throws Exception {
 		// Arrange
 		Game game = new Game(2, true);
 		Paquet p = new Paquet();
 		Paquet pa = new Paquet();
 		PlayerIA p1 = new PlayerIA(p,false,0);
 		PlayerIA p2 = new PlayerIA(pa,false,0);
 		HashMap<PlayerIA,Integer> score = new HashMap<PlayerIA,Integer>();
 		score.put(p1,18);
 		score.put(p2, 21);
 		// Act
 		PlayerIA winner = game.winner(score);
 		// Assert
 		assertEquals(p2,winner);
 	}

 }

