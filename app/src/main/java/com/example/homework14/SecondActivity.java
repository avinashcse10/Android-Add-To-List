package com.example.homework14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    public void BackonClick(View view) {
        EditText textName = findViewById(R.id.editTextName);
        EditText textMail = findViewById(R.id.editTextEmail);
        Intent i = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("textName", textName.getText().toString());
        bundle.putString("textMail",textMail.getText().toString());
        i.putExtra("bundle",bundle);
        setResult(RESULT_OK,i);

        Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
        finish();
    }
}