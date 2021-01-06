package com.example.temperature_measurement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView username;
    String txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


//assign id in edittext and button to varibles
    username = findViewById(R.id.txt2);
    btn1 = findViewById(R.id.bttn1);
}

//button one clickable method
    public void btn1(View view) {
        //prepare our text
        txt1 = username.getText().toString().trim();

        //check txt1  are not empty
        if (isEmpty(txt1)) {
            //appear error when user doesnt fill username
            username.setError("This field can not be blank");
            Toast.makeText(MainActivity.this, " Enter your username :", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this," Hello :"+ txt1, Toast.LENGTH_SHORT).show();
            // if the name is not empty go to home activity
                Intent temp2 =  new Intent(MainActivity.this,Home_activity.class);
                startActivity(temp2);

        }
    }



//function to detect if the string is empty or not
    private boolean isEmpty(String etText) {
        return etText.length() == 0;
    }
}
