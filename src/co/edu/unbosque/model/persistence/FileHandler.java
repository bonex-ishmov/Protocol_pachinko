package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class FileHandler {

	// serializado lectura
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	// serializado escritura
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	private static Properties propFile;

	public FileHandler() {

	}

	public static Object serializableOpenAndReadFile(String fileName) {

		try {
			fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
		} catch (FileNotFoundException e) {

			System.out.println("archivo serializado no encontrado, creandolo ahora mismo");
			File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);

			try {
				temp.createNewFile();
				fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

		Object content = null;

		try {
			ois = new ObjectInputStream(fis);
			content = ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("no se pudo escribir en el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("error al obtener la clase");
			e.printStackTrace();
		}

		return content;
	}

	public static void serializableOpenAndWriteFile(String fileName, Object content) {

		try {
			fos = new FileOutputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
		} catch (FileNotFoundException e) {
			File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);
			try {
				fos = new FileOutputStream(temp);
			} catch (FileNotFoundException e1) {
				System.out.println("problemas al crear o buscar el archivo serializado (escritura)");
				e1.printStackTrace();
			}
		}

		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al abrir ek archivo serializado (escritura)");
		}
	}

//	public static void configPropOpenAndReadFile(String fileName) {
//		try {
//			fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//		} catch (FileNotFoundException e) {
//
//			System.out.println("archivo .properties no encontrado, creandolo ahora mismo");
//			File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);
//
//			try {
//				temp.createNewFile();
//				fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//			} catch (IOException e2) {
//				// TODO: handle exception
//			}
//		}
//
//		try (FileInputStream input = new FileInputStream(
//				new File("src/co/edu/unbosque/model/persistence/" + fileName))) {
//			propFile.load(input);
//		} catch (IOException ex) {
//			System.out.println("El archivo de configuración no existe.");
//		}
//	}
}
