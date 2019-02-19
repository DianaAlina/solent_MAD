package uk.ac.solent.lists;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity
{
    String[] names = new String[] { "The Crown", "The Cowherds", "The Two Brothers","Piccolo Mondo" };
    String[] details = new String[] { "pub, 2.5 miles north", "pub, 1.5 miles north",
            "pub, 3.5 miles northeast" , "Italian restaurant, 0.5 miles west" };
    //String[] data = new String[] { "Firefox", "Chrome", "Internet Explorer" };
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, data);
        MyAdapter adapter = new MyAdapter();
        setListAdapter(adapter);

    }

    public class MyAdapter extends ArrayAdapter<String>
    {
        public MyAdapter()
        {
            // We have to use ExampleListActivity.this to refer to the outer class (the activity)
            super(MainActivity.this, android.R.layout.simple_list_item_1, names);
        }

        public View getView(int index, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.poientry, parent, false);
            TextView title = (TextView)view.findViewById(R.id.poi_name), detail =
                    (TextView)view.findViewById(R.id.poi_desc);
            title.setText(names[index]);
            detail.setText(details[index]);
            return view;
        }
    }

    public View getView(int index, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.poientry, parent, false);
        }
        TextView title = (TextView)view.findViewById(R.id.poi_name), detail =
                (TextView)view.findViewById(R.id.poi_desc);
        title.setText(names[index]);
        detail.setText(details[index]);
        return view;
    }


    /*public void onListItemClick(ListView lv, View view, int index, long id)
    {
        // handle list item selection
        Toast.makeText(this, "You selected: " + data[index], Toast.LENGTH_LONG).show();

    }*/
}