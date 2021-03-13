package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ThirstyCrow extends AppCompatActivity implements TextToSpeech.OnInitListener {
    public static final String PREFS_NAME = "MyPrefsFile";
    Switch sSwitch2;
    private TextToSpeech tts;
    //private Button buttonSpeak;
    private TextView textView, textView1;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirsty_crow);
       //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        tts = new TextToSpeech(this,this);
       // buttonSpeak = (Button) findViewById(R.id.item1);
        textView = findViewById(R.id.edtTxt1);
        textView1 = findViewById(R.id.edtTxt2);



//        buttonSpeak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                speakOut();
//            }
//        });
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_mains,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//
//        switch (id){
//            case R.id.item1:
//               Toast.makeText(this, "Reading...", Toast.LENGTH_SHORT).show();
//                speakOut();
//
//                return true;
//
//            case R.id.item2:
//                Toast.makeText(this, "Readig is Stopped...", Toast.LENGTH_SHORT).show();
//                tts.stop();
//                return true;
//
//            case R.id.item3:
//
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT, "Listen To This Interesting Story On -<StoryTeller> Application. http://www.play.google.com");
//                startActivity(intent);
//
//                Toast.makeText(this, "Sharing Story", Toast.LENGTH_SHORT).show();
//
//
//
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//        if (tts != null) {
//            tts.stop();
//            tts.shutdown();
//        }
//        super.onDestroy();
//    }
//
//    @Override
//    public void onInit(int status) {
//        if (status==TextToSpeech.SUCCESS) {
//            int result = tts.setLanguage(Locale.ENGLISH);
//
//            if(result == TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
//                Log.e("TTS","This Language is not Supported!!!");
//
//            }
//            else {
//               // buttonSpeak.setEnabled(true);
//                //speakOut();
//            }
//        }
//        else{
//            Log.e("TTS", "Initilization Failed!");
//        }
//
//    }
//
//
//    private void speakOut() {
////        String text = textView.getText().toString();
////        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//
//        String text1 = textView1.getText().toString();
//        tts.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
//    }

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

//            if(result == TextToSpeech.LANG_MISSING_DATA || result== TextToSpeech.LANG_NOT_SUPPORTED){
//                Log.e("TTS","This Language is not Supported!!!");
//
//            }
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