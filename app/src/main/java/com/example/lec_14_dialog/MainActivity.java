package com.example.lec_14_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b0,b,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0=findViewById(R.id.toast_simple);
        b=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        //simple toast
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t=Toast.makeText(MainActivity.this,"Text toast",Toast.LENGTH_LONG);
                t.show();
            }
        });
        //customized toast
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater lf=getLayoutInflater();
                View mylayout=lf.inflate(R.layout.customized_toast,null);
                ImageView img=mylayout.findViewById(R.id.imageView);
                //img.setImageResource(R);
                TextView tv=mylayout.findViewById(R.id.toast);
                tv.setText("TOOAST VIEW UPDATE");

                Toast toast=new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(mylayout);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Title here");
                builder.setMessage("Meessage here");
                builder.setCancelable(false);
                builder.setPositiveButton("positive btn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("negative btn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            String []colos={"green","blue","red","yellow"};

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Available Colors").setItems(colos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //theek krny ki zroorat hy isy
                        LayoutInflater lf=getLayoutInflater();
                        View mylayout=lf.inflate(R.layout.customized_toast,null);
                        ImageView img=mylayout.findViewById(R.id.imageView);
                        TextView tv=mylayout.findViewById(R.id.toast);
                        tv.setText(colos[i]);

                        Toast toast=new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(mylayout);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                });
                builder.setCancelable(false);


                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
    }
}