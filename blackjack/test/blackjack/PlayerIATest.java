/**
 * 
 */
package blackjack.monJeu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import cartes.monJeu.modele.*;
import blackjack.monJeu.modele.*;

import org.junit.jupiter.api.Test;

/**
 * @author Felix
 *
 */
class PlayerIATest {

	@Test
	void Constructeurtest() {
		// Arrange 
		Carte c = new Carte("a","h",1);
		Paquet p = new Paquet();
		p.ajouterCarte(c);
		// Act
		PlayerIA player = new PlayerIA(p,false,0);
		PlayerIA playerbis = new PlayerIA(p,true,1);;
		// Assert
		assertEquals(player.getDeck(),p);
		assertEquals(player.getIA(),null);
		assertFalse(player.getStats().isEmpty());
		assertEquals(playerbis.getDeck(),p);
		assertFalse(playerbis.getStats().isEmpty());
		assertEquals(playerbis.getIA().getDifficulty(),1);
	}
	
	@Test
	void SetterGettertest() {
		// Arrange 
		Carte c = new Carte("a","h",1);
		Paquet p = new Paquet();
		Paquet p1 = new Paquet();
		p1.ajouterCarte(c);
		PlayerIA player = new PlayerIA(p,false,0);
		IA ia = new IA(player);
		ArrayList<Integer> stat = new ArrayList<Integer>();
		 stat.add(10);
         stat.add(5);
		// Act
		player.setDeck(p1);
		player.setIA(ia);
		player.setStats(stat);
		// Assert
		assertEquals(player.getDeck(),p1);
		assertEquals(player.getIA(),ia);
		assertFalse(player.getStats().isEmpty());
		assertEquals(player.getStats().get(0),10);
		assertEquals(player.getStats().get(1),5);		
	}
	
	@Test
	void piochecarteTest() {
		// Arrange 
		Carte c = new Carte("a","h",1);
		Paquet pioche = new Paquet();
		pioche.ajouterCarte(c);
		Paquet deck = new Paquet();
		PlayerIA player = new PlayerIA(deck,false,0);
		// Act
		player.take_card(pioche);
		// Assert
		assertEquals(pioche.getJeu().size(),0);
		assertEquals(player.getDeck().getJeu().size(),1);
	}
	
	@Test
	void isIATest() {
		// Arrange 
		Paquet deck = new Paquet();
		PlayerIA player = new PlayerIA(deck,false,0);
		PlayerIA playerIa = new PlayerIA(deck,true,1);
		// Act
		boolean ans1 = player.isIA();
		boolean ans2 = playerIa.isIA();
		// Assert
		assertEquals(ans1,false);
		assertEquals(ans2,true);
	}
	
	@Test
	void incrementStatsTest() {
		// Arrange
		Paquet deck = new Paquet();
		PlayerIA player = new PlayerIA(deck,false,0);
		// Act
		player.incrementStats(0);
		player.incrementStats(0);
		player.incrementStats(1);
		// Assert
		assertFalse(player.getStats().isEmpty());
		assertEquals(player.getStats().get(0),2);
		assertEquals(player.getStats().get(1),1);
		assertEquals(player.getStats().size(),2);
	}
}
