package grapecity.fitnessexplorer;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.grapecity.xuni.core.LicenseManager;

/**
 * Created by David.Bickford on 5/31/2016.
 */
public class MyApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LicenseManager.KEY = License.KEY;
    }
}
