package com.codingkapoor.jaxrsjsonapidocs.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.codingkapoor.jaxrsjsonapidocs.builder.DocumentBuilder;
import com.codingkapoor.jaxrsjsonapidocs.builder.DocumentMarshaller;
import com.codingkapoor.jaxrsjsonapidocs.model.Document;
import com.codingkapoor.jaxrsjsonapidocs.resource.MessageResourceI;

public class JaxrsJsonApiDocBuilderTest {

	@Test
	public void testJaxrsJsonApiDocBuild() {
		DocumentBuilder builder = new DocumentBuilder();

		List<Class<?>> classes = new ArrayList<>();
		classes.add(MessageResourceI.class);

		for (Class<?> clazz : classes) {
			Document document = builder.buildDocument(clazz);

			String expectedApiDocumentString 
				= "{\"resources\":[{\"path\":\"/messenger/messages\",\"requests\":[{\"verb\":\"javax.ws.rs.GET\",\"produces\":[\"application/json\"],\"parameters\":[{\"title\":\"messageId\",\"type\":\"int\"}]}]}]}";
			
			assertEquals(DocumentMarshaller.marshalToJsonAsString(document).replaceAll("\\s+",""), expectedApiDocumentString);
		}
	}
}
