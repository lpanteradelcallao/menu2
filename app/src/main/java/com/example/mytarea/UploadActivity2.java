package com.example.mytarea;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UploadActivity2 extends AppCompatActivity {

    ImageView uploadImage;
    Button saveButton;
    EditText uploadTopic, uploadDesc, uploadLang;
    Uri uri;

    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        uploadImage = findViewById(R.id.uploadImage);
        uploadDesc = findViewById(R.id.uploadDesc);
        uploadTopic = findViewById(R.id.uploadTopic);
        uploadLang = findViewById(R.id.uploadLang);
        saveButton = findViewById(R.id.saveButton);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Simular la entrada de datos
                String title = uploadTopic.getText().toString();
                String desc = uploadDesc.getText().toString();
                String lang = uploadLang.getText().toString();

                // Simulación: Guardar los datos en una lista local o realizar acciones necesarias
                // Puedes ajustar esta lógica según tus necesidades
                saveDataLocally(title, desc, lang);
                finish();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            uploadImage.setImageURI(uri);
        } else {
            Toast.makeText(UploadActivity2.this, "No Image Selected", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveDataLocally(String title, String desc, String lang) {
        // Simulación: Guardar los datos en una lista local o realizar acciones necesarias
        // Puedes ajustar esta lógica según tus necesidades
        // Por ejemplo, puedes guardar los datos en una lista o base de datos local.
        // Aquí, simplemente mostramos los datos en un Toast.

        String data = "Title: " + title + "\nDescription: " + desc + "\nLanguage: " + lang;
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
