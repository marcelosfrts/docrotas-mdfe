package com.server.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ExceptionHttpStatusNotAcceptable extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionHttpStatusNotAcceptable() {
		super();
	}

	public ExceptionHttpStatusNotAcceptable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionHttpStatusNotAcceptable(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionHttpStatusNotAcceptable(String message) {
		super(message);
	}

	public ExceptionHttpStatusNotAcceptable(Throwable cause) {
		super(cause);
	}

}
