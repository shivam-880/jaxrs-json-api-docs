package com.codingkapoor.jaxrsjsonapidocs.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Request {
	String verb;
	List<String> produces;
	List<String> consumes;
	List<Parameter> parameters;

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public List<String> getProduces() {
		return produces;
	}

	public void setProduces(List<String> produces) {
		this.produces = produces;
	}

	public List<String> getConsumes() {
		return consumes;
	}

	public void setConsumes(List<String> consumes) {
		this.consumes = consumes;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "Request [verb=" + verb + ", produces=" + produces
				+ ", consumes=" + consumes + ", parameters=" + parameters + "]";
	}

	@JsonIgnore
	public boolean isEmpty() {
		return (verb != null ? verb.isEmpty() : true)
				&& (produces != null ? produces.isEmpty() : true)
				&& (consumes != null ? consumes.isEmpty() : true)
				&& (parameters != null ? parameters.isEmpty() : true);
	}
}
