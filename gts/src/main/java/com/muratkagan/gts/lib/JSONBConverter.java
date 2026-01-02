package com.muratkagan.gts.lib;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Converter(autoApply = true) // set true if you want it applied globally
public class JSONBConverter implements AttributeConverter<Map<String, Object>, String> {

	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		if (attribute == null) {
			return null;
		}
		return mapper.writeValueAsString(attribute);

	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return mapper.readValue(dbData, new TypeReference<Map<String, Object>>() {
		});
	}
}