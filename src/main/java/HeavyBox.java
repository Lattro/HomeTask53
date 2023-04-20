import java.util.ArrayList;

public class HeavyBox
{
    private int weight;
    public HeavyBox(int weight)
    {
        this.weight = weight;
    }
    public String toString()
    {return Integer.toString(weight);}

    public static ArrayList<HeavyBox> checkWeight(ArrayList<HeavyBox> list)
    {
        ArrayList<HeavyBox> listMore300 = new ArrayList<>();
        for (HeavyBox i: list)
        {
            if(i.weight>300)
            {
                listMore300.add(i);
            }
        }
        return listMore300;
    }
}
