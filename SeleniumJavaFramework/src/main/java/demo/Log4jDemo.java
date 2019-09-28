package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		
		System.out.println("\n  Hello World   \n");
		
		logger.info("This is a information message");
		logger.error("This is a error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal message");
				
	}
}
