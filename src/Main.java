import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        Preloader preloader = new Preloader("settings.ini", prop);

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view, prop);

        controller.StartProgram("settings.ini");

        controller.SwitchMenu();













    }
}