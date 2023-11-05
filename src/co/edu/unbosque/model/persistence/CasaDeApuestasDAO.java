package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

public class CasaDeApuestasDAO implements CRUDOperation {

	ArrayList<CasaDeApuestasDTO> listOfHouses;

	int index = 0;

	public CasaDeApuestasDAO() {
		listOfHouses = new ArrayList<CasaDeApuestasDTO>();
	}

	@Override
	public void create(String... args) {
		CasaDeApuestasDTO house = new CasaDeApuestasDTO();
		house.setBookMarkerName(args[0]);
		house.setNumberOfLocations(Integer.parseInt(args[1]));
		house.setTotalBudgetAvailable(Double.parseDouble(args[2]));

		listOfHouses.add(house);

	}

	@Override
	public void create(Object obj) {
		listOfHouses.add((CasaDeApuestasDTO) obj);

	}

	@Override
	public String read() {
		index = 0;
		StringBuilder Sb = new StringBuilder();
		listOfHouses.forEach(house -> {
			Sb.append(index + "->" + (house.toString() + "\n"));
		});
		return Sb.toString();
	}

	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listOfHouses.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty() || args[0] != null) {
				try {
					listOfHouses.get(index).setBookMarkerName(args[0]);
				} catch (NumberFormatException e) {

				}

			}
			if (!args[1].isBlank() || !args[1].isEmpty() || args[1] != null) {
				listOfHouses.get(index).setNumberOfLocations(Integer.parseInt(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty() || args[2] != null) {
				listOfHouses.get(index).setTotalBudgetAvailable(Double.parseDouble(args[2]));

			}

		}

		return true;
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listOfHouses.size()) {
			return false;
		} else {
			listOfHouses.remove(index);

			return true;
		}
	}

	@Override
	public boolean delete(Object o) {

		CasaDeApuestasDTO toDelete = (CasaDeApuestasDTO) o;
		if (listOfHouses.contains(toDelete)) {
			listOfHouses.remove(toDelete);

			return true;
		} else {
			return false;
		}
	}

	public ArrayList<CasaDeApuestasDTO> getListOfHouses() {
		return listOfHouses;
	}

	public void setListOfHouses(ArrayList<CasaDeApuestasDTO> listOfHouses) {
		this.listOfHouses = listOfHouses;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
