package com.aruiz.marvelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aruiz.marvelapi.client.MarvelAPIClient;

@Component
public class MarvelAPIService {

	@Autowired
	private MarvelAPIClient client;

	public Object consultaHeroe(Integer idHeroe) {
		return client.getCharacterById(idHeroe);
	}

	public Object listarHeroes() {
		return client.getCharacters();
	}
}