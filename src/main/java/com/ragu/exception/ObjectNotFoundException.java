package com.ragu.exception;

public class ObjectNotFoundException extends SystemException {
	public ObjectNotFoundException() {
		super("Required object not found");
	}

	public ObjectNotFoundException setId(Object id) {
		setParameter("id", id);
		return this;
	}

	public String getId() {
		return "id";
	}
	
}
