public class Radio
{
    private String station;
    private boolean play;

    public String getStation()
    {
        return station;
    }
    public boolean getPlay()
    {
        return play;
    }

    public void setPlay(boolean play)
    {
        this.play = play;
    }

    public Radio(String station, boolean play)
    {
        this.station = station;
        this.play = play;
    }
}
