package com.aruiz.marvelapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.aruiz.marvelapi.MarvelAPIConfig;
import com.aruiz.marvelapi.interfaces.IMarvelAPIService;
import com.aruiz.marvelapi.model.CharacterDataWrapper;
import com.aruiz.marvelapi.util.Const;

@ContextConfiguration(classes = MarvelAPIConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarvelAPIServiceTest {

	@Autowired
	private IMarvelAPIService marvelAPIService;

	@Test
	public void testConsultaHeroe() {

		CharacterDataWrapper wrapper = marvelAPIService.consultaHeroe(1011334);
		assertNotNull (wrapper);
		assertEquals(200, wrapper.getCode());
		assertEquals(Const.STATUS_Ok, wrapper.getStatus());
		assertNotNull(wrapper.getData().getResults());
		assertTrue(wrapper.getData().getResults().size() == Const.UNO);

	}

	@Test
	public void testListarHeroes() {

		CharacterDataWrapper wrapper = marvelAPIService.listarHeroes();
		assertNotNull(wrapper);
		assertEquals(200, wrapper.getCode());
		assertEquals(Const.STATUS_Ok, wrapper.getStatus());
		assertNotNull(wrapper.getData().getResults());
		assertTrue(wrapper.getData().getResults().size() > Const.CERO);
		
	}
}