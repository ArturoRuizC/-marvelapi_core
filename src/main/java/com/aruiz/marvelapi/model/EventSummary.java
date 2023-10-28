package com.aruiz.marvelapi.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EventSummary {
	
	private String resourceURI;
	private String name;
}