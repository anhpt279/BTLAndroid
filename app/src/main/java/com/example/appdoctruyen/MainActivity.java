package com.example.appdoctruyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import android.widget.ViewFlipper;

import com.example.appdoctruyen.adapter.adapterchuyenmuc;
import com.example.appdoctruyen.adapter.adapterthongtin;
import com.example.appdoctruyen.adapter.adaptertruyen;
import com.example.appdoctruyen.data.DatabaseDocTruyen;
import com.example.appdoctruyen.model.TaiKhoan;
import com.example.appdoctruyen.model.Truyen;
import com.example.appdoctruyen.model.chuyenmuc;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;

    NavigationView navigationView;
    ListView listView,listViewNew,listviewThongtin;
    DrawerLayout drawerLayout;

    ArrayList<chuyenmuc> chuyenmucArrayList;
    ArrayList<TaiKhoan> taiKhoanArrayList;

    ArrayList<Truyen> TruyenArrayList;
    adaptertruyen adaptertruyen;

    adapterthongtin adapterthongtin;

    adapterchuyenmuc adapterchuyenmuc;

    DatabaseDocTruyen databaseDocTruyen;
    String email;
    String tentaikhoan;
    int idd, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseDocTruyen = new DatabaseDocTruyen(this);
//        databaseDocTruyen.QueryData("DELETE FROM truyen");
//        databaseDocTruyen.QueryData(databaseDocTruyen.SQLQuery4);
//        databaseDocTruyen.QueryData(databaseDocTruyen.SQLQuery5);
//        databaseDocTruyen.QueryData(databaseDocTruyen.SQLQuery6);
//        databaseDocTruyen.QueryData(databaseDocTruyen.SQLQuery7);
//        databaseDocTruyen.QueryData(databaseDocTruyen.SQLQuery8);

        Intent intentpq = getIntent();
        i = intentpq.getIntExtra("phanq",0);
        idd = intentpq.getIntExtra("idd",0);
        email = intentpq.getStringExtra("email");
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");


        AnhXa();

        ActionBar();
        ActionViewFlipper();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                        if(i == 2) {
                            Intent intent = new Intent(MainActivity.this, ManAdmin.class);
                            intent.putExtra("Id",idd);
                            startActivity(intent);
                    }
                        else {
                            Toast.makeText(MainActivity.this,"Bạn không có quyền ",Toast.LENGTH_SHORT).show();
                            Log.e("Đăng bài : ","Bạn không có quyền ");
                        }
                    }
                else if(position == 1){
                    Intent intent = new Intent(MainActivity.this,ManThongTinApp.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    finish();
                }
            }
        });

        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ManNoiDungTruyen.class);
                String tent =   TruyenArrayList.get(position).getTenTruyen();
                String noidungt = TruyenArrayList.get(position).getNoiDung();
                intent.putExtra("phanq",i);
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);
                startActivity(intent);
            }
        });

    }



    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();

        mangquangcao.add("https://s199.imacdn.com/vg/2021/06/01/c6b9dc241bc54f40_50099ad47e4eb91c_3918916225631001118684.jpg");
        mangquangcao.add("https://s199.imacdn.com/ta/2021/06/01/d47531d3253670e4_3cd0cf82e86574e7_73933162256111669674.jpg");
        mangquangcao.add("https://s199.imacdn.com/vg/2021/04/19/f2aecf8b22707d99_178cda5c30fdfed2_2907916188102274118684.jpg");
        mangquangcao.add("https://s199.imacdn.com/vg/2021/05/30/e4012187629fb41e_41f858b7c18276f2_36084162238486693.jpg");
        mangquangcao.add("https://s199.imacdn.com/vg/2021/06/01/b951249feb2d9331_d7b1383897e234d0_22882162248187539674.jpg");
        mangquangcao.add("https://s199.imacdn.com/vg/2021/06/01/c6b9dc241bc54f40_50099ad47e4eb91c_3918916225631001118684.jpg");

        for(int i =0; i <mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void AnhXa(){
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper);
        listViewNew = findViewById(R.id.listviewNew);
        navigationView = findViewById(R.id.navigationview);
        listView = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        listviewThongtin = findViewById(R.id.listviewThongTin);



        //Thong tin
        taiKhoanArrayList = new ArrayList<>();
        taiKhoanArrayList.add(new TaiKhoan(tentaikhoan,email));
        adapterthongtin = new adapterthongtin(this,R.layout.nav_thong_tin,taiKhoanArrayList);
        listviewThongtin.setAdapter(adapterthongtin);

        //chuyên mục
        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài",R.drawable.ic_post));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin",R.drawable.ic_face));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất",R.drawable.ic_login));

        adapterchuyenmuc = new adapterchuyenmuc(this,R.layout.chuyen_muc,chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);



        //New Truyện
        TruyenArrayList = new ArrayList<>();

        Cursor cursor1 = databaseDocTruyen.getData1();
        while (cursor1.moveToNext()){

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

            adaptertruyen = new adaptertruyen(getApplicationContext(),TruyenArrayList);
            listViewNew.setAdapter(adaptertruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();

    }

    //Nạp một menu tìm kiếm vào actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu1:
                Intent intent = new Intent(this,ManTimKiem.class);
                intent.putExtra("phanq",i);
                startActivity(intent);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}