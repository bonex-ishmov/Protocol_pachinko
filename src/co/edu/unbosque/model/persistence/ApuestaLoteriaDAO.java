package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApuestaDTO;
import co.edu.unbosque.model.ApuestaLoteriaDTO;

/**
 * La clase ApuestaLoteriaDAO implementa operaciones CRUD (Crear, Leer,
 * Actualizar y Eliminar) para gestionar una lista de apuestas de la lotería.
 * También proporciona métodos para escribir los datos en un archivo
 * serializado.
 * 
 * @see CRUDOperation
 */
public class ApuestaLoteriaDAO implements CRUDOperation {

	private ArrayList<ApuestaLoteriaDTO> listOfBets;
	final String SERIAL_FILENAME = "apuestaLoteria.dat";
	int index = 0;

	/**
	 * Constructor de la clase ApuestaLoteriaDAO que inicializa la lista de
	 * apuestas.
	 */
	public ApuestaLoteriaDAO() {
		listOfBets = new ArrayList<>();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<ApuestaLoteriaDTO> temp2 = (ArrayList<ApuestaLoteriaDTO>) temp;
			listOfBets = temp2;
		} else {
			listOfBets = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		ApuestaLoteriaDTO bet = new ApuestaLoteriaDTO();
		bet.setBookmakerOffice(args[0]);
		bet.setIdentification(Long.parseLong(args[1]));
		bet.setDayOfTheWeek(args[2]);
		bet.setValueOfTheBet(Double.parseDouble(args[3]));
		bet.setLotteryName(args[4]);
		//
		String[] numberStrings = args[5].split(" ");
		int[] numbers = new int[numberStrings.length];
		for (int i = 0; i < numberStrings.length; i++) {
			numbers[i] = Integer.parseInt(numberStrings[i]);
		}
		bet.setFourNumbers(numbers);
		bet.setSeries(args[6]);
		listOfBets.add(bet);
		writeDataSerializable();

	}

	@Override
	public void create(Object o) {
		listOfBets.add((ApuestaLoteriaDTO) o);
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
				listOfBets.get(index).setIdentification(Long.parseLong(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfBets.get(index).setDayOfTheWeek(args[2]);
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfBets.get(index).setValueOfTheBet(Double.parseDouble(args[3]));
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				listOfBets.get(index).setLotteryName(args[4]);
			}
			if (!args[5].isBlank() || !args[5].isEmpty() || args[5] != null) {
				String[] numberStrings = args[5].split(" ");
				int[] numbers = new int[numberStrings.length];
				for (int i = 0; i < numberStrings.length; i++) {
					numbers[i] = Integer.parseInt(numberStrings[i]);
				}
				listOfBets.get(index).setFourNumbers(numbers);
			}
			if (!args[6].isBlank() || !args[6].isEmpty() || args[6] != null) {
				listOfBets.get(index).setSeries(args[6]);
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
		ApuestaLoteriaDTO toDelete = (ApuestaLoteriaDTO) o;
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
	 * Obtiene la lista de apuestas de lotería.
	 *
	 * @return La lista de apuestas de lotería.
	 */
	public ArrayList<ApuestaLoteriaDTO> getListOfBets() {
		return listOfBets;
	}

	/**
	 * Establece la lista de apuestas de lotería.
	 *
	 * @param listOfBets La nueva lista de apuestas de lotería.
	 */
	public void setListOfBets(ArrayList<ApuestaLoteriaDTO> listOfBets) {
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