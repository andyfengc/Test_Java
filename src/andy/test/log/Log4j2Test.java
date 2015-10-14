package andy.test.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
private final static Logger log = LogManager.getLogger(Log4j2Test.class);
public static void main(String[] args) {
	System.out.println("aaa");
	log.info("bbb");
}
}
