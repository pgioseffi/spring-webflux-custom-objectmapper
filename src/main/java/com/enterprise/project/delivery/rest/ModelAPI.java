package com.enterprise.project.delivery.rest;

import com.enterprise.project.model.FirstModel;

import reactor.core.publisher.Mono;

public interface ModelAPI {

	Mono<FirstModel> getResponseModel();

}
