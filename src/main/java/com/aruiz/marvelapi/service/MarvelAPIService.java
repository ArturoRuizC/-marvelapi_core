package com.aruiz.marvelapi.service;

import com.aruiz.marvelapi.client.MarvelAPIClient;

public class MarvelAPIService {

	private MarvelAPIClient client;

	public Object consultaHeroe(Integer idHeroe) {
		Object heroe = client.getCharacterById(idHeroe);
		return heroe;
	}

	public Object listarHeroes() {
		Object heroes = client.getCharacters();
		return heroes;
	}
}