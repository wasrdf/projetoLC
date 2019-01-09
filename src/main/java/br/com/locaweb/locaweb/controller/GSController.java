package br.com.locaweb.locaweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locaweb.locaweb.model.ElegibleTW;
import br.com.locaweb.locaweb.service.GSService;

@RestController
@RequestMapping("/v1/api")
public class GSController {
	
	@Autowired
	private GSService service;
	
	
	@GetMapping("/most_relevants")
	public List<ElegibleTW> mostRelevants() {
		
		try {
			return service.getTweets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
