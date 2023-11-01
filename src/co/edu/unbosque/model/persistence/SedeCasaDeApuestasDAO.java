package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CasaDeApuestasDTO;
import co.edu.unbosque.model.SedeCasaDeApuestasDTO;

public class SedeCasaDeApuestasDAO implements CRUDOperation {

	ArrayList<SedeCasaDeApuestasDTO> listOfLocations;

	final String FILEURL = "src/co/edu/unbosque/model/persistence/archivocasadeapuestas.csv";
	final String SERIAL_FILENAME = "sedes.dat";
	int index = 0;

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
		SedeCasaDeApuestasDTO sede = new SedeCasaDeApuestasDTO();
		sede.setBookMarkerName(args[0]);
		sede.setNumberOfLocations(Integer.parseInt(args[1]));
		sede.setTotalBudgetAvailable(Double.parseDouble(args[2]));
		sede.setAddress(args[3]);
		sede.setNumberOfEmployees(Integer.parseInt(args[4]));

		listOfLocations.add(sede);
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
		listOfLocations.forEach(sedes -> {
			Sb.append(index + "->" + (sedes.toString() + "\n"));
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfLocations.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				try {
					listOfLocations.get(index).setBookMarkerName(args[0]);
				} catch (NumberFormatException e) {

				}

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

	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfLocations);
	}

	public ArrayList<SedeCasaDeApuestasDTO> getListOfLocations() {
		return listOfLocations;
	}

	public void setListOfLocations(ArrayList<SedeCasaDeApuestasDTO> listOfLocations) {
		this.listOfLocations = listOfLocations;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getFILEURL() {
		return FILEURL;
	}

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}
