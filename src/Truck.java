public class Truck extends Transport
{
    private int height;
    private int weight;

    public int getHeight()
    {
        return height;
    }

    public int getWeight()
    {
        return weight;
    }

    public Truck(String brand,String ID, Radio radio, int height,int weight)
    {
        super(brand,ID, radio);
        this.height = height;
        this.weight = weight;
    }

    public void Move()
    {
        System.out.println(this.getBrand() + " проехала через пропускной пункт");
    }
}
