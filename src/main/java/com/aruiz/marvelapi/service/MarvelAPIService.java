package com.aruiz.marvelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aruiz.marvelapi.interfaces.IMarvelAPIClient;
import com.aruiz.marvelapi.interfaces.IMarvelAPIService;
import com.aruiz.marvelapi.model.CharacterDataWrapper;

@Service
public class MarvelAPIService implements IMarvelAPIService{

	@Autowired
	private IMarvelAPIClient client;

	public CharacterDataWrapper consultaHeroe(Integer idHeroe) {
		return client.getCharacterById(idHeroe);
	}

	public CharacterDataWrapper listarHeroes() {
		return client.getCharacters();
	}
}