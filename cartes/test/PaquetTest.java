package cartes;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import cartes.monJeu.modele.*;

class PaquetTest {
	

	@Test
	void constructeurTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		deck.add(c10);
		// Act
		Paquet p = new Paquet(deck);
		// Assert
		assertEquals(p.getJeu(),deck);
	}
	
	@Test
	void piocheCarteTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		deck.add(c10);
		LinkedList<Carte> deck2 = new LinkedList<>(deck);
		// Act
		Paquet p = new Paquet(deck);
		Carte piochedcard = p.piocheCarte();
		// Assert
		assertTrue(piochedcard == c);
		assertFalse(p.getJeu().equals(deck2));
		
		
	}
	
	@Test
	void trierCroissantTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c10);
		deck.add(c);
		LinkedList<Carte> deckCroissant = new LinkedList<>();
		deckCroissant.add(c);
		deckCroissant.add(c10);
		LinkedList<Carte> deck2 = new LinkedList<>(deck);
		// Act
		Paquet p = new Paquet(deck);
		p.trierCroissant();
		// Assert
		assertEquals(p.getJeu(),deckCroissant);
		assertFalse(p.getJeu().equals(deck2));
	
	}
	
	@Test
	void trierDecroissantTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		deck.add(c10);
		LinkedList<Carte> deckDeroissant = new LinkedList<>();
		deckDeroissant.add(c10);
		deckDeroissant.add(c);
		LinkedList<Carte> deck2 = new LinkedList<>(deck);
		// Act
		Paquet p = new Paquet(deck);
		p.trierDecroissant();
		// Assert
		assertEquals(p.getJeu(),deckDeroissant);
		assertFalse(p.getJeu().equals(deck2));

	}
	
	@Test
	void retirerCartebyindiceTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		deck.add(c10);
		LinkedList<Carte> deck2 = new LinkedList<>(deck);
		// Act
		Paquet p = new Paquet(deck);
		p.retirerCarte(0);
		// Assert
		assertFalse(p.getJeu().contains(c));
		assertFalse(p.getJeu().equals(deck2));
	}
	
	@Test
	void retirerCartebyCarteTest() {
		// Arrange
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		deck.add(c10);
		LinkedList<Carte> deck2 = new LinkedList<>(deck);
		// Act
		Paquet p = new Paquet(deck);
		p.retirerCarte(c10);
		// Assert
		assertFalse(p.getJeu().contains(c10));
		assertFalse(p.getJeu().equals(deck2));
	}
	
	@Test
	void ajouterCarteTest() {
		// Arrange
		Paquet pvide = new Paquet();
		Carte c = new Carte("a","h",1);
		Carte c10 = new Carte("10","c",10);
		LinkedList<Carte> deck = new LinkedList<>();
		deck.add(c);
		Paquet p = new Paquet(deck);
		deck.add(c10);
		// Act
		pvide.ajouterCarte(c);
		pvide.ajouterCarte(c10);
		// Assert
		assertTrue(pvide.getJeu().contains(c10));
		assertEquals(p.getJeu(),pvide.getJeu());
	}
	
}
