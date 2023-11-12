package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApostadorDTO;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar la
 * persistencia de datos de apostadores. Implementa la interfaz CRUDOperation
 * para realizar operaciones de creación, lectura, actualización y eliminación
 * de datos del apostador.
 * 
 * @see CRUDOperation
 */
public class ApostadorDAO implements CRUDOperation {
	ArrayList<ApostadorDTO> listOfGamblers;

	final String SERIAL_FILENAME = "apostadores.dat";
	int index = 0;

	/**
	 * Constructor de ApostadorDAO que inicializa la lista de apostadores. También
	 * intenta cargar datos previos desde un archivo serializado si existe.
	 */
	public ApostadorDAO() {
		listOfGamblers = new ArrayList<ApostadorDTO>();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<ApostadorDTO> temp2 = (ArrayList<ApostadorDTO>) temp;
			listOfGamblers = temp2;
		} else {
			listOfGamblers = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		ApostadorDTO gamblers = new ApostadorDTO();
		gamblers.setCompleteName(args[0]);
		gamblers.setIdentification(Long.parseLong(args[1]));
		gamblers.setBirthDate(args[2]);
		gamblers.setBookmakerHeadquarters(args[3]);
		gamblers.setAddressOfThePerson(args[4]);
		gamblers.setPhoneNumber(Long.parseLong(args[5]));
		listOfGamblers.add(gamblers);
		writeDataSerializable();
	}

	@Override
	public void create(Object o) {
		listOfGamblers.add((ApostadorDTO) o);
		writeDataSerializable();
	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfGamblers.forEach(gamblers -> {
			Sb.append(index + "->" + (gamblers.toString() + "\n"));
			index++;
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfGamblers.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				listOfGamblers.get(index).setCompleteName(args[0]);
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfGamblers.get(index).setIdentification(Long.parseLong(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfGamblers.get(index).setBirthDate(args[2]);
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfGamblers.get(index).setBookmakerHeadquarters(args[3]);
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				listOfGamblers.get(index).setAddressOfThePerson(args[4]);
			}
			if (!args[5].isBlank() || !args[5].isEmpty() || args[5] != null) {
				listOfGamblers.get(index).setPhoneNumber(Long.parseLong(args[5]));
			}
		}
		writeDataSerializable();
		return true;
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfGamblers.size()) {
			return false;
		} else {
			listOfGamblers.remove(index);
			writeDataSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(Object obj) {
		ApostadorDTO toDelete = (ApostadorDTO) obj;
		if (listOfGamblers.contains(toDelete)) {
			listOfGamblers.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe los datos de la lista de apostadores en un archivo serializado.
	 */
	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfGamblers);
	}

	/**
	 * Obtiene la lista de apostadores.
	 *
	 * @return Lista de apostadores.
	 */
	public ArrayList<ApostadorDTO> getListOfGamblers() {
		return listOfGamblers;
	}

	/**
	 * Establece la lista de apostadores.
	 *
	 * @param listOfGamblers Lista de apostadores.
	 */
	public void setListOfGamblers(ArrayList<ApostadorDTO> listOfGamblers) {
		this.listOfGamblers = listOfGamblers;
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
