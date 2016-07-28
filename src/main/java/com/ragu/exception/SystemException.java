package com.ragu.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.CRC32;

public class SystemException extends RuntimeException {
	private Map<String, Object> paramMap = new HashMap<String, Object>();

    public static SystemException wrap(Throwable cause) {
		if (cause instanceof SystemException) {
			return (SystemException) cause;
		}

		return new SystemException(cause);
	}

	public SystemException() {
		super();
		init();
	}

	private void init() {
		CRC32 crc32 = new CRC32();
		crc32.update(UUID.randomUUID().toString().getBytes());
		setTrackingId(Long.toString(crc32.getValue(), 36).toUpperCase());
	}

	private void setTrackingId(String id) {
		setParameter("trackingId", id);
	}

	public String getTrackingId() {
		return (String) getParameterMap().get("trackingId");
	}

	public SystemException(String message) {
		super(message);
		init();
	}

	public SystemException(Throwable cause) {
		super(cause);
		init();
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
		init();
	}

	public SystemException setParameter(String key, Object value) {
		this.paramMap.put(key, value);
		return this;
	}

	public SystemException setParameters(Map<String, ?> parameters) {
		this.paramMap.putAll(parameters);
		return this;
	}

	public Map<String, Object> getParameterMap() {
		return this.paramMap;
	}


 	public String getMessage() {
		StringBuilder message = new StringBuilder()
				.append(super.getMessage() == null ? "" : super.getMessage());

		if (paramMap.isEmpty()) {
			return message.toString();
		}

		message.append(" {");
		message.append("}");

		return message.toString();
	}

}
