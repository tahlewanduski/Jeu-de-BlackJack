package blackjack.monJeu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.monJeu.modele.*;
import blackjack.monJeu.modele.*;

class IATest {

	@Test
	void ConstructeurTest() {
		// Arrange
		Paquet p = new Paquet();
		PlayerIA pl = new PlayerIA(p,false,null);
		PlayerIA pIa = new PlayerIA(p,true,1);
		// Act
		IA ia = new IA(pl);
		IA iaB = new IA(pIa);
		// Assert
		assertEquals(ia.getDifficulty(),null);
		assertEquals(iaB.getDifficulty(),1);
		assertEquals(iaB.getDifficulty(),pIa.getIA().getDifficulty());

	}
	
	@Test
	void howPlayTest() {
		// Arrange
		Paquet p = new Paquet();
		PlayerIA pl = new PlayerIA(p,true,0);
		IA ia = new IA(pl);
		// Act
		boolean res = ia.howPlay();
		// Assert
		assertEquals(res,false);
		assertEquals(res,pl.getIA().howPlay());
	}
	
	@Test
	void SetterGetterTest() {
		// Arrange
		Paquet p = new Paquet();
		PlayerIA pl = new PlayerIA(p,false,null);
		PlayerIA pIa = new PlayerIA(p,true,1);
		IA ia = new IA(pl);
		IA iab = new IA(pIa);
		// Act
		ia.setDifficulty(0);
		iab.setDifficulty(null);
		// Assert
		assertEquals(ia.getDifficulty(),0);
		assertEquals(iab.getDifficulty(),null);
	}

}
