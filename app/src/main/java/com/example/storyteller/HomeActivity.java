package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    AlertDialog.Builder alert,alert1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        alert = new AlertDialog.Builder(this);
        alert1 = new AlertDialog.Builder(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mains,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.item1:
                alert.setTitle("Help");
                alert.setMessage("For Help Kindly Share Your Query Description & Screenshot with us on email id rupesh6997@gmail.com");
                alert.setPositiveButton("OK",null);
                alert.show();
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey! Look what I have found, Listen To This Interesting Stories On -<StoryTeller> Application. https://drive.google.com/drive/folders/1gvJbIeGZRUe5bEg-6mghCVEpsIGEaA04?usp=sharing");
                startActivity(intent);

                Toast.makeText(this, "Sharing..", Toast.LENGTH_SHORT).show();


//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT, "Hey! Look what I have found, Listen To This Interesting Stories On -<StoryTeller> Application. http://www.play.google.com");
//                intent.setData(Uri.parse("https://drive.google.com/drive/folders/1gvJbIeGZRUe5bEg-6mghCVEpsIGEaA04?usp=sharing"));
//                startActivity(intent);
//
//                Toast.makeText(this, "Sharing..", Toast.LENGTH_SHORT).show();
//
                return true;
            case R.id.item3:
                alert.setTitle("About Us");
                alert.setMessage("This App is developed by CODEITES! We develop Android Application Get in touch with us on the email id rupesh6997@gmail.com if you need any kind of Application to be developed.");
                alert.setPositiveButton("OK",null);
                alert.show();
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void firststory(View view)
    {
        Intent i = new Intent(getApplicationContext(),ThirstyCrow.class);
        startActivity(i);
    }
    public void secondstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Fourfriendhunter.class);
        startActivity(i);
    }
    public void thirdstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Mongoosewife.class);
        startActivity(i);
    }
    public void fourthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Jackaldrum.class);
        startActivity(i);
    }

    public void fifthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Goatsjackal.class);
        startActivity(i);
    }
    public void sixthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Lionmouse.class);
        startActivity(i);
    }

    public void seventhstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),StorkCrab.class);
        startActivity(i);
    }
    public void eighthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Tortoisegeese.class);
        startActivity(i);
    }

    public void ninthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Threefish.class);
        startActivity(i);
    }
    public void tenthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Lionrabbit.class);
        startActivity(i);
    }
    public void eleventhstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Elephantsparrow.class);
        startActivity(i);
    }
    public void twelthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),AkbarBirbal.class);
        startActivity(i);
    }
    public void thirteenthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Bundlestick.class);
        startActivity(i);
    }
    public void forteenthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),Bearfriends.class);
        startActivity(i);
    }

    public void sixteenthstory(View view)
    {
        Intent i = new Intent(getApplicationContext(),RabbitTurtle.class);
        startActivity(i);
    }
}