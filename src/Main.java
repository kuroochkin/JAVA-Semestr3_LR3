import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Main
{
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {

        Handler file = new FileHandler("logger.txt");
        logger.addHandler(file);

        Properties prop = new Properties();
        Preloader preloader = new Preloader("settings.ini", prop);

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view, prop);

        controller.StartProgram("settings.ini");
        logger.info("Программа была запущена");

        controller.SwitchMenu();













    }
}