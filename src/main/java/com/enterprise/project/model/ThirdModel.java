package com.enterprise.project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "third")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ThirdModel(@JacksonXmlProperty(isAttribute = true) String first,
		@JacksonXmlProperty(isAttribute = true) String second, @JacksonXmlProperty(isAttribute = true) String third,
		@JacksonXmlProperty(isAttribute = true) String fourth, @JacksonXmlProperty(isAttribute = true) String fifth) {
	// In most cases record classes does not need any implementation.
}
