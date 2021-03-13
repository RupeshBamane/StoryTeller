package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class Tortoisegeese extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public static final String PREFS_NAME = "MyPrefsFile";
    Switch sSwitch2;
    private TextToSpeech tts;
    //private Button buttonSpeak;
    private TextView textView, textView1;
    AlertDialog.Builder alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tortoisegeese);

        tts = new TextToSpeech(this,this);
        // buttonSpeak = (Button) findViewById(R.id.item1);
        textView = findViewById(R.id.edtTxt1);
        textView1 = findViewById(R.id.edtTxt2);
        alert = new AlertDialog.Builder(this);

        sSwitch2 = (Switch) findViewById(R.id.simpleSwitch2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("switchkey", false);
        sSwitch2.setChecked(silent);
        sSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Toast.makeText(this, "Reading...", Toast.LENGTH_SHORT).show();

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", isChecked);
                editor.commit();

                if(isChecked){
                    speakOut();
                    //Toast.makeText(this, "Reading...", Toast.LENGTH_SHORT).show();
                }
                else{
                    tts.stop();
                }

            }
        });
    }

    @Override
    protected  void onStop(){
        super.onStop();
        tts.stop();

        sSwitch2.setChecked(false);

    }

    private void speakOut() {
        String text1 = textView1.getText().toString();
        tts.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {
        if (status==TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.ENGLISH);

            if(result == TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","This Language is not Supported!!!");

            }
//            else {
//                // buttonSpeak.setEnabled(true);
//                //speakOut();
//            }
        }
        else{
            Log.e("TTS", "Initilization Failed!");
        }

    }
}