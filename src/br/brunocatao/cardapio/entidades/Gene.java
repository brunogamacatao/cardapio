package br.brunocatao.cardapio.entidades;

import java.text.NumberFormat;

public class Gene {
	private Alimento[] desjejum, lanche1, almoco, lanche2, jantar, ceia;
	private double[] pesosDesjejum, pesosLanche1, pesosAlmoco, pesosLanche2, pesosJantar, pesosCeia;
	
	public Gene(Alimento[] desjejum, Alimento[] lanche1, Alimento[] almoco, Alimento[] lanche2, Alimento[] jantar, Alimento[] ceia) {
		this.desjejum = desjejum;
		this.lanche1  = lanche1;
		this.almoco   = almoco;
		this.lanche2  = lanche2;
		this.jantar   = jantar;
		this.ceia     = ceia;
		
		pesosDesjejum = new double[this.desjejum.length];
		pesosLanche1  = new double[this.lanche1.length];
		pesosAlmoco   = new double[this.almoco.length];
		pesosLanche2  = new double[this.lanche2.length];
		pesosJantar   = new double[this.jantar.length];
		pesosCeia     = new double[this.ceia.length];
	}
	
	public Gene(Alimento[] desjejum, Alimento[] lanche1, Alimento[] almoco, Alimento[] lanche2, Alimento[] jantar,
			Alimento[] ceia, double[] pesosDesjejum, double[] pesosLanche1, double[] pesosAlmoco, double[] pesosLanche2,
			double[] pesosJantar, double[] pesosCeia) {
		this.desjejum = desjejum;
		this.lanche1 = lanche1;
		this.almoco = almoco;
		this.lanche2 = lanche2;
		this.jantar = jantar;
		this.ceia = ceia;
		this.pesosDesjejum = pesosDesjejum;
		this.pesosLanche1 = pesosLanche1;
		this.pesosAlmoco = pesosAlmoco;
		this.pesosLanche2 = pesosLanche2;
		this.pesosJantar = pesosJantar;
		this.pesosCeia = pesosCeia;
	}



	public static class DadosNutricionais {
		public double calorias, carboidratos, lipidios, proteinas;
		
		public DadosNutricionais(double calorias, double carboidratos, double lipidios, double proteinas) {
			this.calorias     = calorias;
			this.carboidratos = carboidratos;
			this.lipidios     = lipidios;
			this.proteinas    = proteinas;
		}
	}
	
	public DadosNutricionais getValorDesjejum() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < desjejum.length; i++) {
			calorias += pesosDesjejum[i] * desjejum[i].getCalorias();
			carboidratos += pesosDesjejum[i] * desjejum[i].getCarboidratos();
			lipidios += pesosDesjejum[i] * desjejum[i].getLipidios();
			proteinas += pesosDesjejum[i] * desjejum[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}
	
	public DadosNutricionais getValorLanche1() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < lanche1.length; i++) {
			calorias += pesosLanche1[i] * lanche1[i].getCalorias();
			carboidratos += pesosLanche1[i] * lanche1[i].getCarboidratos();
			lipidios += pesosLanche1[i] * lanche1[i].getLipidios();
			proteinas += pesosLanche1[i] * lanche1[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}

	public DadosNutricionais getValorAlmoco() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < almoco.length; i++) {
			calorias += pesosAlmoco[i] * almoco[i].getCalorias();
			carboidratos += pesosAlmoco[i] * almoco[i].getCarboidratos();
			lipidios += pesosAlmoco[i] * almoco[i].getLipidios();
			proteinas += pesosAlmoco[i] * almoco[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}

	public DadosNutricionais getValorLanche2() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < lanche2.length; i++) {
			calorias += pesosLanche2[i] * lanche2[i].getCalorias();
			carboidratos += pesosLanche2[i] * lanche2[i].getCarboidratos();
			lipidios += pesosLanche2[i] * lanche2[i].getLipidios();
			proteinas += pesosLanche2[i] * lanche2[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}
	
	public DadosNutricionais getValorJantar() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < jantar.length; i++) {
			calorias += pesosJantar[i] * jantar[i].getCalorias();
			carboidratos += pesosJantar[i] * jantar[i].getCarboidratos();
			lipidios += pesosJantar[i] * jantar[i].getLipidios();
			proteinas += pesosJantar[i] * jantar[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}
	
	public DadosNutricionais getValorCeia() {
		double calorias     = 0.0;
		double carboidratos = 0.0;
		double lipidios     = 0.0; 
		double proteinas    = 0.0;
		
		for (int i = 0; i < ceia.length; i++) {
			calorias += pesosCeia[i] * ceia[i].getCalorias();
			carboidratos += pesosCeia[i] * ceia[i].getCarboidratos();
			lipidios += pesosCeia[i] * ceia[i].getLipidios();
			proteinas += pesosCeia[i] * ceia[i].getProteinas();
		}
		
		return new DadosNutricionais(calorias, carboidratos, lipidios, proteinas);
	}

	public Alimento[] getDesjejum() {
		return desjejum;
	}

	public Alimento[] getLanche1() {
		return lanche1;
	}

	public Alimento[] getAlmoco() {
		return almoco;
	}

	public Alimento[] getLanche2() {
		return lanche2;
	}

	public Alimento[] getJantar() {
		return jantar;
	}

	public Alimento[] getCeia() {
		return ceia;
	}

	public double[] getPesosDesjejum() {
		return pesosDesjejum;
	}

	public void setPesosDesjejum(double[] pesosDesjejum) {
		this.pesosDesjejum = pesosDesjejum;
	}

	public double[] getPesosLanche1() {
		return pesosLanche1;
	}

	public void setPesosLanche1(double[] pesosLanche1) {
		this.pesosLanche1 = pesosLanche1;
	}

	public double[] getPesosAlmoco() {
		return pesosAlmoco;
	}

	public void setPesosAlmoco(double[] pesosAlmoco) {
		this.pesosAlmoco = pesosAlmoco;
	}

	public double[] getPesosLanche2() {
		return pesosLanche2;
	}

	public void setPesosLanche2(double[] pesosLanche2) {
		this.pesosLanche2 = pesosLanche2;
	}

	public double[] getPesosJantar() {
		return pesosJantar;
	}

	public void setPesosJantar(double[] pesosJantar) {
		this.pesosJantar = pesosJantar;
	}

	public double[] getPesosCeia() {
		return pesosCeia;
	}

	public void setPesosCeia(double[] pesosCeia) {
		this.pesosCeia = pesosCeia;
	}
	
	public double getFitness() {
		Parametros p = Parametros.getInstance();
		
		DadosNutricionais valorDesjejum = getValorDesjejum();
		DadosNutricionais valorLanche1  = getValorLanche1();
		DadosNutricionais valorAlmoco   = getValorAlmoco();
		DadosNutricionais valorLanche2  = getValorLanche2();
		DadosNutricionais valorJantar   = getValorJantar();
		DadosNutricionais valorCeia     = getValorCeia();
		
		double distancia = 0.0;

		// Calcula a distância total a partir dos macronutrientes
		// CARBO
		double totalCarbo = valorDesjejum.carboidratos + valorLanche1.carboidratos + valorAlmoco.carboidratos + valorLanche2.carboidratos + valorJantar.carboidratos + valorCeia.carboidratos;
		if (totalCarbo < p.getCarboidratosTotais() * 0.99) distancia += Math.abs(totalCarbo - p.getCarboidratosTotais() * 0.99);
		if (totalCarbo > p.getCarboidratosTotais() * 1.05) distancia += Math.abs(totalCarbo - p.getCarboidratosTotais() * 1.05);
		// LIPIDIOS
		double totalLipidios = valorDesjejum.lipidios + valorLanche1.lipidios + valorAlmoco.lipidios + valorLanche2.lipidios + valorJantar.lipidios + valorCeia.lipidios;
		if (totalLipidios < p.getLipidiosTotais() * 0.99) distancia += Math.abs(totalLipidios - p.getLipidiosTotais() * 0.99);
		if (totalLipidios > p.getLipidiosTotais() * 1.05) distancia += Math.abs(totalLipidios - p.getLipidiosTotais() * 1.05);
		// PROTEINAS
		double totalProteinas = valorDesjejum.proteinas + valorLanche1.proteinas + valorAlmoco.proteinas + valorLanche2.proteinas + valorJantar.proteinas + valorCeia.proteinas;
		if (totalProteinas < p.getProteinasTotais() * 0.99) distancia += Math.abs(totalProteinas - p.getProteinasTotais() * 0.99);
		if (totalProteinas > p.getProteinasTotais() * 1.05) distancia += Math.abs(totalProteinas - p.getProteinasTotais() * 1.05);
		
		// Calcula a distância a partir das calorias de cada refeição
		if (valorDesjejum.calorias < p.getCalDesjejum()[0] * 0.99) distancia += Math.abs(valorDesjejum.calorias - p.getCalDesjejum()[0] * 0.99);
		if (valorDesjejum.calorias > p.getCalDesjejum()[1] * 1.05) distancia += Math.abs(valorDesjejum.calorias - p.getCalDesjejum()[1] * 1.05);
		if (valorLanche1.calorias < p.getCalLanche1() * 0.99) distancia += Math.abs(valorLanche1.calorias - p.getCalLanche1() * 0.99);
		if (valorLanche1.calorias > p.getCalLanche1() * 1.05) distancia += Math.abs(valorLanche1.calorias - p.getCalLanche1() * 1.05);
		if (valorAlmoco.calorias < p.getCalAlmoco()[0] * 0.99) distancia += Math.abs(valorAlmoco.calorias - p.getCalAlmoco()[0] * 0.99);
		if (valorAlmoco.calorias > p.getCalAlmoco()[1] * 1.05) distancia += Math.abs(valorAlmoco.calorias - p.getCalAlmoco()[1] * 1.05);
		if (valorLanche2.calorias < p.getCalLanche2() * 0.99) distancia += Math.abs(valorLanche2.calorias - p.getCalLanche2() * 0.99);
		if (valorLanche2.calorias < p.getCalLanche2() * 1.05) distancia += Math.abs(valorLanche2.calorias - p.getCalLanche2() * 1.05);
		if (valorJantar.calorias < p.getCalJantar()[0] * 0.99) distancia += Math.abs(valorJantar.calorias - p.getCalJantar()[0] * 0.99);
		if (valorJantar.calorias > p.getCalJantar()[1] * 1.05) distancia += Math.abs(valorJantar.calorias - p.getCalJantar()[1] * 1.05);
		if (valorCeia.calorias < p.getCalCeia() * 0.99) distancia += Math.abs(valorCeia.calorias - p.getCalCeia() * 0.99);
		if (valorCeia.calorias > p.getCalCeia() * 1.05) distancia += Math.abs(valorCeia.calorias - p.getCalCeia() * 1.05);
		
		return distancia;
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getNumberInstance();
		fmt.setMaximumFractionDigits(1);
		
		StringBuilder str = new StringBuilder();
		
		str.append("Desjejum:\n");
		for (int i = 0; i < desjejum.length; i++) str.append("\t" + dadosAlimento(i, desjejum, pesosDesjejum) + "\n");
		str.append("Lanche:\n");
		for (int i = 0; i < lanche1.length; i++) str.append("\t" + dadosAlimento(i, lanche1, pesosLanche1) + "\n");
		str.append("Almoço:\n");
		for (int i = 0; i < almoco.length; i++) str.append("\t" + dadosAlimento(i, almoco, pesosAlmoco) + "\n");
		str.append("Lanche:\n");
		for (int i = 0; i < lanche2.length; i++) str.append("\t" + dadosAlimento(i, lanche2, pesosLanche2) + "\n");
		str.append("Jantar:\n");
		for (int i = 0; i < jantar.length; i++) str.append("\t" + dadosAlimento(i, jantar, pesosJantar) + "\n");
		str.append("Ceia:\n");
		for (int i = 0; i < ceia.length; i++) str.append("\t" + dadosAlimento(i, ceia, pesosCeia) + "\n");
		
		DadosNutricionais valorDesjejum = getValorDesjejum();
		DadosNutricionais valorLanche1  = getValorLanche1();
		DadosNutricionais valorAlmoco   = getValorAlmoco();
		DadosNutricionais valorLanche2  = getValorLanche2();
		DadosNutricionais valorJantar   = getValorJantar();
		DadosNutricionais valorCeia     = getValorCeia();
		
		double calTotal = valorDesjejum.calorias + valorLanche1.calorias + valorAlmoco.calorias + valorLanche2.calorias + valorJantar.calorias + valorCeia.calorias;
		double carTotal = valorDesjejum.carboidratos + valorLanche1.carboidratos + valorAlmoco.carboidratos + valorLanche2.carboidratos + valorJantar.carboidratos + valorCeia.carboidratos;
		double proTotal = valorDesjejum.proteinas + valorLanche1.proteinas + valorAlmoco.proteinas + valorLanche2.proteinas + valorJantar.proteinas + valorCeia.proteinas;
		double lipTotal = valorDesjejum.lipidios + valorLanche1.lipidios + valorAlmoco.lipidios + valorLanche2.lipidios + valorJantar.lipidios + valorCeia.lipidios;
		
		str.append("Desjejum: CAL = " + fmt.format(valorDesjejum.calorias) + ", HC = " + fmt.format(valorDesjejum.carboidratos) + ", PR = " + fmt.format(valorDesjejum.proteinas) + ", LP = " + fmt.format(valorDesjejum.lipidios) + "\n");
		str.append("Lanche:   CAL = " + fmt.format(valorLanche1.calorias) + ", HC = " + fmt.format(valorLanche1.carboidratos) + ", PR = " + fmt.format(valorLanche1.proteinas) + ", LP = " + fmt.format(valorLanche1.lipidios) + "\n");
		str.append("Almoço:   CAL = " + fmt.format(valorAlmoco.calorias) + ", HC = " + fmt.format(valorAlmoco.carboidratos) + ", PR = " + fmt.format(valorAlmoco.proteinas) + ", LP = " + fmt.format(valorAlmoco.lipidios) + "\n");
		str.append("Lanche:   CAL = " + fmt.format(valorLanche2.calorias) + ", HC = " + fmt.format(valorLanche2.carboidratos) + ", PR = " + fmt.format(valorLanche2.proteinas) + ", LP = " + fmt.format(valorLanche2.lipidios) + "\n");
		str.append("Jantar:   CAL = " + fmt.format(valorJantar.calorias) + ", HC = " + fmt.format(valorJantar.carboidratos) + ", PR = " + fmt.format(valorJantar.proteinas) + ", LP = " + fmt.format(valorJantar.lipidios) + "\n");
		str.append("Ceia:     CAL = " + fmt.format(valorCeia.calorias) + ", HC = " + fmt.format(valorCeia.carboidratos) + ", PR = " + fmt.format(valorCeia.proteinas) + ", LP = " + fmt.format(valorCeia.lipidios) + "\n");
		str.append("Totais:   CAL = " + fmt.format(calTotal)  + ", HC = " + fmt.format(carTotal) + ", PR = " + fmt.format(proTotal) + ", LP = " + fmt.format(lipTotal) + "\n");

		str.append("Fitness = " + getFitness());
		
		return str.toString();
	}
	
	private String dadosAlimento(int i, Alimento[] alimentos, double[] pesos) {
		Alimento a = alimentos[i];
		double cal = a.getCalorias() * pesos[i];
		double car = a.getCarboidratos() * pesos[i];
		double pro = a.getProteinas() * pesos[i];
		double lip = a.getLipidios() * pesos[i];
		
		NumberFormat fmt = NumberFormat.getNumberInstance();
		fmt.setMaximumFractionDigits(1);
		
		return a.getNome() + " " + fmt.format(pesos[i]) + "g - CAL = " + fmt.format(cal) + ", HC = " + fmt.format(car) + ", PR = " + fmt.format(pro) + ", LP = " + fmt.format(lip);
	}
}