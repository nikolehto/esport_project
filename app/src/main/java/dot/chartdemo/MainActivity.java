package dot.chartdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

// Add allprojects { repositories { maven { url "https://jitpack.io" }}} to project gradle
// Add implementation 'com.github.PhilJay:MPAndroidChart:v3.0.3' to app build gradle
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    LineChart chart;

    ArrayList<GameData> dataArray = new ArrayList<>();
    // Import  com.github.mikephil.charting.data.Entry;
    List<Entry> entries = new ArrayList<>();

    // just a example class for gamedata
    public class GameData
    {
        public int session;
        public float mean_reaction_time;
        public float min_reaction_time;
        public float max_reaction_time;
        public float variance;

        GameData(int session
                , float mean_reaction_time
                , float min_reaction_time
                , float max_reaction_time
                , float variance)
        {
            this.session = session;
            this.mean_reaction_time = mean_reaction_time;
            this.min_reaction_time = min_reaction_time;
            this.max_reaction_time = max_reaction_time;
            this.variance = variance;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart = (LineChart) findViewById(R.id.chart);
        generateData(20);
        fillEntriesWithMean();
        LineDataSet dataSet = new LineDataSet(entries, "Mean Reaction Time");
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLACK);
        LineData lineData = new LineData(dataSet);
        chart.setBackgroundColor(Color.WHITE);
        chart.setData(lineData);
        chart.invalidate(); // refresh
        //LineChart chart = new LineChart(this);
        //rl.add(chart);
    }

    protected  void fillEntriesWithMean()
    {
        for (GameData data : dataArray) {

            // turn your data into Entry objects
            //entries.add(new Entry()
            Log.d("FillEntries", "mean: " + data.mean_reaction_time);
            entries.add(new Entry( data.session, data.mean_reaction_time));
        }

    }

    protected void generateData( int range)
    {
        //int session;
        for(int i = 0; i<range; i++)
        {
            ArrayList<Float> randData = new ArrayList<>();
            for(int j = 0; j< 10; j++)
            {
                float value = random.nextFloat() * 5;
                randData.add(value);
                //Log.d("GENERATEDATA", "value: " + value);
            }

            float mean = mean(randData);
            float min = min(randData);
            float max = max(randData);
            float var = standardDeviation(randData);
            GameData gameData = new GameData(i, mean, min, max, var);
            dataArray.add(gameData);
        }
    }

    private static float mean(ArrayList<Float> list)
    {
        float sum = 0;

        for ( int i= 0;i < list.size(); i++)
        {
            float value = list.get(i);
            sum+= value;
        }
        return sum/(float) list.size();
    }

    public static float min(ArrayList<Float> list) {
        return list.get(list.indexOf (Collections.min(list))); }

    public static float max(ArrayList<Float> list) {
        return list.get(list.indexOf (Collections.max(list))); }



    public static float standardDeviation (ArrayList<Float> list)
    {
        double mean = mean(list);
        double sum = 0;

        for (int i = 0; i < list.size(); i++) {
            float val = list.get(i);
            double distance = Math.pow(val - mean, 2);
            sum += distance;
        }
        double meanOfDiffs = sum / (double) (list.size());

        return (float) Math.sqrt(meanOfDiffs);
    }
}
