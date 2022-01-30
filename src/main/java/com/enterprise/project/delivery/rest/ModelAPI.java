package com.enterprise.project.delivery.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.enterprise.project.model.FirstModel;

import reactor.core.publisher.Mono;

public interface ModelAPI {

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	Mono<FirstModel> getResponseModel();

}
