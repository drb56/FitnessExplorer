package grapecity.fitnessexplorer.factories;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fitnessexplorer.services.repo.IFitnessRepository;
import com.fitnessexplorer.services.repo.MemoryFitnessRepository;
import com.google.android.gms.common.api.GoogleApiClient;

import grapecity.fitnessexplorer.services.GoogleFitRepository;
import grapecity.fitnessexplorer.ui.base.DashboardFragment;

/**
 * Created by David.Bickford on 5/26/2016.
 */
public class RepositoryFactory
{
    public static IFitnessRepository getNewRepository(Activity activity)
    {
        return new GoogleFitRepository(activity);
    }
}
