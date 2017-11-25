package com.example.zaldua.dbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);

        final DatabaseHelper db = new DatabaseHelper(this);

        db.addContact(new Contact("name1", "123456789"));
        db.addContact(new Contact("name2", "987654321"));

        List<Contact> contacts = db.getAllContacts();

        for(Contact c:contacts){
            String log = "ID: "+ c.getId() + ", NAME: "+ c.getName() + ", NUMBER: "+ c.getPhone_number()+"\n";
            text = text+log;
        }

        textView.setText(text);


        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.addContact(new Contact("name3", "6666"));
            }
        });
    }
}
