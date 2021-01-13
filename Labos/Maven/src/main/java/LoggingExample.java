import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

public class LoggingExample {
    private static Log log = LogFactory.getLog(LoggingExample.class);

    public static void main(String[] args) {
        log.info("Info dans la méthode main");
        log.error("Erreur dans la méthode main");
    }
}

