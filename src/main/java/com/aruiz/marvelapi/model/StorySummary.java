package com.aruiz.marvelapi.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StorySummary {
	
	private String resourceURI;
	private String name;
	private String type;
}