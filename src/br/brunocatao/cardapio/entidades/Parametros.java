package br.brunocatao.cardapio.entidades;

public class Parametros {
	private double[] calDesjejum;
	private double calLanche1;
	private double[] calAlmoco;
	private double calLanche2;
	private double[] calJantar;
	private double calCeia;
	private double carboidratosTotais;
	private double lipidiosTotais;
	private double proteinasTotais;
	
	private Parametros() {
		calDesjejum = new double[2];
		calLanche1 = 0.0;
		calAlmoco = new double[2];
		calLanche2 = 0.0;
		calJantar = new double[2];
		calCeia = 0.0;
	}
	
	private static Parametros instance;
	
	public static Parametros getInstance() {
		if (instance == null) {
			instance = new Parametros();
		}
		return instance;
	}
	
	public void setTotalCalorias(double totalCalorias) {
		calDesjejum = new double[] {totalCalorias * 0.2, totalCalorias * 0.25};
		calLanche1  = totalCalorias * 0.05;
		calAlmoco   = new double[] {totalCalorias * 0.35, totalCalorias * 0.4};
		calLanche2  = totalCalorias * 0.05;
		calJantar   = new double[] {totalCalorias * 0.15, totalCalorias * 0.25};
		calCeia     = totalCalorias * 0.05;
	}

	public double[] getCalDesjejum() {
		return calDesjejum;
	}

	public double getCalLanche1() {
		return calLanche1;
	}

	public double[] getCalAlmoco() {
		return calAlmoco;
	}

	public double getCalLanche2() {
		return calLanche2;
	}

	public double[] getCalJantar() {
		return calJantar;
	}

	public double getCalCeia() {
		return calCeia;
	}

	public double getCarboidratosTotais() {
		return carboidratosTotais;
	}

	public void setCarboidratosTotais(double carboidratosTotais) {
		this.carboidratosTotais = carboidratosTotais;
	}

	public double getLipidiosTotais() {
		return lipidiosTotais;
	}

	public void setLipidiosTotais(double lipidiosTotais) {
		this.lipidiosTotais = lipidiosTotais;
	}

	public double getProteinasTotais() {
		return proteinasTotais;
	}

	public void setProteinasTotais(double proteinasTotais) {
		this.proteinasTotais = proteinasTotais;
	}
}
