import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ApplicationLogger {
    private final Logger logger = Logger.getLogger(ApplicationLogger.class
            .getName());
    private FileHandler fh = null;

    public ApplicationLogger() {
        //just to make our log file nicer :)
        SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");
        try {
            fh = new FileHandler("src/application.log", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    public void doInfo (String t){
        logger.info("info: " + t + "\n");
    }

    public void doLog(Exception e,  String [] data) {
        if(data == null)
            logger.severe("error message: " + e.getMessage() + "\n");
        else
            logger.severe("error message: " + e.getMessage() + "\n" +
                "Line with the problem: \n" + String.join(", ", data) + "\n");
    }
}
