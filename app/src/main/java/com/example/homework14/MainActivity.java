package com.example.homework14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int request_code = 1;
    ArrayList<String> arrayName = new ArrayList<String>();
    ArrayList<String> arrayMail = new ArrayList<String>();
    String[] myarray={"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonMain(View view) {
        startActivityForResult(new Intent("com.example.homework14.SecondActivity"), request_code);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                final Bundle bundle = data.getBundleExtra("bundle");
                arrayName.add(bundle.getString("textName"));
                arrayMail.add(bundle.getString("textMail"));
                ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_mylist,arrayName);
                ListView listView = (ListView) findViewById(R.id.mylist);
                listView.setAdapter(adapter);
                listView.setClickable(true);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //setContentView(R.layout.activity_third);
                        Intent activity3 = new Intent("com.example.homework14.ThirdActivity");
                        //activity3.putExtra("position",i);
                        final Bundle bundleList = new Bundle();
                        bundleList.putString("textName",arrayName.get(i));
                        bundleList.putString("textMail",arrayMail.get(i));
                        activity3.putExtra("bundle",bundleList);
                        startActivity(activity3);
                    }
                });
            }
        }
    }
    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2),
                Toast.LENGTH_LONG).show();
    }

}
