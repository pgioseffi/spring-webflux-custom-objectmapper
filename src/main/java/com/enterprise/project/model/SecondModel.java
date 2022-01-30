package com.enterprise.project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "second")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SecondModel(@JacksonXmlProperty(isAttribute = true) String first,
		@JacksonXmlProperty(isAttribute = true) String second, @JacksonXmlProperty(isAttribute = true) String third,
		@JacksonXmlProperty(isAttribute = true) String fourth, @JacksonXmlProperty(isAttribute = true) String fifth,
		@JacksonXmlProperty(isAttribute = true) String sixth, @JacksonXmlProperty(isAttribute = true) String seventh,
		@JacksonXmlProperty(isAttribute = true) String eighth, @JacksonXmlProperty(isAttribute = true) String ninth,
		@JacksonXmlProperty(isAttribute = true) String tenth, @JacksonXmlProperty(isAttribute = true) String eleventh,
		@JacksonXmlProperty(isAttribute = true) ThirdModel twelfth) {
	// In most cases record classes does not need any implementation.
}
