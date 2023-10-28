package com.aruiz.marvelapi.model;

import java.util.List;
import lombok.Data;

@Data
public class ComicList {
	
	private int available;
	private int returned;
	private String collectionURI;
	private List<ComicSummary> items;
}