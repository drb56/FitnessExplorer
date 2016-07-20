package grapecity.fitnessexplorer.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fitnessexplorer.services.repo.IFitnessRepository;
import com.fitnessexplorer.ui.dashboard.DashboardModelImpl;
import com.fitnessexplorer.ui.dashboard.IDashboardController;
import com.fitnessexplorer.ui.dashboard.IDashboardModel;
import com.fitnessexplorer.ui.factories.ModelFactory;
import com.fitnessexplorer.ui.rawdata.IRawDataController;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;

import grapecity.fitnessexplorer.R;
import grapecity.fitnessexplorer.factories.RepositoryFactory;

/**
 * Created by David.Bickford on 6/6/2016.
 */
public class RawDataActivity extends AppCompatActivity implements IRawDataController
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        RawDataFragment articleFragment = new RawDataFragment();
        transaction.replace(R.id.fragment_container, articleFragment);
        transaction.commit();
    }
}
