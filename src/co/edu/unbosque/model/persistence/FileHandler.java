/**
 * La clase FileHandler proporciona métodos para manejar operaciones de archivos,
 * incluyendo serialización (lectura y escritura de objetos) y gestión de archivos de propiedades.
 */
package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.edu.unbosque.model.CasaDeApuestasDTO;

public class FileHandler {

	// Flujo de entrada para deserialización
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	// Flujo de salida para serialización
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	// Archivo de propiedades
	private static Properties propFile;

	/**
	 * Constructor predeterminado para la clase FileHandler.
	 */
	public FileHandler() {

	}

	/**
	 * Lee un archivo serializado y devuelve su contenido como un objeto.
	 *
	 * @param fileName El nombre del archivo serializado.
	 * @return El objeto deserializado leído desde el archivo.
	 */
	public static Object serializableOpenAndReadFile(String fileName) {
		try {
			fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Archivo serializado no encontrado, creándolo ahora.");
			File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);
			try {
				temp.createNewFile();
				fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		Object content = null;

		try {
			ois = new ObjectInputStream(fis);
			content = ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return content;
	}

	/**
	 * Escribe un objeto en un archivo serializado.
	 *
	 * @param fileName El nombre del archivo serializado.
	 * @param content  El objeto que se serializará y escribirá en el archivo.
	 */
	public static void serializableOpenAndWriteFile(String fileName, Object content) {
		try {
			fos = new FileOutputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
		} catch (FileNotFoundException e) {
			File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);
			try {
				fos = new FileOutputStream(temp);
			} catch (FileNotFoundException e1) {
				System.out.println("Problemas al crear o buscar el archivo serializado (escritura).");
				e1.printStackTrace();
			}
		}

		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al abrir el archivo serializado (escritura).");
		}
	}

	/**
	 * Escribe una lista de objetos CasaDeApuestasDTO en un archivo de propiedades.
	 *
	 * @param fileName El nombre del archivo de propiedades.
	 * @param casas    La lista de objetos CasaDeApuestasDTO que se escribirán en el
	 *                 archivo.
	 */
	public static void propertiesOpenAndWriteFile(String fileName, List<CasaDeApuestasDTO> casas) {
		try (PrintWriter writer = new PrintWriter(
				new FileWriter("src/co/edu/unbosque/model/persistence/" + fileName))) {
			int propertyCounter = 0;

			for (CasaDeApuestasDTO casa : casas) {
				writer.println("bookMarkerName_" + propertyCounter + "=" + casa.getBookMarkerName());
				writer.println("NumberOfLocations_" + propertyCounter + "=" + casa.getNumberOfLocations());
				writer.println("totalBudgetAvailable_" + propertyCounter + "=" + casa.getTotalBudgetAvailable());

				propertyCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problemas al escribir en el archivo.");
		}
	}

	/**
	 * Lee un archivo de propiedades y devuelve su contenido como un objeto
	 * Properties.
	 *
	 * @param fileName El nombre del archivo de propiedades.
	 * @return El objeto Properties leído desde el archivo.
	 */
	public static List<CasaDeApuestasDTO> propertiesOpenAndReadFile(String fileName) {
		List<CasaDeApuestasDTO> casas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new FileReader("src/co/edu/unbosque/model/persistence/" + fileName))) {
			String line;
			int propertyCounter = 0;
			CasaDeApuestasDTO casa = new CasaDeApuestasDTO();

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=");

				if (parts.length == 2) {
					String propertyName = parts[0];
					String propertyValue = parts[1];

					if (propertyName.startsWith("bookMarkerName")) {
						casa.setBookMarkerName(propertyValue);
					} else if (propertyName.startsWith("NumberOfLocations")) {
						casa.setNumberOfLocations(Integer.parseInt(propertyValue));
					} else if (propertyName.startsWith("totalBudgetAvailable")) {
						casa.setTotalBudgetAvailable(Double.parseDouble(propertyValue));
						casas.add(casa); // Agregar la casa al ArrayList
						casa = new CasaDeApuestasDTO(); // Crear una nueva instancia para la próxima casa
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Problemas al leer el archivo.");
		}

		return casas;
	}
}