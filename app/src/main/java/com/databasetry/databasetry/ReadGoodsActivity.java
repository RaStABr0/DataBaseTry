package com.databasetry.databasetry;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.System.in;

public class ReadGoodsActivity extends AppCompatActivity {

    Button writeButton;
    EditText goodsList;
    FirebaseDatabase database;
    DatabaseReference reference;
    ListView listView;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_goods);
        //goodsList = findViewById(R.id.goodsEdit);
        writeButton = findViewById(R.id.goToWrirtingButton);
        listView = findViewById(R.id.listView);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        mAuth = FirebaseAuth.getInstance();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //goodsList.setText(dataSnapshot.getValue(String.class));
                String string = dataSnapshot.getValue().toString();

                String[] databaseList = createGoodsList(string);
                fillView(databaseList);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ReadGoodsActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });




        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReadGoodsActivity.this, GoodsActivity.class));
            }
        });
    }

    private String[] createGoodsList (String str){
        str = str.substring(1, str.length() - 1);

        String[] databaseList;

        databaseList = str.split(",");

        return databaseList;
    }

    private void fillView (String[] list) {
        for(int i = 0; i < list.length; i++){
            list[i] = list[i].replaceAll("=", ", ");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_multiple_choice, list);
            // choiceList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            listView.setAdapter(adapter);
//            for (int j = 0; j < tmp.length; j++){
//
//
//            }
        }
    }



}
