package com.aruiz.marvelapi.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapi.util.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
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
		String endpoint = builder.toUriString();
		CharacterDataWrapper response = new CharacterDataWrapper();
		try {
			log.info(Const.REQUEST_LABEL + endpoint);
			response = restTemplate.getForObject(endpoint, CharacterDataWrapper.class);
			log.info(Const.RESPONSE_LABEL + response.toString());
		} catch (Exception e) {
			log.error(Const.ERR_REQ_CHARACTERS + endpoint + Const.SPACE + response != null ? response.toString() : Const.EMPTY + Const.SPACE + e.getMessage());
			log.error(Const.ERR_REQ_CHARACTERS + endpoint + Const.SPACE + response != null ? response.toString() : Const.EMPTY + Const.SPACE + e.getCause());
		}
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
		String endpoint = builder.toUriString();
		
		CharacterDataWrapper response = new CharacterDataWrapper();
		try {
			log.info(Const.REQUEST_LABEL + endpoint);
			response = restTemplate.getForObject(endpoint, CharacterDataWrapper.class);
			log.info(Const.RESPONSE_LABEL + response.toString());
		} catch (Exception e) {
			log.error(Const.ERR_REQ_CHARACTERS + endpoint + Const.SPACE + response != null ? response.toString() : Const.EMPTY + Const.SPACE + e.getMessage());
			log.error(Const.ERR_REQ_CHARACTERS + endpoint + Const.SPACE + response != null ? response.toString() : Const.EMPTY + Const.SPACE + e.getCause());
		}
		return response;
	}
}