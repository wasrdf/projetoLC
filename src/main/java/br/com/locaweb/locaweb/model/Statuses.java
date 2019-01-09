package br.com.locaweb.locaweb.model;

import com.google.gson.annotations.SerializedName;

public class Statuses {

	private String id_str;
	private String text;
	private Long in_reply_to_user_id;
	private String in_reply_to_status_id_str;
	@SerializedName(value = "entities")
	private Entities entities = new Entities();
	private Integer retweet_count;
	private Integer favorite_count;
	private String created_at;
	private String url;
	private String profile_image_url_https;
	private Integer followers_count;
	
	private String in_reply_to_screen_name;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user = new User();

	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}

	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}


	public Integer getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(Integer followers_count) {
		this.followers_count = followers_count;
	}

	public Integer getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(Integer favorite_count) {
		this.favorite_count = favorite_count;
	}

	

	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}

	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	public Integer getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(Integer retweet_count) {
		this.retweet_count = retweet_count;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	

	public Long getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}

	public void setIn_reply_to_user_id(Long in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

}
