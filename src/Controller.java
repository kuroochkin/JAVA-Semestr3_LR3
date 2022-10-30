import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class Controller {
    public Model model;
    public View view;
    public Properties prop;



    public Controller(Model model, View view, Properties prop) {
        this.model = model;
        this.view = view;
        this.prop = prop;
    }

    public static String inputStr() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int inputInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int CheckInt()  {
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.next());
                if(i <= 0)
                {
                    System.out.println("Введите целое положительное число: ");
                    Main.logger.warning("Был некорректный ввод.");
                }
                else {break;}
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число: ");
                Main.logger.warning("Был некорректный ввод.");
            }
        }
        return i;
    }

    public Car AddObject(Model model) throws Exception {
        this.view.view("Введите марку машины: ");
        String brand = inputStr();
        this.view.view("Введите номер машины:");
        String number = inputStr();
        this.view.view("Введите название радиостанции: ");
        String station = inputStr();
        this.view.view("Введите скорость машины: ");
        int speed = CheckInt();

        Car car = new Car(brand, number, new Radio(station, true), speed);
        model.cars.add(car);

        return car;
    }

    public void Remove(Model model)
    {
        this.view.view("Введите номер автомобиля, который хотите удалить: ");
        String number = inputStr();
        this.model.cars.removeIf(car -> number == car.getID());
    }

    public void Reading()
    {
        File file = new File("java.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveToFile(String FileName, boolean Update) throws
            java.io.IOException {
        boolean Result = false;
        FileWriter dataOut = null;
        try {
            dataOut = new FileWriter(FileName, Update);
            for (Car car : this.model.cars)
            {
                dataOut.append(car.toString()).append("\n");
            }
            Result = true;
        } catch (IOException exc) {
            System.err.println(exc.getMessage());
        } finally {
            assert dataOut != null;
            dataOut.close();
        }
    }

    public void StartProgram(String file) throws IOException {
        FileInputStream fis;
        this.prop = new Properties();

        try {
            fis = new FileInputStream("settings.ini");
            prop.load(fis);

            String login = prop.getProperty("login");

            this.view.view("Добро пожаловать, " + login + "!");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public void SwitchMenu() throws Exception
    {

        int key;
        do {
            this.view.PrintMenu();
            this.view.view("Введите номер меню: ");
            key = CheckInt();
            switch (key) {
                case 1 ->
                {
                    this.AddObject(this.model);
                    Main.logger.info("Автомобиль был добавлен в программу.");
                }
                case 2 -> {
                    if (this.model.cars.size() == 0)
                    {
                        this.view.view("В программе нет ни одного автомобиля!");
                        Main.logger.info("Была неудачная попытка удалить автомобиль из программы.");
                        break;
                    }
                    this.Remove(model);
                    Main.logger.info("Автомобиль был удален из программы");
                }
                case 3 -> {
                    if (this.model.cars.size() == 0) {
                        this.view.view("В программе нет ни одного автомобиля!");
                        Main.logger.info("Была неудачная попытка перезаписать файл.");
                        break;
                    }
                    this.SaveToFile("java.txt", false);
                    Main.logger.info("Файл был перезаписан. Объекты добавлены в файл.");
                }
                case 4 -> {
                    if (this.model.cars.size() == 0) {
                        this.view.view("В программе нет ни одного автомобиля!");
                        Main.logger.info("Была неудачная попытка дозаписать файл.");
                        break;
                    }
                    this.SaveToFile("java.txt", true);
                    Main.logger.info("Файл был дозаписан. Объекты добавлены в файл.");
                }
                case 5 ->
                {
                    this.Reading();
                    Main.logger.info("Произошло чтение из файла.");
                }
                case 6 ->
                {
                    this.view.view("Вы завершили выполнение программы.");
                    Main.logger.info("Программа была завершена.");
                }
                default -> System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != 6);
    }


}


