package com.cap.sprint.hbms.exceptions;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class AlreadyExistsException extends RuntimeException {
	final transient Logger logger = LogManager.getLogger(AlreadyExistsException.class);
	public AlreadyExistsException(String msg) {
		
		super(msg);

		logger.fatal(msg);
	}
}