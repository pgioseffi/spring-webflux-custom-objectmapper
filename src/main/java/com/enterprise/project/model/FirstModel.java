package com.enterprise.project.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FirstModel(Integer first, BigDecimal second, BigDecimal third, String fourth, Boolean fifth,
		SecondModel sixth) {
	// In most cases record classes does not need any implementation.
}
