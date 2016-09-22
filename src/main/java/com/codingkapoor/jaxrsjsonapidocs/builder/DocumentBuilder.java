package com.codingkapoor.jaxrsjsonapidocs.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codingkapoor.jaxrsjsonapidocs.model.Document;
import com.codingkapoor.jaxrsjsonapidocs.model.Parameter;
import com.codingkapoor.jaxrsjsonapidocs.model.Request;
import com.codingkapoor.jaxrsjsonapidocs.model.Resource;

import javax.ws.rs.*;

public class DocumentBuilder {

	public Document buildDocument(Class<?> clazz) {
		Document document = new Document();

		List<Resource> resources = getResources(clazz);
		document.setResources(resources);

		return (document.isEmpty() ? null : document);
	}

	private List<Resource> getResources(Class<?> clazz) {
		List<Resource> resources = new ArrayList<>();

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			Resource resource = new Resource();
			List<Request> requests = new ArrayList<>();

			Request request = new Request();

			List<Parameter> parameters = getQueryParameters(method);
			request.setParameters(parameters);

			ArrayList<Annotation> annotations = new ArrayList<>(
					Arrays.asList(method.getDeclaredAnnotations()));

			for (Annotation annotation : annotations) {
				if (annotation instanceof GET || annotation instanceof POST	|| annotation instanceof PUT) {
					request.setVerb(annotation.annotationType().getName());
				}

				if (annotation instanceof Produces) {
					List<String> produces 
						= new ArrayList<>(Arrays.asList(((Produces) annotation).value()));
						
					request.setProduces(produces);
				}

				if (annotation instanceof Consumes) {
					List<String> consumes 
						= new ArrayList<>(Arrays.asList(((Consumes) annotation).value()));
						
					request.setProduces(consumes);
				}

				if (annotation instanceof Path) {
					String subResourcePath = ((Path) annotation).value();
					resource.setPath(getBaseResourcePath(clazz)	+ subResourcePath);
				}

			}

			if (!request.isEmpty())
				requests.add(request);

			if (!requests.isEmpty())
				resource.setRequests(requests);

			if (!resource.isEmpty())
				resources.add(resource);
		}

		return (resources.isEmpty() ? null : resources);
	}

	private List<Parameter> getQueryParameters(Method method) {
		List<Parameter> parameters = new ArrayList<>();

		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Class<?>[] parameterTypes = method.getParameterTypes();

		int i = 0;
		for (Annotation[] annotations : parameterAnnotations) {
			Class<?> parameterType = parameterTypes[i++];

			for (Annotation annotation : annotations) {
				if (annotation instanceof QueryParam) {
					String queryParameterName = ((QueryParam) annotation).value();
					String queryParameterType = parameterType.getName();

					Parameter parameter = new Parameter();
					parameter.setTitle(queryParameterName);
					parameter.setType(queryParameterType);

					parameters.add(parameter);
				}
			}
		}

		return (parameters.isEmpty() ? null : parameters);
	}

	private String getBaseResourcePath(Class<?> clazz) {
		String path = "";

		Path pathAnnotation = (Path) clazz.getAnnotation(Path.class);
		if (pathAnnotation != null) {
			path = pathAnnotation.value();
		}

		return path;
	}

}
