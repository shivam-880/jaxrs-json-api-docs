package com.codingkapoor.jaxrsjsonapidocs.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Document {
	List<Resource> resources;

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Document [resources=" + resources + "]";
	}

	@JsonIgnore
	public boolean isEmpty() {
		return (resources != null ? resources.isEmpty() : true);
	}

}
