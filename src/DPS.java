public class DPS
{
    private int ID;
    private String city;

    public DPS(int ID, String city)
    {
        this.ID = ID;
        this.city = city;
    }

    public void Pass(Car car)
    {
        if(car.getSpeed() <= 50)
            car.Move();
        else
        {
            System.out.println(car.getBrand() + " не прошла проверку. Ее скорость превышает допустимую на " + (car.getSpeed()-50));
        }
    }

    public void Pass(Truck truck)
    {
        if(truck.getHeight() <= 100 && truck.getWeight() <= 100)
            truck.Move();

        else if(truck.getHeight() > 100 && truck.getWeight() > 100)
        {
            System.out.println(truck.getBrand() + " не прошла проверку. Ее высота превышает допустимую на " + (truck.getHeight()-100) + " и вес на " + (truck.getWeight()-100));
        }

        else if(truck.getHeight() <= 100 && truck.getWeight() > 100)
        {
            System.out.println(truck.getBrand() + " не прошла проверку. Ее вес превышает допустимый на " + (truck.getWeight()-100));
        }

        else if(truck.getHeight() > 100 && truck.getWeight() <= 100)
        {
            System.out.println(truck.getBrand() + " не прошла проверку. Ее высота превышает допустимую на " + (truck.getHeight()-100));
        }

    }
}
