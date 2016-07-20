package grapecity.fitnessexplorer.entities;

/**
 * Created by David.Bickford on 5/31/2016.
 */
public class BindObject
{
    private String name;
    private int value;

    public BindObject(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public int getValue()
    {
        return value;
    }
}
