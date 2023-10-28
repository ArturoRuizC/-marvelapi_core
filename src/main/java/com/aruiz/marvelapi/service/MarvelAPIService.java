package com.aruiz.marvelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aruiz.marvelapi.client.MarvelAPIClient;
import com.aruiz.marvelapi.model.CharacterDataWrapper;

@Service
public class MarvelAPIService {

	@Autowired
	private MarvelAPIClient client;

	public CharacterDataWrapper consultaHeroe(Integer idHeroe) {
		return client.getCharacterById(idHeroe);
	}

	public CharacterDataWrapper listarHeroes() {
		return client.getCharacters();
	}
}