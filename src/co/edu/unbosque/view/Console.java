package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * Clase que proporciona métodos para interactuar con el usuario y realizar
 * lecturas de diferentes tipos de datos.
 */
public class Console {

	private Scanner lector;

	/**
	 * Constructor de la clase `Console` que inicializa el objeto `Scanner` para la
	 * entrada estándar.
	 */
	public Console() {
		lector = new Scanner(System.in);
	}

	/**
	 * Lee un dato de tipo entero.
	 *
	 * @return El numero int leído.
	 */
	public int read_Int() {
		int temp = lector.nextInt();
		return temp;
	}

	/**
	 * Lee un dato de tipo float
	 *
	 * @return El número en float leído.
	 */
	public float read_Float() {
		float temp = lector.nextFloat();
		return temp;
	}

	/**
	 * Lee un número en double.
	 *
	 * @return El número en double leído.
	 */
	public double read_Double() {
		double temp = lector.nextDouble();
		return temp;
	}

	/**
	 * Lee un número long.
	 *
	 * @return El número long leído.
	 */
	public long read_Long() {
		long temp = lector.nextLong();
		return temp;
	}

	/**
	 * Lee un valor booleano.
	 *
	 * @return El valor booleano leído.
	 */
	public boolean read_Boolean() {
		return lector.nextBoolean();
	}

	/**
	 * Lee una línea de texto.
	 *
	 * @return La línea de texto leída.
	 */
	public String read_Line() {
		String temp = lector.nextLine();
		return temp;
	}

	/**
	 * Lee una palabra.
	 *
	 * @return La palabra leída.
	 */
	public String read_Word() {
		String temp = lector.next();
		return temp;
	}

	/**
	 * Lee un carácter.
	 *
	 * @return El carácter leído.
	 */
	public char read_Char() {
		char temp = lector.next().charAt(0);
		return temp;
	}

	/**
	 * Limpia la línea actual en el búfer de entrada.
	 */
	public void burn_Line() {
		lector.nextLine();
	}

	/**
	 * Imprime una línea en blanco.
	 */
	public void print_Jump() {
		System.out.println("");
	}

	/**
	 * Imprime una cadena con un salto de línea.
	 *
	 * @param data La cadena a imprimir.
	 */
	public void print_With_Jump(String data) {
		System.out.println(data);
	}

	/**
	 * Imprime una cadena en la consola sin salto de línea.
	 *
	 * @param data La cadena a imprimir.
	 */
	public void print_Without_Jump(String data) {
		System.out.print(data);
	}
}
