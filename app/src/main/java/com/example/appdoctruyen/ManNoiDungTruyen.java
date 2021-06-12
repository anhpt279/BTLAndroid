package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.appdoctruyen.data.DatabaseDocTruyen;

public class ManNoiDungTruyen extends AppCompatActivity {

    TextView txtTenTruyen,txtNoidung;
    Button btnXoa;
    DatabaseDocTruyen db;
    String tenTruyen, noidung;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_noi_dung_truyen);

        txtNoidung = findViewById(R.id.NoiDung);
        txtTenTruyen = findViewById(R.id.TenTruyen);
        btnXoa = findViewById(R.id.btnXoa);
        db = new DatabaseDocTruyen(this);

        Intent intent = getIntent();
        i=intent.getIntExtra("phanq", 0);
        tenTruyen = intent.getStringExtra("tentruyen");
        noidung = intent.getStringExtra("noidung");

        if(i==1) {
            btnXoa.setEnabled(false);
        }else {
            btnXoa.setEnabled(true);
        }
       txtTenTruyen.setText(tenTruyen);
       txtNoidung.setText(noidung);

       btnXoa.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openDialogYesNo(Gravity.CENTER);
           }
       });

        txtNoidung.setMovementMethod(new ScrollingMovementMethod());

    }


    private void openDialogYesNo(int gravity) {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogdelete);

        Window window=dialog.getWindow();
        if(window==null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute=window.getAttributes();
        windowAttribute.gravity=gravity;
        window.setAttributes(windowAttribute);

        if(Gravity.BOTTOM==gravity) {
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }

        Button btnYes=dialog.findViewById(R.id.buttonYes);
        Button btnNo=dialog.findViewById(R.id.buttonNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DelTruyen(tenTruyen);
                Intent intent=new Intent(ManNoiDungTruyen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialog.show();
    }
}