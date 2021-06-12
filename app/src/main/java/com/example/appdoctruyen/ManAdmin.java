package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appdoctruyen.adapter.adaptertruyen;
import com.example.appdoctruyen.data.DatabaseDocTruyen;
import com.example.appdoctruyen.model.Truyen;

import java.util.ArrayList;

public class ManAdmin extends AppCompatActivity {

    ListView listView;
    Button buttonThem;

    ArrayList<Truyen> TruyenArrayList;
    adaptertruyen adaptertruyen;
    DatabaseDocTruyen databaseDocTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);

        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.buttonAddTruyen);

        initList();


        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                int id = intent.getIntExtra("Id",0);
                Intent intent1 = new Intent(ManAdmin.this, ManDangBai.class);
                intent.putExtra("Id",id);
                startActivity(intent1);
            }
        });
    }


    public void initList(){
        TruyenArrayList = new ArrayList<>();
        databaseDocTruyen = new DatabaseDocTruyen(this);

        Cursor cursor1 = databaseDocTruyen.getData2();

        while (cursor1.moveToNext()){

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adaptertruyen = new adaptertruyen(getApplicationContext(),TruyenArrayList);
            listView.setAdapter(adaptertruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();
    }
}