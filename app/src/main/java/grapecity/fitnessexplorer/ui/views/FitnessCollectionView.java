package grapecity.fitnessexplorer.ui.views;

import android.app.Activity;
import android.util.Log;

import com.fitnessexplorer.entities.ActivityDataPoint;
import com.fitnessexplorer.services.repo.IFitnessRepository;
import com.fitnessexplorer.services.repo.Task;
import com.grapecity.xuni.core.ObservableList;
import com.grapecity.xuni.flexgrid.FlexGrid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by David.Bickford on 6/8/2016.
 */
public class FitnessCollectionView extends com.grapecity.xuni.core.CursorCollectionView<ActivityDataPoint>
{
    private final IFitnessRepository fitnessRepository;
    private Calendar startDate;
    private Calendar endDate;
    private final SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
    FlexGrid mGrid;

    public FitnessCollectionView(IFitnessRepository fitnessRepository, FlexGrid mGrid)
    {
        super(new ObservableList<ActivityDataPoint>());
        this.fitnessRepository = fitnessRepository;
        this.startDate = Calendar.getInstance();
        this.endDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -7);
        this.mGrid = mGrid;

        fitnessRepository.loadActivityDataPointsAsync(new Task<List<ActivityDataPoint>>()
        {
            @Override
            public void onFinished(List<ActivityDataPoint> data)
            {
                setSourceCollection(data);
            }
        }, startDate, endDate);
    }

    @Override
    public List<ActivityDataPoint> getPageAsync(Integer integer)
    {
        startDate.add(Calendar.DAY_OF_YEAR, -7);
        endDate.add(Calendar.DAY_OF_YEAR, -7);
        final List<ActivityDataPoint> returnList = new ArrayList<ActivityDataPoint>();
        returnList.addAll(fitnessRepository.loadActivityDataPoints(startDate, endDate));
        for(int i=0; i<returnList.size(); i++)
        {
            ActivityDataPoint curr = returnList.get(i);
        }

        Collections.sort(returnList, new Comparator<ActivityDataPoint>() {
            @Override
            public int compare(ActivityDataPoint activity1, ActivityDataPoint activity2)
            {
                return activity1.compareTo(activity2);
            }
        });

        return returnList;
    }

    @Override
    public void loadMoreItemsAsync(Integer count)
    {
        startDate.add(Calendar.DAY_OF_YEAR, -7);
        endDate.add(Calendar.DAY_OF_YEAR, -7);
        fitnessRepository.loadActivityDataPointsAsync(new Task<List<ActivityDataPoint>>()
        {
            @Override
            public void onFinished(List<ActivityDataPoint> data)
            {
                beginUpdate();
                addAll(data);
                endUpdate();
            }
        }, startDate, endDate);
    }
}
