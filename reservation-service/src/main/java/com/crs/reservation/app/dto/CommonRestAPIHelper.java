package com.crs.reservation.app.dto;

import java.util.LinkedHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CommonRestAPIHelper {
	
	@SuppressWarnings("unchecked")
    @JsonIgnoreProperties
    public static Object getResponse(ResponseEntity<?> response, Class type) {
        Object object = null;
        if (HttpStatus.OK.equals(response.getStatusCode())) {
            ObjectMapper mapper = new ObjectMapper();
          //  mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String json = null;
            if (response.getBody() instanceof LinkedHashMap) {
                try {
                    json = mapper.writeValueAsString(response.getBody());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            } else {
                json = response.getBody().toString();
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(json);
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                if (jsonObject.has("response")) {
                    try {
                        JsonElement response1 = jsonObject.get("response");
                        object = mapper.readValue(response1.toString(), type);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        object = mapper.readValue(response.getBody().toString(), type);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
           // throw new BusinessException("7013");
        }
        return object;
    }

}
