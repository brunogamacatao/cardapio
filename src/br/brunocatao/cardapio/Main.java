package br.brunocatao.cardapio;

import br.brunocatao.cardapio.entidades.Alimento;
import br.brunocatao.cardapio.entidades.Gene;
import br.brunocatao.cardapio.entidades.Geracao;
import br.brunocatao.cardapio.entidades.Parametros;

public class Main {
	public static final int TAMANHO_GERACAO = 10000;
	public static final int MAX_GERACOES = 10000;
	
	public static void main(String[] args) {
		Parametros p = Parametros.getInstance();
		p.setTotalCalorias(2081);
		p.setCarboidratosTotais(312);
		p.setLipidiosTotais(58);
		p.setProteinasTotais(78);
		
		Gene gerador = new Gene(
				new Alimento[]{
						Alimento.novo("Banana Maçã", 114, 26.44, 0.25, 1.44, 100, 86, 86), 
						Alimento.novo("Aveia em Flocos", 328.6, 65, 1.4, 14, 100, 10, 20), 
						Alimento.novo("Pão de centeio integral", 232, 45.5, 0.9, 10.4, 100, 50, 60), 
						Alimento.novo("Ovo", 157.5, 0.7, 11.5, 12.8, 100, 45, 90), 
						Alimento.novo("Leite Desnatado", 36.1, 5, 0.1, 3.6, 100, 200, 200), 
						Alimento.novo("Café Solúvel", 129, 35, 0, 0, 100, 1.5, 3.0)},
				new Alimento[]{
						Alimento.novo("Iogurte Natural Desnatado", 41, 5.8, 0.3, 3.8, 100, 100, 200), 
						Alimento.novo("Linhaça", 49.5, 43.3, 32.3, 14.1, 100, 5, 10), 
						Alimento.novo("Maçã com Casca", 63.2, 14.2, 0.5, 0.4, 100, 100, 190)},
				new Alimento[]{
						Alimento.novo("Arroz Integral", 124, 25.8, 1, 2.6, 100), 
						Alimento.novo("Feijão Carioca", 76, 13.6, 0.5, 4.8, 100, 90, 180), 
						Alimento.novo("Beterraba", 44.1, 9.8, 0.1, 1, 100, 10, 60), 
						Alimento.novo("Tomate", 21, 5.1, 0, 0.8, 100, 10, 60), 
						Alimento.novo("Pepino", 10, 2, 0, 0.9, 100, 10, 60), 
						Alimento.novo("Filé Mignon", 220, 0, 8.8, 32.8, 100, 33, 1000), 
						Alimento.novo("Filé de Frango", 145.6, 0, 12.6, 20.2, 100, 33, 1000), 
						Alimento.novo("Chocolate Amargo", 615.2, 29.3, 52.9, 5.5, 100), 
						Alimento.novo("Suco de Limão", 39.2, 9.8, 0, 0, 100, 15, 15)},
				new Alimento[]{
						Alimento.novo("Torrada", 312.8, 63.6, 1.6, 11, 100, 15, 30), 
						Alimento.novo("Requeijão", 257, 2.4, 23.4, 9.6, 100, 5, 10), 
						Alimento.novo("Chá de erva doce", 1, 0.4, 0, 0, 100, 100, 200)},
				new Alimento[]{
						Alimento.novo("Grão de Bico", 115, 17.7, 2.2, 6.1, 100, 0, 60),
						Alimento.novo("Cará Cozido", 78, 18.9, 0.1, 1.5, 100, 0, 200),
						Alimento.novo("Cebola", 20, 3.4, 0.4, 1.9, 100, 5, 10), 
						Alimento.novo("Tomate", 21, 5.1, 0, 0.8, 100, 10, 30), 
						Alimento.novo("Coentro", 294, 26.7, 15.6, 11.5, 100, 1, 4), 
						Alimento.novo("Limão", 32, 11.1, 0.1, 0.9, 100, 7.5, 7.5), 
						Alimento.novo("Azeite", 884, 0, 100, 0, 100, 7.6, 7.6), 
						Alimento.novo("Filé Mignon", 220, 0, 8.8, 32.8, 100, 0, 1000), 
						Alimento.novo("Filé de Frango", 145.6, 0, 12.6, 20.2, 100, 33, 1000), 
						Alimento.novo("Suco de Limão", 39.2, 9.8, 0, 0, 100, 15, 30)},
				new Alimento[]{
						Alimento.novo("Mamão Papaia", 40, 10.4, 0.1, 0.5, 100, 50, 282)}
		);
		Geracao geracao = new Geracao(TAMANHO_GERACAO, gerador);
		
		for (int i = 0; i < MAX_GERACOES; i++) {
			System.out.println("Geracao " + i + " - melhor gene\n" + geracao.getMelhor());
			System.out.println("--------------------------------------------------------------------------------");
			geracao = geracao.novaGeracao();
		}
	}
}
