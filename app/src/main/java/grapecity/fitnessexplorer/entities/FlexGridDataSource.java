package grapecity.fitnessexplorer.entities;

/**
 * Created by David.Bickford on 6/7/2016.
 */
import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;
import com.grapecity.xuni.core.*;

public class FlexGridDataSource
{
    protected String activity;
    protected String description;
    protected int calories;
    protected String date;
    protected String start;
    protected String end;

    public FlexGridDataSource(String activity, String description, int calories, String date, String start, String end)
    {
        super();
        this.activity = activity;
        this.description = description;
        this.calories = calories;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public void setEnd(String end)
    {
        this.end = end;
    }

    public String getDate()
    {
        return date;
    }

    public String getStart()
    {
        return start;
    }

    public String getEnd()
    {
        return end;
    }

    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public String getActivity()
    {
        return activity;
    }

    public String getDescription()
    {
        return description;
    }

    public int getCalories()
    {
        return calories;
    }

    public String[] toStringArray()
    {
        String[] toArray = {activity, description, Integer.toString(calories), date, start, end};
        return toArray;
    }

}
