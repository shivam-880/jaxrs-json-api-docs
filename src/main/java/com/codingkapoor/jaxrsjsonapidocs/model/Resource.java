package com.codingkapoor.jaxrsjsonapidocs.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Resource {
	String path;
	List<Request> requests;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Resource [path=" + path + ", requests=" + requests + "]";
	}

	@JsonIgnore
	public boolean isEmpty() {
		return (path != null ? path.isEmpty() : true)
				&& (requests != null ? requests.isEmpty() : true);
	}
}
