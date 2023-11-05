package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.ApuestaSuperAstroDTO;

/**
 * La clase ApuestaSuperAstroDAO implementa operaciones CRUD (Crear, Leer,
 * Actualizar y Eliminar) para gestionar una lista de apuestas del juego
 * SuperAstro. También proporciona métodos para escribir los datos en un archivo
 * serializado.
 * 
 * @see CRUDOperation
 */
public class ApuestaSuperAstroDAO implements CRUDOperation {

	private ArrayList<ApuestaSuperAstroDTO> listOfBets;
	final String SERIAL_FILENAME = "apuestaSuperAstro.dat";
	int index = 0;

	/**
	 * Constructor de la clase ApuestaSuperAstroDAO que inicializa la lista de
	 * apuestas.
	 */
	public ApuestaSuperAstroDAO() {
		listOfBets = new ArrayList<ApuestaSuperAstroDTO>();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<ApuestaSuperAstroDTO> temp2 = (ArrayList<ApuestaSuperAstroDTO>) temp;
			listOfBets = temp2;
		} else {
			listOfBets = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		ApuestaSuperAstroDTO bet = new ApuestaSuperAstroDTO();
		bet.setBookmakerOffice(args[0]);
		bet.setIdentification(Double.parseDouble(args[1]));
		bet.setDayOfTheWeek(args[2]);
		bet.setValueOfTheBet(Double.parseDouble(args[3]));
		String[] numberStrings = args[4].split(" ");
		int[] numbers = new int[numberStrings.length];
		for (int i = 0; i < numberStrings.length; i++) {
			numbers[i] = Integer.parseInt(numberStrings[i]);
		}
		bet.setFourNumbers(numbers);
		bet.setZodiacSign(args[5]);
		listOfBets.add(bet);
		writeDataSerializable();

	}

	@Override
	public void create(Object o) {
		listOfBets.add((ApuestaSuperAstroDTO) o);
		writeDataSerializable();

	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfBets.forEach(bet -> {
			Sb.append(index + "->" + (bet.toString() + "\n"));
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfBets.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				listOfBets.get(index).setBookmakerOffice(args[0]);
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfBets.get(index).setIdentification(Double.parseDouble(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfBets.get(index).setDayOfTheWeek(args[2]);
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfBets.get(index).setValueOfTheBet(Double.parseDouble(args[3]));
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				String[] numberStrings = args[4].split(" ");
				int[] numbers = new int[numberStrings.length];
				for (int i = 0; i < numberStrings.length; i++) {
					numbers[i] = Integer.parseInt(numberStrings[i]);
				}
				listOfBets.get(index).setFourNumbers(numbers);
			}
			if (!args[5].isBlank() || !args[5].isEmpty() || args[5] != null) {
				listOfBets.get(index).setZodiacSign(args[5]);
			}
		}
		writeDataSerializable();
		return true;
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfBets.size()) {
			return false;
		} else {
			listOfBets.remove(index);
			writeDataSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(Object o) {
		ApuestaSuperAstroDTO toDelete = (ApuestaSuperAstroDTO) o;
		if (listOfBets.contains(toDelete)) {
			listOfBets.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe los datos de la lista de apuestas en un archivo serializado.
	 */
	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfBets);
	}

	/**
	 * Obtiene la lista de apuestas.
	 *
	 * @return La lista de apuestas.
	 */
	public ArrayList<ApuestaSuperAstroDTO> getListOfBets() {
		return listOfBets;
	}

	/**
	 * Establece la lista de apuestas.
	 *
	 * @param listOfBets La nueva lista de apuestas.
	 */
	public void setListOfBets(ArrayList<ApuestaSuperAstroDTO> listOfBets) {
		this.listOfBets = listOfBets;
	}

	/**
	 * Obtiene el índice actual.
	 *
	 * @return El índice actual.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Establece el índice actual.
	 *
	 * @param index El nuevo índice.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Obtiene el nombre del archivo serializado.
	 *
	 * @return El nombre del archivo serializado.
	 */
	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}
}