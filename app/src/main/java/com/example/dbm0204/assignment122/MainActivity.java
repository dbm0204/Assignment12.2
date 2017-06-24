package com.example.dbm0204.assignment122;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nName;
    EditText nPhone;
    EditText nAge;
    Button save,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPrefManager.Init(this);
        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(this);
        show=(Button)findViewById(R.id.show);
        show.setOnClickListener(this);

    }

    public void onClickStore(View v){
        nName=(EditText)findViewById(R.id.Name);
        nPhone=(EditText)findViewById(R.id.Phone);
        nAge=(EditText)findViewById(R.id.Age);
        //Convert EditText tp String
        String name_str =nName.getText().toString();
        String phone_str=nPhone.getText().toString();
        String age_str=nAge.getText().toString();
        if(0!=name_str.length())
            SharedPrefManager.setnName(name_str);
        if(0!=phone_str.length())
            SharedPrefManager.setnPhone(phone_str);
        if (0!=age_str.length())
            SharedPrefManager.setnAge(Integer.parseInt(age_str));
        //now save all to shared Pred , all updated values are available in the shared Preferance
        SharedPrefManager.StoreToPrefs();

        //reset all fields to blank before load and update from sharedpref
        EditText tv= null;
        tv=(EditText)findViewById(R.id.Name);
        tv.setText("");
        tv=(EditText)findViewById(R.id.Phone);
        tv.setText("");
        tv=(EditText)findViewById(R.id.Age);
        tv.setText("");
        Toast.makeText(this,"Data Sucessfully Stored to SharedPreferance",Toast.LENGTH_LONG).show();
    }
    public void onClickLoad(View v){
        //get all the values from the SharedPreferance file;
        SharedPrefManager.LoadFromPref();
        String strTextName, strTextPhone;
        int strTextAge;
        strTextName = SharedPrefManager.getnName();
        strTextPhone=SharedPrefManager.getnPhone();
        strTextAge=SharedPrefManager.getnAge();
        //Now we show these persistant values on our Activity(GUI)
        EditText tv2= null;
        tv2=(EditText)findViewById(R.id.Name);
        tv2.setText(strTextName);
        tv2=(EditText)findViewById(R.id.Phone);
        tv2.setText(strTextPhone);
        tv2=(EditText)findViewById(R.id.Age);
        tv2.setText(String.valueOf(strTextAge));

        Toast.makeText(this, "Data Sucessfully Loaded form SharedPreferance",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.save)
            onClickLoad(view);
        else
            if (view.getId()==R.id.show)
                onClickLoad(view);
    }
}
