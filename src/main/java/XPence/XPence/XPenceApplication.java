package XPence.XPence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class XPenceApplication {

    private static final Logger logger = LoggerFactory.getLogger(XPenceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XPenceApplication.class, args);
        logger.debug("This is a debug message");
        logger.info("Info message");
        logger.warn("Warn message");
    }

}
