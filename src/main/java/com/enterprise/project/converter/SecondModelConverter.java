package com.enterprise.project.converter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.enterprise.project.model.SecondModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SecondModelConverter extends StdConverter<SecondModel, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convert(final SecondModel model) {
		return SecondModelConverter.encodeBase64(SecondModelConverter.toXML(model));
	}

	private static String encodeBase64(final String toEncode) {
		return Base64.getEncoder().encodeToString(toEncode.getBytes(StandardCharsets.UTF_8));
	}

	private static <T> String toXML(final T data) {
		try {
			return XmlMapper.builder().build().writeValueAsString(data);
		} catch (@SuppressWarnings("unused") final JsonProcessingException e) {
			return "";
		}
	}
}
