package com.cap.sprint.hbms.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotFoundException extends RuntimeException {
	final transient Logger logger = LogManager.getLogger(NotFoundException.class);
	public NotFoundException(String msg) {
		super(msg);

		logger.fatal(msg);
	}
}
