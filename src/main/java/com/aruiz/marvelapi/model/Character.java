package com.aruiz.marvelapi.model;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Character {
	
	private int id;
	private String name;
	private String description;
	private Date modified;
	private String resourceURI;
	private List<Url> urls;
	private Image thumbnail;
	private ComicList comics;
	private StoryList stories;
	private EventList events;
	private SeriesList series;
}