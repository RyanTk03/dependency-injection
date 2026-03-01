package tech.rayane.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import tech.rayane.dao.IDao;
import tech.rayane.metier.IMetier;

public class Pres2 {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Scanner scanner = new Scanner(new File("config.txt"));

		String daoClassName = scanner.nextLine();
		Class cDao = Class.forName(daoClassName);
		IDao dao = (IDao)cDao.getConstructor().newInstance();

		String metierClassName = scanner.nextLine();
		Class cMetier = Class.forName(metierClassName);
		IMetier metier = (IMetier)cMetier.getConstructor(IDao.class).newInstance(dao);

		// IMetier metier = (IMetier)cMetier.getConstructor().newInstance();
		// Method setDao = cMetier.getMethod("setDao", IDao.class);
		// setDao.invoke(metier, dao);

		System.out.println(metier.calcul());
	}
}
