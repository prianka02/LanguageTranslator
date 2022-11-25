package com.example.languagetranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class MainActivity extends AppCompatActivity {
    EditText inputTxt;
    Button btnTranslate;
    TextView translatedTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        btnTranslate = findViewById(R.id.btnTranslate);
        translatedTxt = findViewById(R.id.translatedTxt);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,  //Source language
                        Language.BENGALI,  //Target language
                        inputTxt.getText().toString()   //query text here
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        translatedTxt.setText(translatedText);
                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error", ErrorText);

                    }
                });
            }
        });

    }
}