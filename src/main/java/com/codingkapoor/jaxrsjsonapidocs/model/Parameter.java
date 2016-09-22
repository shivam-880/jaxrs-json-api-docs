package com.codingkapoor.jaxrsjsonapidocs.model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Parameter {
	String title;
	String type;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Parameter [title=" + title + ", type=" + type + "]";
	}

	@JsonIgnore
	public boolean isEmpty() {
		return (title != null ? title.isEmpty() : true)
				&& (type != null ? type.isEmpty() : true);
	}

}
