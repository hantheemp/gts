package com.muratkagan.gts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("GTS RESTful API").version("0.0.30").description(
						"API documentation for managing songs, artists, albums, genres, instrumentations, and moods"))
				.tags(List.of(new Tag().name("Songs").description("Song management APIs"),
						new Tag().name("Albums").description("Album management APIs"),
						new Tag().name("Artists").description("Artist management APIs"),
						new Tag().name("Genres").description("Genre management APIs"),
						new Tag().name("Instrumentations").description("Instrumentation management APIs"),
						new Tag().name("Moods").description("Mood management APIs")

				));
	}
}