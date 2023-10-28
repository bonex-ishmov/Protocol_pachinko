package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * clase que se encarga de la escritura de datos, lectura de datos y exponer los
 * datos al usuario a travez de consola
 */
public class Console {

	private Scanner lector;

	/**
	 * Constructor de la clase consola, solo tiene un escaner llamado lector
	 * invocado
	 */
	public Console() {
		lector = new Scanner(System.in);
	}

	/**
	 * Funcion que lee un dato de tipo int
	 * 
	 * @return retorna un dato de tipo int
	 */
	public int read_Int() {
		int temp = lector.nextInt();
		return temp;
	}

	/**
	 * Funcion que lee un dato de tipo float
	 * 
	 * @return retorna un dato de tipo float
	 */
	public float read_Float() {
		float temp = lector.nextFloat();
		return temp;
	}

	/**
	 * Funcion que lee un dato de tipo double
	 * 
	 * @return retorna un dato de tipo double
	 */
	public double read_Double() {
		double temp = lector.nextDouble();
		return temp;
	}

	/**
	 * Funcion que lee un dato de tipo long
	 * 
	 * @return retorna un dato de tipo long
	 */
	public long read_Long() {
		long temp = lector.nextLong();
		return temp;
	}

	/**
	 * Funcion que lee un dato de tipo boleano
	 * 
	 * @return retorna un dato de tipo boleano
	 */
	public boolean read_Boolean() {
		return lector.nextBoolean();
	}

	/**
	 * Funcion que lee una linea de texto entera
	 * 
	 * @return retorna un dato de tipo String
	 */
	// leer caracteres
	public String read_Line() {
		String temp = lector.nextLine();
		return temp;
	}

	/**
	 * Funcion que lee un texto hasta el espacio
	 * 
	 * @return retorna un dato de tipo String
	 */
	public String read_Word() {
		String temp = lector.next();
		return temp;
	}

	/**
	 * Funcion que lee un dato de tipo char
	 * 
	 * @return retorna un dato de tipo char
	 */
	public char read_Char() {
		char temp = lector.next().charAt(0);
		return temp;
	}

	/**
	 * Funcion que se encarga de quemar linea
	 */
	public void burn_Line() {
		lector.nextLine();
	}

	/**
	 * Funcion que se encarga de imprimir un salto de linea
	 */
	public void print_Jump() {
		System.out.println("");
	}

	/**
	 * Funcion que imprime cualquier linea de texto, saltando al finalizar la misma
	 * @param data
	 */
	// impresion
	public void print_With_Jump(String data) {
		System.out.println(data);
	}

	/**
	 *  Funcion que imprime cualquier linea de texto, sin saltar linea
	 * @param data
	 */
	public void print_Without_Jump(String data) {
		System.out.print(data);
	}
}
