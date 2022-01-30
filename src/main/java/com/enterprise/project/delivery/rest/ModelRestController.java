package com.enterprise.project.delivery.rest;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.project.model.FirstModel;
import com.enterprise.project.model.SecondModel;
import com.enterprise.project.model.ThirdModel;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("model")
public class ModelRestController implements ModelAPI {

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<FirstModel> getResponseModel() {
		return Mono.justOrEmpty(new FirstModel(Integer.valueOf(1), BigDecimal.ONE, BigDecimal.TEN, "Description",
				Boolean.TRUE, new SecondModel("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
						"Ten", "Eleven", new ThirdModel("One", "Two", "Three", "Four", "Five"))));
	}
}
