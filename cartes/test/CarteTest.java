package cartes;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.monJeu.modele.Carte;

class CarteTest {
	
	@Test
	void constucteurTest() {
		// Act
		Carte c = new Carte("a","h",1);
		// Assert
		assertEquals(c.getValeur(),"a");
		assertEquals(c.getCouleur(),"h");
		assertEquals(c.getNumero(),1);
	}

	@Test
	void compareToTest() {
		// Act
		Carte c = new Carte("a","h",1);
		Carte c2 = new Carte("a","h",1);
		Carte c3 = new Carte("10","c",10);
		// Assert
		assertEquals(c.compareTo(c2),0);
		assertEquals(c.compareTo(c3),-9);
	}
	
	@Test
	 public void testToString() {
		// Act
		Carte c = new Carte("a","h",1);
		// Assert
		assertEquals(c.toString(), "ah");
	 }

}
