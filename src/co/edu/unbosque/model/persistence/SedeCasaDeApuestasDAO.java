package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.SedeCasaDeApuestasDTO;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar la
 * persistencia de datos de sedes de casas de apuestas. Implementa la interfaz
 * CRUDOperation para realizar operaciones de creación, lectura, actualización y
 * eliminación de datos de sedes de casas de apuestas.
 * 
 * @see CRUDOperation
 */
public class SedeCasaDeApuestasDAO implements CRUDOperation {
	ArrayList<SedeCasaDeApuestasDTO> listOfLocations;
	final String SERIAL_FILENAME = "sedes.dat";
	int index = 0;

	/**
	 * Constructor de SedeCasaDeApuestasDAO que inicializa la lista de sedes de
	 * casas de apuestas.
	 */
	public SedeCasaDeApuestasDAO() {
		listOfLocations = new ArrayList<SedeCasaDeApuestasDTO>();

		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<SedeCasaDeApuestasDTO> temp2 = (ArrayList<SedeCasaDeApuestasDTO>) temp;
			listOfLocations = temp2;
		} else {
			listOfLocations = listOfLocations = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		SedeCasaDeApuestasDTO site = new SedeCasaDeApuestasDTO();
		site.setBookMarkerName(args[0]);
		site.setNumberOfLocations(Integer.parseInt(args[1]));
		site.setTotalBudgetAvailable(Double.parseDouble(args[2]));
		site.setAddress(args[3]);
		site.setNumberOfEmployees(Integer.parseInt(args[4]));

		listOfLocations.add(site);
		writeDataSerializable();
	}

	@Override
	public void create(Object o) {
		listOfLocations.add((SedeCasaDeApuestasDTO) o);
		writeDataSerializable();
	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfLocations.forEach(site -> {
			Sb.append(index + "->" + (site.toString() + "\n"));
			index++;
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfLocations.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				listOfLocations.get(index).setBookMarkerName(args[0]);
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfLocations.get(index).setNumberOfLocations(Integer.parseInt(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfLocations.get(index).setTotalBudgetAvailable(Double.parseDouble(args[2]));
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfLocations.get(index).setAddress(args[3]);
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				listOfLocations.get(index).setNumberOfEmployees(Integer.parseInt(args[4]));
			}
		}
		writeDataSerializable();
		return true;
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfLocations.size()) {
			return false;
		} else {
			listOfLocations.remove(index);
			writeDataSerializable();
			return true;
		}
	}

	@Override
	public boolean delete(Object o) {
		SedeCasaDeApuestasDTO toDelete = (SedeCasaDeApuestasDTO) o;
		if (listOfLocations.contains(toDelete)) {
			listOfLocations.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe los datos de la lista de sedes de casas de apuestas en un archivo
	 * serializado.
	 */
	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfLocations);
	}

	/**
	 * Obtiene la lista de sedes de casas de apuestas.
	 *
	 * @return Lista de sedes de casas de apuestas.
	 */
	public ArrayList<SedeCasaDeApuestasDTO> getListOfLocations() {
		return listOfLocations;
	}

	/**
	 * Establece la lista de sedes de casas de apuestas.
	 *
	 * @param listOfLocations Lista de sedes de casas de apuestas.
	 */
	public void setListOfLocations(ArrayList<SedeCasaDeApuestasDTO> listOfLocations) {
		this.listOfLocations = listOfLocations;
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
