package model;

public class Jogos {
	protected String nome;
	protected String genero;
	protected String ano_lancamento;
	protected String desenvolvedora;
	protected String review;
	protected String nota;
	public Jogos() {
		
	}
	
	



	public Jogos(String nome, String genero, String ano_lancamento, String desenvolvedora, String review, String nota) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.ano_lancamento = ano_lancamento;
		this.desenvolvedora = desenvolvedora;
		this.review = review;
		this.nota = nota;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getAno_lancamento() {
		return ano_lancamento;
	}


	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}


	public String getDesenvolvedora() {
		return desenvolvedora;
	}


	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	
}
