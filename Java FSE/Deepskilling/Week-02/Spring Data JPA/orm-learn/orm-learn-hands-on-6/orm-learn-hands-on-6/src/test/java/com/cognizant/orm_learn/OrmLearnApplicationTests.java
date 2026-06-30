package com.cognizant.orm_learn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootTest
class OrmLearnApplicationTests {

	@Autowired
	private CountryService countryService;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldFindCountryByCode() throws Exception {
		Country country = countryService.findCountryByCode("IN");
		assertEquals("India", country.getName());
	}
}
