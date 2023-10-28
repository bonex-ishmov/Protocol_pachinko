package co.edu.unbosque.model;

import java.io.Serializable;

public class JuegoCasaDeApuestasDTO implements Serializable{

	private static final long serialVersionUID = 5268145531642102201L;
	private String gameName;
	private String typeOfGame;
	private double BudgetAllocated;
	
	public JuegoCasaDeApuestasDTO() {
		// TODO Auto-generated constructor stub
	}

	public JuegoCasaDeApuestasDTO(String gameName, String typeOfGame, double budgetAllocated) {
		super();
		this.gameName = gameName;
		this.typeOfGame = typeOfGame;
		BudgetAllocated = budgetAllocated;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getTypeOfGame() {
		return typeOfGame;
	}

	public void setTypeOfGame(String typeOfGame) {
		this.typeOfGame = typeOfGame;
	}

	public double getBudgetAllocated() {
		return BudgetAllocated;
	}

	public void setBudgetAllocated(double budgetAllocated) {
		BudgetAllocated = budgetAllocated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JuegoCasaDeApuestasDTO [gameName=" + gameName + ", typeOfGame=" + typeOfGame + ", BudgetAllocated="
				+ BudgetAllocated + "]";
	}

}
