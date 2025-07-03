package model;

import java.io.*;
import java.util.ArrayList;

public class ArquivoJogo {

		private static final String Caminho = "jogos.txt";
		
		public static void salvarJogos(ArrayList<Jogos> lista) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(Caminho))){
				for (Jogos j : lista) {
					String linha = j.getNome() + ";" + j.getGenero() + ";" + j.getAno_lancamento() + ";" + j.getDesenvolvedora() + ";" + j.getReview() + ";" + j.getNota();
					bw.write(linha);
					bw.newLine();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static ArrayList<Jogos> carregarJogos(){
			ArrayList<Jogos> lista = new ArrayList<>();
			try( BufferedReader br = new BufferedReader(new FileReader(Caminho))){
				String linha;
				while((linha = br.readLine()) != null) {
					String[] partes = linha.split(";");
					if(partes.length == 6) {
						Jogos j = new Jogos(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);
						lista.add(j);
					}
				}
			} catch(IOException e) {
				
			}
			return lista;
			
		}
		
	
}
