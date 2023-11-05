package com.example.mytarea;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataClass getData = getIntent().getParcelableExtra("android");
        if (getData != null) {
            TextView detailTitle = findViewById(R.id.detailTitle);
            TextView detailDesc = findViewById(R.id.detailDesc);
            ImageView detailImage = findViewById(R.id.detailImage);

            detailTitle.setText(getData.getDataTitle());
            detailDesc.setText(getData.getDataDesc());
            detailImage.setImageResource(getData.getDataDetailImage());
        }
    }
}
