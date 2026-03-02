package tech.rayane.dao;

import org.springframework.stereotype.Component;

/**
 * DaoImplV2
 */
@Component("dao2")
public class DaoImplV2 implements IDao {

	@Override
	public double getData() {
		System.out.println("Version capteur ...");
		double t = 12;
		return t;
	}
}
