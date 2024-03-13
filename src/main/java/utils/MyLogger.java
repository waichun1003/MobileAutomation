package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyLogger {
    private Logger logger;
    private List<String> logMessages = new ArrayList<>();

    public MyLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        logger.info(message);
        logMessages.add("INFO: " + message);
    }

    public List<String> getLogMessages() {
        return logMessages;
    }
}
