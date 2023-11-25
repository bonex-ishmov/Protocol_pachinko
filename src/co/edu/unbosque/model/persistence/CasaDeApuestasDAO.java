/**
 * La clase CasaDeApuestasDAO implementa la interfaz CRUDOperation y gestiona
 * las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para objetos
 * CasaDeApuestasDTO, utilizando un ArrayList para almacenar las casas de apuestas.
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CasaDeApuestasDTO;

public class CasaDeApuestasDAO implements CRUDOperation {

	// Lista para almacenar las casas de apuestas
	ArrayList<CasaDeApuestasDTO> listOfHouses;

	// Nombre del archivo de propiedades
	final String PROPERTIES_FILENAME = "config.properties";

	// Índice de seguimiento
	int index = 0;

	/**
	 * Constructor de la clase CasaDeApuestasDAO. Inicializa la lista de casas de
	 * apuestas y lee el archivo de propiedades.
	 */
	public CasaDeApuestasDAO() {
		listOfHouses = new ArrayList<CasaDeApuestasDTO>();
		listOfHouses = (ArrayList<CasaDeApuestasDTO>) FileHandler.propertiesOpenAndReadFile(PROPERTIES_FILENAME);
	}

	/**
	 * Crea una nueva casa de apuestas y la agrega a la lista.
	 *
	 * @param args Argumentos para la creación de la casa de apuestas
	 */
	@Override
	public void create(String... args) {
		CasaDeApuestasDTO house = new CasaDeApuestasDTO();
		house.setBookMarkerName(args[0]);
		house.setNumberOfLocations(Integer.parseInt(args[1]));
		house.setTotalBudgetAvailable(Double.parseDouble(args[2]));

		listOfHouses.add(house);
		writeInProperties();
	}

	/**
	 * Agrega una casa de apuestas existente a la lista.
	 *
	 * @param obj Objeto CasaDeApuestasDTO a agregar
	 */
	@Override
	public void create(Object obj) {
		listOfHouses.add((CasaDeApuestasDTO) obj);
		writeInProperties();
	}

	/**
	 * Devuelve una cadena que representa todas las casas de apuestas en la lista.
	 *
	 * @return Cadena que representa las casas de apuestas.
	 */
	@Override
	public String read() {
		index = 0;
		StringBuilder sb = new StringBuilder();
		listOfHouses.forEach(house -> {
			sb.append(index + "->" + (house.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

	/**
	 * Actualiza la información de una casa de apuestas en la lista.
	 *
	 * @param index Índice de la casa de apuestas a actualizar.
	 * @param args  Nuevos valores para la casa de apuestas.
	 * @return Verdadero si la actualización fue exitosa, falso de lo contrario.
	 */
	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfHouses.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				try {
					listOfHouses.get(index).setBookMarkerName(args[0]);
				} catch (NumberFormatException e) {
					// Manejar la excepción si args[0] no es un número válido
				}
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfHouses.get(index).setNumberOfLocations(Integer.parseInt(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfHouses.get(index).setTotalBudgetAvailable(Double.parseDouble(args[2]));
			}
		}
		writeInProperties();
		return true;
	}

	/**
	 * Elimina una casa de apuestas de la lista.
	 *
	 * @param index Índice de la casa de apuestas a eliminar.
	 * @return Verdadero si la eliminación fue exitosa, falso de lo contrario.
	 */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfHouses.size()) {
			return false;
		} else {
			listOfHouses.remove(index);
			writeInProperties();
			return true;
		}
	}

	/**
	 * Elimina una casa de apuestas de la lista.
	 *
	 * @param o Objeto CasaDeApuestasDTO a eliminar.
	 * @return Verdadero si la eliminación fue exitosa, falso de lo contrario.
	 */
	@Override
	public boolean delete(Object o) {
		CasaDeApuestasDTO toDelete = (CasaDeApuestasDTO) o;
		if (listOfHouses.contains(toDelete)) {
			listOfHouses.remove(toDelete);
			writeInProperties();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe la lista de casas de apuestas en el archivo de propiedades.
	 */
	public void writeInProperties() {
		FileHandler.propertiesOpenAndWriteFile(PROPERTIES_FILENAME, listOfHouses);
	}

	/**
	 * Obtiene la lista de casas de apuestas.
	 *
	 * @return Lista de casas de apuestas.
	 */
	public ArrayList<CasaDeApuestasDTO> getListOfHouses() {
		return listOfHouses;
	}

	/**
	 * Establece la lista de casas de apuestas.
	 *
	 * @param listOfHouses Nueva lista de casas de apuestas.
	 */
	public void setListOfHouses(ArrayList<CasaDeApuestasDTO> listOfHouses) {
		this.listOfHouses = listOfHouses;
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
	 * @param index Nuevo índice.
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
