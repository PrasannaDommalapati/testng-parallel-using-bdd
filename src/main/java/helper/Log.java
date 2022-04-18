package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    //Initialize Log4j instance
    private static final Logger Logger = LogManager.getLogger(Log.class);

    //Info Level Logs
    public static void info(String message) {
        Logger.info(message);
    }

    //Warn Level Logs
    public static void warn(String message) {
        Logger.warn(message);
    }

    //Error Level Logs
    public static void error(String message) {
        Logger.error(message);
    }

    //Fatal Level Logs
    public static void fatal(String message) {
        Logger.fatal(message);
    }

    //Debug Level Logs
    public static void debug(String message) {
        Logger.debug(message);
    }
}
