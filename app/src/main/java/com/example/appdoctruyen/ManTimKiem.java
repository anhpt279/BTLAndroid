package com.example.appdoctruyen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
//import android.widget.SearchView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import android.app.SearchManager;
//import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyen.adapter.adaptertruyen;
import com.example.appdoctruyen.data.DatabaseDocTruyen;
import com.example.appdoctruyen.model.Truyen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManTimKiem extends AppCompatActivity {

    ListView listView;
    EditText edt;

    ArrayList<Truyen> TruyenArrayList;

    ArrayList<Truyen> arrayList;

    adaptertruyen adaptertruyen;
    DatabaseDocTruyen databaseDocTruyen;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_tim_kiem);

        listView = findViewById(R.id.listviewtimkiem);

        edt = findViewById(R.id.timkiem);

        Intent intent = getIntent();
        i = intent.getIntExtra("phanq",0);
        initList();

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

        });

        //su kien click listiew
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ManTimKiem.this,ManNoiDungTruyen.class);
                String tent =   arrayList.get(position).getTenTruyen();
                String noidungt = arrayList.get(position).getNoiDung();
                intent.putExtra("phanq",i);
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);

                startActivity(intent);
            }
        });

    }

    //search
    private void filter(String text){

        arrayList.clear();

        ArrayList<Truyen> filteredList = new ArrayList<>();

        for(Truyen item : TruyenArrayList){
            if (item.getTenTruyen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);

                //Thêm dữ liệu để hiển thị ra item nội dung
               arrayList.add(item);
            }
        }
        adaptertruyen.filterList(filteredList);
    }


    public void initList(){
        TruyenArrayList = new ArrayList<>();

        arrayList = new ArrayList<>();
        databaseDocTruyen = new DatabaseDocTruyen(this);

        Cursor cursor1 = databaseDocTruyen.getData2();
        while (cursor1.moveToNext()){

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));


            arrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            adaptertruyen = new adaptertruyen(getApplicationContext(),TruyenArrayList);
            listView.setAdapter(adaptertruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();
    }

}