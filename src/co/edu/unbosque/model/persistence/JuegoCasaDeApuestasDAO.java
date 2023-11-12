package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JuegoCasaDeApuestasDTO;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar la
 * persistencia de datos de juegos de casas de apuestas. Implementa la interfaz
 * CRUDOperation para realizar operaciones de creación, lectura, actualización y
 * eliminación de datos de juegos de casas de apuestas.
 * 
 * @see CRUDOperation
 */
public class JuegoCasaDeApuestasDAO implements CRUDOperation {
	ArrayList<JuegoCasaDeApuestasDTO> listOfGames;
	final String SERIAL_FILENAME = "juegos.dat";
	int index = 0;

	/**
	 * Constructor de JuegoCasaDeApuestasDAO que inicializa la lista de juegos de
	 * casas de apuestas.
	 */
	public JuegoCasaDeApuestasDAO() {
		listOfGames = new ArrayList<JuegoCasaDeApuestasDTO>();

		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<JuegoCasaDeApuestasDTO> temp2 = (ArrayList<JuegoCasaDeApuestasDTO>) temp;
			listOfGames = temp2;
		} else {
			listOfGames = listOfGames = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		JuegoCasaDeApuestasDTO game = new JuegoCasaDeApuestasDTO();
		game.setBookMarkerName(args[0]);
		game.setNumberOfLocations(Integer.parseInt(args[1]));
		game.setTotalBudgetAvailable(Double.parseDouble(args[2]));
		game.setAddress(args[3]);
		game.setNumberOfEmployees(Integer.parseInt(args[4]));
		game.setGameName(args[5]);
		game.setTypeOfGame(args[6]);
		game.setBudgetAllocated(Double.parseDouble(args[7]));

		listOfGames.add(game);
		writeDataSerializable();
	}

	@Override
	public void create(Object o) {
		listOfGames.add((JuegoCasaDeApuestasDTO) o);
		writeDataSerializable();
	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfGames.forEach(game -> {
			Sb.append(index + "->" + (game.toString() + "\n"));
			index++;
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfGames.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				listOfGames.get(index).setBookMarkerName(args[0]);
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfGames.get(index).setNumberOfLocations(Integer.parseInt(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfGames.get(index).setTotalBudgetAvailable(Double.parseDouble(args[2]));
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfGames.get(index).setAddress(args[3]);
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				listOfGames.get(index).setNumberOfEmployees(Integer.parseInt(args[4]));
			}
			if (!args[5].isBlank() || !args[5].isEmpty() || args[5] != null) {
				listOfGames.get(index).setGameName(args[5]);
			}
			if (!args[6].isBlank() || !args[6].isEmpty() || args[6] != null) {
				listOfGames.get(index).setTypeOfGame(args[6]);
			}
			if (!args[7].isBlank() || !args[7].isEmpty() || args[7] != null) {
				listOfGames.get(index).setBudgetAllocated(Double.parseDouble(args[7]));
			}
		}
		writeDataSerializable();
		return true;
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfGames.size()) {
			return false;
		} else {
			listOfGames.remove(index);
			writeDataSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(Object o) {
		JuegoCasaDeApuestasDTO toDelete = (JuegoCasaDeApuestasDTO) o;
		if (listOfGames.contains(toDelete)) {
			listOfGames.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe los datos de la lista de juegos de casas de apuestas en un archivo
	 * serializado.
	 */
	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfGames);
	}

	/**
	 * Obtiene la lista de juegos de casas de apuestas.
	 *
	 * @return Lista de juegos de casas de apuestas.
	 */
	public ArrayList<JuegoCasaDeApuestasDTO> getListOfGames() {
		return listOfGames;
	}

	/**
	 * Establece la lista de juegos de casas de apuestas.
	 *
	 * @param listOfGames Lista de juegos de casas de apuestas.
	 */
	public void setListOfGames(ArrayList<JuegoCasaDeApuestasDTO> listOfGames) {
		this.listOfGames = listOfGames;
	}

	/**
	 * Obtiene el índice actual.
	 *
	 * @return Índice actual.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Establece el índice actual.
	 *
	 * @param index Índice actual.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Obtiene el nombre del archivo serializado.
	 *
	 * @return Nombre del archivo serializado.
	 */
	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}
}
