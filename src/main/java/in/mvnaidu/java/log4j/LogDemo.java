package in.mvnaidu.java.log4j;

import org.apache.logging.log4j.*;

public class LogDemo {

	private static Logger log = LogManager.getLogger(LogDemo.class.getName());

	public static void main(String[] args) {

		log.info("Info");
		log.debug("Debug");
		log.warn("Warn");
		log.error("Error");
		log.fatal("Fatal");
	}

}
