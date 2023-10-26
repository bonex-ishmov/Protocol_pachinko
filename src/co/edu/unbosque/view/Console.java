package co.edu.unbosque.view;

import java.util.Scanner;
/**
 * clase que se encarga de la escritura de datos, lectura de datos y exponer los datos al usuario a travez de consola
 */
public class Console {
	
	private Scanner lector;

	public Console() {
		lector = new Scanner(System.in);
	}

	// leer numeros
	public int read_Int() {
		int temp = lector.nextInt();
		return temp;
	}

	public float read_Float() {
		float temp = lector.nextFloat();
		return temp;
	}

	public double read_Double() {
		double temp = lector.nextDouble();
		return temp;
	}

	public long read_Long() {
		long temp = lector.nextLong();
		return temp;
	}

	public boolean read_Boolean() {
		return lector.nextBoolean();
	}

	// leer caracteres
	public String read_Line() {
		String temp = lector.nextLine();
		return temp;
	}

	public String read_Word() {
		String temp = lector.next();
		return temp;
	}

	public char read_Char() {
		char temp = lector.next().charAt(0);
		return temp;
	}

	// quemar linea
	public void burn_Line() {
		lector.nextLine();
	}

	public void print_Jump() {
		System.out.println("");
	}

	// impresion
	public void print_With_Jump(String data) {
		System.out.println(data);
	}

	// (imprime todo en la misma linea)
	public void print_Without_Jump(String data) {
		System.out.print(data);
	}
}
