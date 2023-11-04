package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

public class ApuestaLoteriaDTO extends ApuestaDTO implements Serializable {

	private static final long serialVersionUID = -1314661433241492823L;
	private String lotteryName;
	private int[] fourNumbers;
	private String series;

	public ApuestaLoteriaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ApuestaLoteriaDTO(String lotteryName, int[] fourNumbers, String series) {
		super();
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
		this.series = series;
	}

	public ApuestaLoteriaDTO(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		// TODO Auto-generated constructor stub
	}

	public ApuestaLoteriaDTO(String bookmakerHeadquarters, double identification, String dayOfTheWeek,
			double valueOfTheBet, String lotteryName, int[] fourNumbers, String series) {
		super(bookmakerHeadquarters, identification, dayOfTheWeek, valueOfTheBet);
		this.lotteryName = lotteryName;
		this.fourNumbers = fourNumbers;
		this.series = series;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	public int[] getfourNumbers() {
		return fourNumbers;
	}

	public void setfourNumbers(int[] fourNumbers) {
		this.fourNumbers = fourNumbers;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApuestaLoteriaDTO [lotteryName=" + lotteryName + ", fourNumbers="
				+ Arrays.toString(fourNumbers) + ", series="
				+ series + "]";
	}

}
