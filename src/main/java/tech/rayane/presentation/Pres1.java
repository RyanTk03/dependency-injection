package tech.rayane.presentation;

import tech.rayane.dao.DaoImpl;
import tech.rayane.metier.MetierImpl;

/**
 * Pres1
 */
public class Pres1 {

	public static void main(String[] args) {
		DaoImpl dao = new DaoImpl();
		MetierImpl metier = new MetierImpl(dao);

		// metier.setDao(dao);
		System.out.println("Res = " + metier.calcul());
	}
}
