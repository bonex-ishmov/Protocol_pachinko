package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class ApuestaChance extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = 6467706599620146542L;
	private String lotteryName;
	private int[] fourNumbers;

	public ApuestaChance() {
		// TODO Auto-generated constructor stub
	}

	public ApuestaChance(String lotteryName, int[] fourNumbers) {
		super();
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
	}

	public ApuestaChance(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		// TODO Auto-generated constructor stub
	}

	public ApuestaChance(String bookmakerHeadquarters, double identification, String dayOfTheWeek, double valueOfTheBet,
			String lotteryName, int[] fourNumbers) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public int[] getFourNumbers() {
		return fourNumbers;
	}

	public void setFourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApuestaChance [lotteryName=" + lotteryName + ", fourNumbers=" + Arrays.toString(fourNumbers) + "]";
	}

}
