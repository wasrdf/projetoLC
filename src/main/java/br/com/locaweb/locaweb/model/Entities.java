package br.com.locaweb.locaweb.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Entities {
	
	@SerializedName(value = "user_mentions")
	private List<UserMentions> userMentions = new ArrayList<>();

	public List<UserMentions> getUserMentions() {
		return userMentions;
	}

	public void setUserMentions(List<UserMentions> userMentions) {
		this.userMentions = userMentions;
	}
	
	
	
}
