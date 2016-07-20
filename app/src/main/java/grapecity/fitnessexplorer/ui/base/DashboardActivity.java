package grapecity.fitnessexplorer.ui.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.fitnessexplorer.services.repo.IFitnessRepository;
import com.fitnessexplorer.ui.base.IController;
import com.fitnessexplorer.ui.dashboard.DashboardModelImpl;
import com.fitnessexplorer.ui.dashboard.IDashboardController;
import com.fitnessexplorer.ui.dashboard.IDashboardModel;
import com.fitnessexplorer.ui.factories.ModelFactory;

import grapecity.fitnessexplorer.factories.RepositoryFactory;
import grapecity.fitnessexplorer.R;
import grapecity.fitnessexplorer.services.GoogleFitRepository;

/**
 * Created by David.Bickford on 5/26/2016.
 */
public class DashboardActivity extends AppCompatActivity implements IDashboardController
{
    private DashboardModelImpl model;
    private IFitnessRepository repo;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        DashboardFragment articleFragment = new DashboardFragment();

        transaction.replace(R.id.fragment_container, articleFragment);
        transaction.commit();
    }

    @Override
    public void navigateToRawDataView()
    {
        Intent i = new Intent(this, RawDataActivity.class);
        startActivity(i);
    }
}
