package com.aruiz.marvelapi.interfaces;

import com.aruiz.marvelapi.model.CharacterDataWrapper;

public interface IMarvelAPIClient {

	CharacterDataWrapper getCharacterById(Integer idCharacter);
	
	CharacterDataWrapper getCharacters();
}