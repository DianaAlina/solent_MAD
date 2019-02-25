package uk.ac.solent.mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapChooseLocation extends AppCompatActivity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);
        Button setlocation = (Button)findViewById(R.id.btn1);
        setlocation.setOnClickListener(this);

    }

    //add here as bundle like for hikeebike map  to read the input from location xml file
    public void onClick(View v)
    {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        boolean setlocation=false;
        if (v.getId()==R.id.btn1)
        {
            setlocation=true;
        }
        bundle.putBoolean("com.example.setlocation",setlocation);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
