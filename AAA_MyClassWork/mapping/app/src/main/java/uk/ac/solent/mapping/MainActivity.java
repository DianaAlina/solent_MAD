package uk.ac.solent.mapping;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener ;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    MapView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the textView is replacing the map code in order to complete this weeks task
        //TextView tv = new TextView(this);
        //tv.setText("Mapnik");
        //setContentView(tv);
        setContentView(R.layout.activity_main);


        mv=findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(50.90,-1.39));
        mv.getController().setZoom(16);

        // southampton 50.9076, -1.4007
        // fenhurst 51.05, -0.72

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);

        //super.onCreate(savedInstanceState);


        Button b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(this);


    }

    public void onClick(View view) {


        TextView tv1 = (TextView) findViewById(R.id.tv1);
        EditText et1 = (EditText) findViewById(R.id.et1);



        TextView tv2 = (TextView) findViewById(R.id.tv2);
        EditText et2 = (EditText) findViewById(R.id.et2);
        if(!et1.getText().toString().equals("") && !et2.getText().toString().equals("") )
        {
            Double latitude = Double.parseDouble(et1.getText().toString());
            Double longitude = Double.parseDouble(et2.getText().toString());


            MapView mv = findViewById(R.id.map1);
            mv.getController().setCenter(new GeoPoint(latitude, longitude));
        }

    }

    //inflates the XML menu and makes the menu apppear in the activity
    public boolean onCreateOptionsMenu( Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.choosemap)
        {
            // react to the menu item being selected...
            //System.out.println("DEBUG ****** SELECTED CHOOSEMAP");
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }

        else if(item.getItemId() == R.id.chooselocation)
        {
            //System.out.println("DEBUG ****** SELECTED CHOOSELOCATION");
            Intent intent = new Intent (this,MapChooseLocation.class);
            startActivityForResult(intent,1);
            return true;
        }

        return false;
    }


    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.hikebikemap");
                if(hikebikemap==true)
                {
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
    }


}
