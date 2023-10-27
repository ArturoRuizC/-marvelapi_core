package com.aruiz.marvelapi.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.aruiz.marvelapi.util.Const;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarvelAPIClient {

    private final RestTemplate restTemplate;

    @Autowired
    public MarvelAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	@Value("${marvel.api.urlprincipal}")
	private String url;

	@Value("${marvel.api.apikey}")
	private String apikey;

	@Value("${marvel.api.hash}")
	private String hash;
	
	@Value("${marvel.api.segmentVersion}")
	private String segmentVersion;
	
	@Value("${marvel.api.segmentAcces}")
	private String segmentAcces;
	
	@Value("${marvel.api.segmentObject}")
	private String segmentObject;
	

	public Object getCharacters() {
		UriComponentsBuilder builder = 	UriComponentsBuilder.fromOriginHeader(url)
				.pathSegment(segmentVersion)
				.pathSegment(segmentAcces)
				.pathSegment(segmentObject)
				.queryParam(Const.TS_LABEL, Const.UNO)
				.queryParam(Const.APIKEY_LABEL, apikey)
				.queryParam(Const.HASH_LABEL, hash);
		String endpoitn = builder.toUriString();
		Object response = restTemplate.getForObject(endpoitn, Object.class);
		return response;
	}

	public Object getCharacterById(Integer idCharacter) {
		UriComponentsBuilder builder = 	UriComponentsBuilder.fromOriginHeader(url)
				.pathSegment(segmentVersion)
				.pathSegment(segmentAcces)
				.pathSegment(segmentObject)
				.pathSegment(idCharacter.toString())
				.queryParam(Const.TS_LABEL, Const.UNO)
				.queryParam(Const.APIKEY_LABEL, apikey)
				.queryParam(Const.HASH_LABEL, hash);
		String endpoitn = builder.toUriString();
		Object response = restTemplate.getForObject(endpoitn, Object.class);
		return response;
	}
}