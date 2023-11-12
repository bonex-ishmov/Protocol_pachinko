package co.edu.unbosque.model.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.ApuestaDTO;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar la
 * persistencia de datos de apuestas. Implementa la interfaz CRUDOperation para
 * realizar operaciones de creación, lectura, actualización y eliminación de
 * datos de apuestas.
 * 
 * @see CRUDOperation
 */
public class ApuestaDAO implements CRUDOperation {
	private ArrayList<ApuestaDTO> listOfBets;
	final String SERIAL_FILENAME = "apuesta.dat";
	int index = 0;

	/**
	 * Constructor de ApuestaDAO que inicializa la lista de apuestas.
	 */
	public ApuestaDAO() {
		listOfBets = new ArrayList<ApuestaDTO>();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<ApuestaDTO> temp2 = (ArrayList<ApuestaDTO>) temp;
			listOfBets = temp2;
		} else {
			listOfBets = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {
		ApuestaDTO bet = new ApuestaDTO();
		bet.setBookmakerOffice(args[0]);
		bet.setIdentification(Long.parseLong(args[1]));
		bet.setDayOfTheWeek(args[2]);
		bet.setValueOfTheBet(Double.parseDouble(args[3]));
		listOfBets.add(bet);
		writeDataSerializable();
	}

	@Override
	public void create(Object o) {
		listOfBets.add((ApuestaDTO) o);
		writeDataSerializable();
	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfBets.forEach(bet -> {
			Sb.append(index + "->" + (bet.toString() + "\n"));
			index++;
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
		ApuestaDTO toDelete = (ApuestaDTO) o;
		if (listOfBets.contains(toDelete)) {
			listOfBets.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que obtiene el día de la semana a partir de una fecha en formato de
	 * cadena.
	 *
	 * @param fechaString Cadena que representa la fecha en formato "yyyy-MM-dd".
	 * @return Nombre del día de la semana o "Fecha no válida" en caso de error.
	 */
	public static String obtenerDiaSemana(String fechaString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date fecha = sdf.parse(fechaString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);

			int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

			String[] diasSemana = { "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };

			return diasSemana[diaSemana - 1];
		} catch (ParseException e) {
			return "Fecha no válida";
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
	 * @return Lista de apuestas.
	 */
	public ArrayList<ApuestaDTO> getListOfBets() {
		return listOfBets;
	}

	/**
	 * Establece la lista de apuestas.
	 *
	 * @param listOfBets Lista de apuestas.
	 */
	public void setListOfBets(ArrayList<ApuestaDTO> listOfBets) {
		this.listOfBets = listOfBets;
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
