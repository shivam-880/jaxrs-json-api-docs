package com.codingkapoor.jaxrsjsonapidocs.builder;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.codingkapoor.jaxrsjsonapidocs.model.Document;

public class DocumentMarshaller {

	public static String marshalToJsonAsString(Document document) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

		String jsonAsString = null;

		try {
			jsonAsString 
				= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);

		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonAsString;

	}

	public static void marshallToJsonInAFile(String absoluteFileName, Document document) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

		try {
			mapper.writeValue(new File(absoluteFileName), document);
			
		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
