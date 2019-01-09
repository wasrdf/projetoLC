package br.com.locaweb.locaweb.model;

public class User {
	
	private Integer favourites_count;
	private String screen_name;
	private Integer followers_count;
	private String profile_image_url;

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public Integer getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(Integer followers_count) {
		this.followers_count = followers_count;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public Integer getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(Integer favourites_count) {
		this.favourites_count = favourites_count;
	}
	
	
	
}
