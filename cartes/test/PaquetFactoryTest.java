/**
 * 
 */
package cartes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.monJeu.modele.*;

class PaquetFactoryTest {

	@Test
	void paquet52Test() {
		// Act
		Paquet p52 = PaquetFactory.paquet52();
		// Assert
		assertEquals(p52.getJeu().size(),52);
	}
	
	@Test
	void paquet32Test() {
		// Act
		Paquet p32 = PaquetFactory.paquet32();
		// Assert
		assertEquals(p32.getJeu().size(),32);
	}

}
