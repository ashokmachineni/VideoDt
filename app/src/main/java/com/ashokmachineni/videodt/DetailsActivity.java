package com.ashokmachineni.videodt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    Button plabut, dowbut;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dowbut = findViewById(R.id.downbut);

        String names = getIntent().getExtras().getString("titles");
        String imaur = getIntent().getExtras().getString("images");

        final String vidurl = getIntent().getExtras().getString("url");

        TextView txtview = findViewById(R.id.textst);
        ImageView imgv = findViewById(R.id.imge);
        txtview.setText(names);
        Glide.with(this)
                .load(imaur)
                .into(imgv);
        plabut = findViewById(R.id.playbut);

        plabut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ExActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("urlex",vidurl);
                context.startActivity(intent);

            }
        });


    }
}
