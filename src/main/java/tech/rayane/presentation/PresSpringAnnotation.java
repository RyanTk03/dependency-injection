package tech.rayane.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tech.rayane.metier.IMetier;

public class PresSpringAnnotation {

	public static void main(String[] args) {
		ApplicationContext springContext = new AnnotationConfigApplicationContext("tech.rayane");
		IMetier metier = springContext.getBean(IMetier.class);

		System.out.println("Res = " + metier.calcul());
	}
}
