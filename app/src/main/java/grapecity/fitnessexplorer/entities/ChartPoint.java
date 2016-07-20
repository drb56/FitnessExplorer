package grapecity.fitnessexplorer.entities;

/**
 * Created by David.Bickford on 5/31/2016.
 */
import com.grapecity.xuni.core.ObservableList;

import java.util.Random;


public class ChartPoint
{
    protected String name;
    protected int sales;
    protected int expenses;
    protected int downloads;
    protected int calories;
    protected String day;

    public ChartPoint(String name, int sales, int expenses, int downloads)
    {
        super();
        this.name = name;
        this.sales = sales;
        this.expenses = expenses;
        this.downloads = downloads;
    }

    public ChartPoint(String name, int calories)
    {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories()
    {
        return calories;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSales()
    {
        return sales;
    }

    public void setSales(int sales)
    {
        this.sales = sales;
    }

    public int getExpenses()
    {
        return expenses;
    }

    public void setExpenses(int expenses)
    {
        this.expenses = expenses;
    }

    public int getDownloads()
    {
        return downloads;
    }

    public void setDownloads(int downloads)
    {
        this.downloads = downloads;
    }


    // a method to create a list of random objects of type ChartPoint
    public static ObservableList<ChartPoint> getList()
    {
        ObservableList<ChartPoint> list = new ObservableList<ChartPoint>();

        int n = 12; // number of series elements
        String[] month =
                {"Jan", "Feb", "March", "April", "May", "Jun","July", "Aug", "Sep", "Oct", "Nov", "Dec" };
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            list.add(new ChartPoint(month[i], random.nextInt(20000), random.nextInt(20000), random.nextInt(20000)));
        }
        return list;
    }

}
