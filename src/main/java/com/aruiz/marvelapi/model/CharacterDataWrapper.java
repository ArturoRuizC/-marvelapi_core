package com.aruiz.marvelapi.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CharacterDataWrapper {

	private String urlRequest;
	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private CharacterDataContainer data;
	private String etag;
}