package br.com.locaweb.locaweb.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class StatusesResponse {
	
	@SerializedName(value = "statuses")
	private List<Statuses> statuses = new ArrayList<>();

	public List<Statuses> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Statuses> statuses) {
		this.statuses = statuses;
	}
	
	
	
}
