package projectEvri.uiAutomation.utilities;

import org.apache.log4j.Logger;

/**
 * This abstract class serves as a utility for logging messages using Log4j.
 */
public abstract class Log {

    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());

    public abstract void startTestCase();

    public abstract void endTestCase();

    /**
     * Logs an informational message.*/
    public static void info(String message) {
        Log.info(message);
    }

    /**
     * Logs a warning message. */
    public static void warn(String message) {
        Log.warn(message);
    }

    /**
     * Logs an error message.*/
    public static void error(String message) {
        Log.error(message);
    }

    /**
     * Logs a fatal error message. */
    public static void fatal(String message) {
        Log.fatal(message);
    }

    /**
     * Logs a debug message. */
    public static void debug(String message) {
        Log.debug(message);
    }
}