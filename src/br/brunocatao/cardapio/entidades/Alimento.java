package br.brunocatao.cardapio.entidades;

public class Alimento {
	private String nome;
	private double calorias;
	private double carboidratos;
	private double lipidios;
	private double proteinas;
	private boolean temLimite;
	private double pesoMinimo;
	private double pesoMaximo;
	
	public static Alimento novo(String nome, double cal, double carbo, double lip, double prot, double peso) {
		return new Alimento(nome, cal/peso, carbo/peso, lip/peso, prot/peso);
	}

	public static Alimento novo(String nome, double cal, double carbo, double lip, double prot, double peso, double pesoMinimo, double pesoMaximo) {
		return new Alimento(nome, cal/peso, carbo/peso, lip/peso, prot/peso, pesoMinimo, pesoMaximo);
	}
	
	public Alimento(String nome, double calorias, double carboidratos, double lipidios, double proteinas) {
		this.nome = nome;
		this.calorias = calorias;
		this.carboidratos = carboidratos;
		this.lipidios = lipidios;
		this.proteinas = proteinas;
		this.temLimite = false;
	}

	public Alimento(String nome, double calorias, double carboidratos, double lipidios, double proteinas, double pesoMinimo, double pesoMaximo) {
		this(nome, calorias, carboidratos, lipidios, proteinas);
		this.temLimite = true;
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCalorias() {
		return calorias;
	}
	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}
	public double getCarboidratos() {
		return carboidratos;
	}
	public void setCarboidratos(double carboidratos) {
		this.carboidratos = carboidratos;
	}
	public double getLipidios() {
		return lipidios;
	}
	public void setLipidios(double lipidios) {
		this.lipidios = lipidios;
	}
	public double getProteinas() {
		return proteinas;
	}
	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public boolean isTemLimite() {
		return temLimite;
	}

	public double getPesoMinimo() {
		return pesoMinimo;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}
}
