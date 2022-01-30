package com.enterprise.project;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.enterprise.project.converter.SecondModelConverter;
import com.enterprise.project.model.SecondModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;

@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	static BeanFactoryPostProcessor beanFactoryPostProcessor(final ApplicationContext beanRegistry) {
		return (final var beanFactory) -> {
			final var beanDefinitionScanner = new ClassPathBeanDefinitionScanner(
					(BeanDefinitionRegistry) ((AnnotationConfigReactiveWebServerApplicationContext) beanRegistry)
							.getBeanFactory());
			beanDefinitionScanner.addIncludeFilter(
					(final var mr, final var mrf) -> !mr.getClassMetadata().getClassName().contains("model"));

			beanDefinitionScanner.scan("com.enterprise.project");
		};
	}

	@Bean
	@Primary
	public ObjectMapper customObjectMapper(final Jackson2ObjectMapperBuilder builder) {
		return builder.serializationInclusion(JsonInclude.Include.NON_NULL)
				.serializers(new StdDelegatingSerializer(SecondModel.class, new SecondModelConverter())).build();
	}
}
