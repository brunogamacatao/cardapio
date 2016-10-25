package br.brunocatao.cardapio.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Geracao {
	public static final double PESO_MINIMO = 1.0;     // 1g
	public static final double PESO_MAXIMO = 1000.0;  // 1kg
	
	private Gene gerador;
	private List<Gene> genes;
	
	public Geracao(int tamanho, Gene gerador) {
		this.gerador = gerador;
		genes = new ArrayList<>();
		for (int i = 0; i < tamanho; i++) {
			Gene g = new Gene(gerador.getDesjejum(), gerador.getLanche1(), gerador.getAlmoco(), gerador.getLanche2(), gerador.getJantar(), gerador.getCeia());
			geracaoAleatoria(g);
			genes.add(g);
		}
	}
	
	private Geracao(Gene gerador, List<Gene> genes) {
		this.gerador = gerador;
		this.genes = genes;
	}
	
	public Geracao novaGeracao() {
		// Ordena os genes de acordo com a função fitness (quanto menor, melhor)
		Collections.sort(genes, (Gene g1, Gene g2) -> {
			Double f1 = g1.getFitness();
			Double f2 = g2.getFitness();
			return f1.compareTo(f2);
		});
		
		List<Gene> novosGenes = new ArrayList<>();
		
		// 10% serão os melhores da geração passada
		int dezPct = (int)(((double)genes.size()) * 0.1);
		for (int i = 0; i < dezPct; i++) {
			novosGenes.add(genes.get(i));
		}
		// 80% serão cruzamentos dos melhores da geração passada
		int cinqPct = (int)(((double)genes.size()) * 0.8);
		for (int i = 0; i < cinqPct; i++) {
			int j = (int)(Math.random() * cinqPct);
			novosGenes.add(cruza(genes.get(i), genes.get(j)));
		}
		// 40% serão aleatorios
		int restante = genes.size() - (dezPct + cinqPct);
		for (int i = 0; i < restante; i++) {
			Gene g = new Gene(gerador.getDesjejum(), gerador.getLanche1(), gerador.getAlmoco(), gerador.getLanche2(), gerador.getJantar(), gerador.getCeia());
			geracaoAleatoria(g);
			novosGenes.add(g);
		}
		
		// Mutações aleatórias
		for (int i = dezPct; i < novosGenes.size(); i++) {
			mutacao(novosGenes.get(i), 0.005); // 0,5% de taxa mutação
		}
		
		return new Geracao(gerador, novosGenes);
	}
	
	private Gene cruza(Gene a, Gene b) {
		double[] pesosDesjejum = new double[a.getDesjejum().length];
		double[] pesosLanche1  = new double[a.getLanche1().length];
		double[] pesosAlmoco   = new double[a.getAlmoco().length];
		double[] pesosLanche2  = new double[a.getLanche2().length];
		double[] pesosJantar   = new double[a.getJantar().length];
		double[] pesosCeia     = new double[a.getCeia().length];

		for (int i = 0; i < pesosDesjejum.length; i++) pesosDesjejum[i] = Math.random() < 0.5 ? a.getPesosDesjejum()[i] : b.getPesosDesjejum()[i];
		for (int i = 0; i < pesosLanche1.length; i++) pesosLanche1[i] = Math.random() < 0.5 ? a.getPesosLanche1()[i] : b.getPesosLanche1()[i];
		for (int i = 0; i < pesosAlmoco.length; i++) pesosAlmoco[i] = Math.random() < 0.5 ? a.getPesosAlmoco()[i] : b.getPesosAlmoco()[i];
		for (int i = 0; i < pesosLanche2.length; i++) pesosLanche2[i] = Math.random() < 0.5 ? a.getPesosLanche2()[i] : b.getPesosLanche2()[i];
		for (int i = 0; i < pesosJantar.length; i++) pesosJantar[i] = Math.random() < 0.5 ? a.getPesosJantar()[i] : b.getPesosJantar()[i];
		for (int i = 0; i < pesosCeia.length; i++) pesosCeia[i] = Math.random() < 0.5 ? a.getPesosCeia()[i] : b.getPesosCeia()[i];
		
		return new Gene(a.getDesjejum(), a.getLanche1(), a.getAlmoco(), a.getLanche2(), a.getJantar(), a.getCeia(), pesosDesjejum, pesosLanche1, pesosAlmoco, pesosLanche2, pesosJantar, pesosCeia);
	}
	
	private void geracaoAleatoria(Gene g) {
		g.setPesosDesjejum(pesosAleatorios(g.getPesosDesjejum(), g.getDesjejum()));
		g.setPesosLanche1(pesosAleatorios(g.getPesosLanche1(), g.getLanche1()));
		g.setPesosAlmoco(pesosAleatorios(g.getPesosAlmoco(), g.getAlmoco()));
		g.setPesosLanche2(pesosAleatorios(g.getPesosLanche2(), g.getLanche2()));
		g.setPesosJantar(pesosAleatorios(g.getPesosJantar(), g.getJantar()));
		g.setPesosCeia(pesosAleatorios(g.getPesosCeia(), g.getCeia()));
	}
	
	private double[] pesosAleatorios(double[] pesos, Alimento[] alimentos) {
		for (int i = 0; i < pesos.length; i++) {
			if (alimentos[i].isTemLimite()) {
				pesos[i] = alimentos[i].getPesoMinimo() + Math.random() * (alimentos[i].getPesoMaximo() - alimentos[i].getPesoMinimo());
			} else {
				pesos[i] = PESO_MINIMO + Math.random() * PESO_MAXIMO;
			}
		}
		return pesos;
	}

	private void mutacao(Gene g, double prob) {
		g.setPesosDesjejum(mutacao(g.getPesosDesjejum(), prob, g.getDesjejum()));
		g.setPesosLanche1(mutacao(g.getPesosLanche1(), prob, g.getLanche1()));
		g.setPesosAlmoco(mutacao(g.getPesosAlmoco(), prob, g.getAlmoco()));
		g.setPesosLanche2(mutacao(g.getPesosLanche2(), prob, g.getLanche2()));
		g.setPesosJantar(mutacao(g.getPesosJantar(), prob, g.getJantar()));
		g.setPesosCeia(mutacao(g.getPesosCeia(), prob, g.getCeia()));
	}
	
	private double[] mutacao(double[] pesos, double prob, Alimento[] alimentos) {
		for (int i = 0; i < pesos.length; i++) {
			if (Math.random() < prob) {
				if (alimentos[i].isTemLimite()) {
					pesos[i] = alimentos[i].getPesoMinimo() + Math.random() * (alimentos[i].getPesoMaximo() - alimentos[i].getPesoMaximo());
				} else {
					pesos[i] = PESO_MINIMO + Math.random() * PESO_MAXIMO;
				}
			}
		}
		return pesos;
	}
	
	
	public Gene getMelhor() {
		// Ordena os genes de acordo com a função fitness (quanto menor, melhor)
		Collections.sort(genes, (Gene g1, Gene g2) -> {
			Double f1 = g1.getFitness();
			Double f2 = g2.getFitness();
			return f1.compareTo(f2);
		});
		
		return genes.get(0);
	}
}