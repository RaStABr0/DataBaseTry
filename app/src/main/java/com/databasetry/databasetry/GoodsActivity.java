package com.databasetry.databasetry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GoodsActivity extends AppCompatActivity {

    Button logOutButton;
    Button addToBase;
    Button readButton;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    EditText productName;
    EditText productPrice;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods);
        addToBase = findViewById(R.id.addToBaseButton);
        database = FirebaseDatabase.getInstance();
        productName = findViewById(R.id.productNameEdit);
        productPrice = findViewById(R.id.productPriceEdit);
        mAuth = FirebaseAuth.getInstance();
        readButton = findViewById(R.id.goToReadingButton);

        logOutButton = findViewById(R.id.logOutButton);
        //logOutButton = findViewById(R.id.floatingActionButton);

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GoodsActivity.this, ReadGoodsActivity.class));
            }
        });


        addToBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = database.getReference(productName.getText().toString());
                reference.setValue(productPrice.getText().toString());
            }
        });



        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseUser currentUser = mAuth.getCurrentUser();
                //currentUser.
                mAuth.signOut();
                startActivity(new Intent(GoodsActivity.this, LoginActivity.class));
//                reference = database.getReference(productName.getText().toString());
//                reference.setValue(Float.valueOf(productPrice.getText().toString()));
            }
        });

    }
}
