package tech.rayane.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tech.rayane.metier.IMetier;

public class PresSpringXML {

	public static void main(String[] args) {
		
		ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
		IMetier metier = (IMetier) springContext.getBean("metier");

		System.out.println("Res = " + metier.calcul());
	}
}
