package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa un juego de una casa de apuestas.
 */
public class JuegoCasaDeApuestasDTO extends SedeCasaDeApuestasDTO implements Serializable {

	private static final long serialVersionUID = 5268145531642102201L;
	private String gameName;
	private String typeOfGame;
	private double budgetAllocated;

	/**
	 * Constructor por defecto de JuegoCasaDeApuestasDTO.
	 */
	public JuegoCasaDeApuestasDTO() {
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros.
	 *
	 * @param gameName        El nombre del juego.
	 * @param typeOfGame      El tipo de juego.
	 * @param budgetAllocated El presupuesto asignado al juego.
	 */
	public JuegoCasaDeApuestasDTO(String gameName, String typeOfGame, double budgetAllocated) {
		super();
		this.gameName = gameName;
		this.typeOfGame = typeOfGame;
		this.budgetAllocated = budgetAllocated;
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 * @param address              La dirección de la casa de apuestas.
	 * @param numberOfEmployees    El número de empleados.
	 */
	public JuegoCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable,
			String address, int numberOfEmployees) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable, address, numberOfEmployees);
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 */
	public JuegoCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas.
	 *
	 * @param address           La dirección de la casa de apuestas.
	 * @param numberOfEmployees El número de empleados.
	 */
	public JuegoCasaDeApuestasDTO(String address, int numberOfEmployees) {
		super(address, numberOfEmployees);
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas y el juego.
	 *
	 * @param address           La dirección de la casa de apuestas.
	 * @param numberOfEmployees El número de empleados.
	 * @param gameName          El nombre del juego.
	 * @param typeOfGame        El tipo de juego.
	 * @param budgetAllocated   El presupuesto asignado al juego.
	 */
	public JuegoCasaDeApuestasDTO(String address, int numberOfEmployees, String gameName, String typeOfGame,
			double budgetAllocated) {
		super(address, numberOfEmployees);
		this.gameName = gameName;
		this.typeOfGame = typeOfGame;
		this.budgetAllocated = budgetAllocated;
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas y el juego.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 * @param gameName             El nombre del juego.
	 * @param typeOfGame           El tipo de juego.
	 * @param budgetAllocated      El presupuesto asignado al juego.
	 */
	public JuegoCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable,
			String gameName, String typeOfGame, double budgetAllocated) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable);
		this.gameName = gameName;
		this.typeOfGame = typeOfGame;
		this.budgetAllocated = budgetAllocated;
	}

	/**
	 * Constructor de JuegoCasaDeApuestasDTO con parámetros relacionados a la sede
	 * de la casa de apuestas, empleados y el juego.
	 *
	 * @param bookMarkerName       El nombre de la casa de apuestas.
	 * @param numberOfLocations    El número de ubicaciones.
	 * @param totalBudgetAvailable El presupuesto total disponible.
	 * @param address              La dirección de la casa de apuestas.
	 * @param numberOfEmployees    El número de empleados.
	 * @param gameName             El nombre del juego.
	 * @param typeOfGame           El tipo de juego.
	 * @param budgetAllocated      El presupuesto asignado al juego.
	 */
	public JuegoCasaDeApuestasDTO(String bookMarkerName, int numberOfLocations, double totalBudgetAvailable,
			String address, int numberOfEmployees, String gameName, String typeOfGame, double budgetAllocated) {
		super(bookMarkerName, numberOfLocations, totalBudgetAvailable, address, numberOfEmployees);
		this.gameName = gameName;
		this.typeOfGame = typeOfGame;
		this.budgetAllocated = budgetAllocated;
	}

	/**
	 * Obtiene el nombre del juego.
	 *
	 * @return El nombre del juego.
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * Establece el nombre del juego.
	 *
	 * @param gameName El nombre del juego.
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * Obtiene el tipo de juego.
	 *
	 * @return El tipo de juego.
	 */
	public String getTypeOfGame() {
		return typeOfGame;
	}

	/**
	 * Establece el tipo de juego.
	 *
	 * @param typeOfGame El tipo de juego.
	 */
	public void setTypeOfGame(String typeOfGame) {
		this.typeOfGame = typeOfGame;
	}

	/**
	 * Obtiene el presupuesto asignado al juego.
	 *
	 * @return El presupuesto asignado al juego.
	 */
	public double getBudgetAllocated() {
		return budgetAllocated;
	}

	/**
	 * Establece el presupuesto asignado al juego.
	 *
	 * @param budgetAllocated El presupuesto asignado al juego.
	 */
	public void setBudgetAllocated(double budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}

	/**
	 * Obtiene el valor de serialVersionUID para la serialización.
	 *
	 * @return El valor de serialVersionUID.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en cadena de este objeto.
	 *
	 * @return Una representación en cadena de JuegoCasaDeApuestasDTO.
	 */
	@Override
	public String toString() {
		return "JuegoCasaDeApuestasDTO [gameName=" + gameName + ", typeOfGame=" + typeOfGame + ", budgetAllocated="
				+ budgetAllocated + "]";
	}
}
