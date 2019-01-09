package br.com.locaweb.locaweb.model;

public class ElegibleTW {

	private String screen_name;
	private Integer numeroSeguidores;
	private Integer retweets;
	private Integer numeroFavoritos;
	private String conteudoTweet;
	private String dataEHora;
	private String linkPerfil;
	private String linkTweet;
	

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public Integer getNumeroSeguidores() {
		return numeroSeguidores;
	}

	public void setNumeroSeguidores(Integer numeroSeguidores) {
		this.numeroSeguidores = numeroSeguidores;
	}

	public Integer getRetweets() {
		return retweets;
	}

	public void setRetweets(Integer retweets) {
		this.retweets = retweets;
	}

	public Integer getNumeroFavoritos() {
		return numeroFavoritos;
	}

	public void setNumeroFavoritos(Integer numeroFavoritos) {
		this.numeroFavoritos = numeroFavoritos;
	}

	public String getConteudoTweet() {
		return conteudoTweet;
	}

	public void setConteudoTweet(String conteudoTweet) {
		this.conteudoTweet = conteudoTweet;
	}

	

	public String getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(String dataEHora) {
		this.dataEHora = dataEHora;
	}

	public String getLinkPerfil() {
		return linkPerfil;
	}

	public void setLinkPerfil(String linkPerfil) {
		this.linkPerfil = linkPerfil;
	}

	public String getLinkTweet() {
		return linkTweet;
	}

	public void setLinkTweet(String linkTweet) {
		this.linkTweet = linkTweet;
	}

}
