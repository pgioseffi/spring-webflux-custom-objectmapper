package com.enterprise.project.serializer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.enterprise.project.model.FirstModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ModelSerializer extends StdSerializer<FirstModel> {

	private static final long serialVersionUID = -5754330070183741830L;

	public ModelSerializer() {
		this(FirstModel.class);
	}

	public ModelSerializer(final Class<FirstModel> model) {
		super(model);
	}

	@Override
	public void serialize(final FirstModel model, final JsonGenerator jgen,
			@SuppressWarnings("unused") final SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeNumberField("one", model.second());

		final var totalValue = model.third();
		if (totalValue != null) {
			jgen.writeNumberField("two", totalValue);
		}

		jgen.writeNumberField("three", model.first().intValue());
		jgen.writeStringField("four", model.fourth());

		final var surcharge = model.fifth();
		if (surcharge != null) {
			jgen.writeBooleanField("five", surcharge.booleanValue());
		}

		jgen.writeStringField("six", ModelSerializer.encodeBase64(ModelSerializer.toXML(model.sixth())));
		jgen.writeEndObject();
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
