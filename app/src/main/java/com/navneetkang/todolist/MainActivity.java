package com.navneetkang.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> al=new ArrayList<>();

    ListView lv1;
    EditText entry;
    Button enterData,editListItem,deleteListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = findViewById(R.id.lv1);
        entry=findViewById(R.id.entry);
        enterData=findViewById(R.id.enterData);
        editListItem=findViewById(R.id.editListItem);
        deleteListItem=findViewById(R.id.deleteListItem);






        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),i,Toast.LENGTH_LONG).show();
                Log.d("mymessage",i+"");
            }
            
        });



        enterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item=entry.getText().toString();
                if(item.length()<1)
                {
                    Toast.makeText(getApplicationContext(),R.string.emptyEntry,Toast.LENGTH_LONG).show();

                }
                else
                {
                    al.add(item);
                    adapter();

                }

            }
        });









    }
    public void adapter()
    {
        ArrayAdapter<String> myad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lv1.setAdapter(myad);
        entry.setText("");


    }
}