package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;

public class ApostadoresDAO implements CRUDOperation {
	ArrayList<ApostadoresDTO> listOfGamblers;

	final String FILEURL = "src/co/edu/unbosque/model/persistence/archivocasadeapuestas.csv";
	final String SERIAL_FILENAME = "apostadores.dat";
	int index = 0;

	public ApostadoresDAO() {

		listOfGamblers = new ArrayList<ApostadoresDTO>();
		if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
			Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
			ArrayList<ApostadoresDTO> temp2 = (ArrayList<ApostadoresDTO>) temp;
			listOfGamblers = temp2;
		} else {
			listOfGamblers = listOfGamblers = new ArrayList<>();
		}
	}

	@Override
	public void create(String... args) {

		ApostadoresDTO apostadores = new ApostadoresDTO();
		apostadores.setCompleteName(args[0]);
		apostadores.setIdentification(Double.parseDouble(args[1]));
		apostadores.setBookmakerHeadquarters(args[2]);
		apostadores.setAddressOfThePerson(args[3]);
		apostadores.setPhoneNumber(Double.parseDouble(args[4]));

		listOfGamblers.add(apostadores);
		writeDataSerializable();
	}

	@Override
	public void create(Object obj) {

		listOfGamblers.add((ApostadoresDTO) obj);
		writeDataSerializable();
	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfGamblers.forEach(apostadores -> {
			Sb.append(index + "->" + (apostadores.toString() + "\n"));
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfGamblers.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				try {
					listOfGamblers.get(index).setCompleteName(args[0]);
				} catch (NumberFormatException e) {

				}

			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfGamblers.get(index).setIdentification(Double.parseDouble(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfGamblers.get(index).setBookmakerHeadquarters(args[2]);

			}
			if (!args[3].isBlank() || !args[3].isEmpty() || args[3] != null) {
				listOfGamblers.get(index).setAddressOfThePerson(args[3]);

			}
			if (!args[4].isBlank() || !args[4].isEmpty() || args[4] != null) {
				listOfGamblers.get(index).setPhoneNumber(Double.parseDouble(args[4]));
				;
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

		ApostadoresDTO toDelete = (ApostadoresDTO) obj;
		if (listOfGamblers.contains(toDelete)) {
			listOfGamblers.remove(toDelete);
			writeDataSerializable();
			return true;
		} else {
			return false;
		}
	}

	public void writeDataSerializable() {
		FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listOfGamblers);
	}

	public ArrayList<ApostadoresDTO> getListOfGamblers() {
		return listOfGamblers;
	}

	public void setListOfGamblers(ArrayList<ApostadoresDTO> listOfGamblers) {
		this.listOfGamblers = listOfGamblers;
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
