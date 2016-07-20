package com.fitnessexplorer;

/**
 * Created by David.Bickford on 5/24/2016.
 */
import com.fitnessexplorer.entities.ActivityDataPoint;
import com.fitnessexplorer.entities.Calorie;
import com.fitnessexplorer.entities.CalorieActivity;
import com.fitnessexplorer.entities.CalorieDate;
import com.fitnessexplorer.entities.DayActivities;
import com.fitnessexplorer.services.repo.IFitnessRepository;
import com.fitnessexplorer.services.repo.MemoryFitnessRepository;
import com.fitnessexplorer.services.repo.Task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestMemoryFitnessRepository
{
    IFitnessRepository repo;
    @Before
    public void init()
    {
        repo = new MemoryFitnessRepository();
    }

    @Test
    public void testGetCaloriesBurnedToday()
    {
        Task<Calorie> onFinished = new Task<Calorie>()
        {
            @Override
            public void onFinished(Calorie data)
            {
                assertEquals(300, data.getCalorie());
            }
        };
        repo.getCaloriesBurnedToday(onFinished);

    }

//    @Test
//    public void testLoadActivityDataPoints()
//    {
////        ArrayList<ActivityDataPoint> currList = (ArrayList<ActivityDataPoint>)repo.loadActivityDataPoints();
//        int total = 0;
//        for(int i=0; i<currList.size(); i++)
//        {
//            total += currList.get(i).getCalories();
//        }
//        assertEquals(1050, total);
//    }

    @Test
    public void testGetCaloriesBurnedThisWeek()
    {
        ArrayList<CalorieDate> currList = (ArrayList<CalorieDate>)repo.getCaloriesBurnedThisWeek();
        int total = 0;
        for(int i=0; i<currList.size(); i++)
        {
            total += currList.get(i).getCalorie();
        }
        assertEquals(2350, total);
    }

    @Test
    public void testGetCalorieActivitiesToday()
    {
        ArrayList<CalorieActivity> currList = (ArrayList<CalorieActivity>)repo.getCalorieActivitiesToday();
        int total = 0;
        for(int i=0; i<currList.size(); i++)
        {
            total += currList.get(i).getCalorie();
        }
        assertEquals(950, total);
    }

    @Test
    public void testGetMonthDayActivities()
    {
        ArrayList<DayActivities> currList = (ArrayList<DayActivities>)repo.getMonthDayActivities();
        int total = 0;
        for(int i=0; i<currList.size(); i++)
        {
            ArrayList<CalorieActivity> curr = currList.get(i).getActivities();
            for(int j=0; j<curr.size(); j++)
            {
                total += curr.get(j).getCalorie();
            }

        }
        assertEquals(2350, total);
    }

}
