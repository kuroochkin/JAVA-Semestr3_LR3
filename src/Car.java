public class Car extends Transport
{
    private int speed;

    public int getSpeed()
    {
        return speed;
    }

    public Car(String brand,String ID,Radio radio, int speed)
    {
        super(brand,ID,radio);
        this.speed = speed;
    }

    @Override
    public void Move()
    {
        System.out.println(this.getBrand() + " проехала через пропускной пункт");
    }

    public String toString()
    {
        return "Марка машины: " + this.getBrand() + " Номер: " + this.getID() + " Текущее радио: " + this.getRadio().getStation() + " Скорость: " + this.getSpeed();
    }
}
