package com.aruiz.marvelapi.interfaces;

import com.aruiz.marvelapi.model.CharacterDataWrapper;

public interface IMarvelAPIService {

	CharacterDataWrapper consultaHeroe(Integer idHeroe);

	CharacterDataWrapper listarHeroes();
}