package com.aruiz.marvelapi.model;

import java.util.List;
import lombok.Data;

@Data
public class CharacterDataContainer {

	private int offset;
	private int limit;
	private int total;
	private int count;
	private List<Character> results;
}