package zakuto.firstyearseducation;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.zip.Inflater;


public class MainActivity extends ActionBarActivity {


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.exit:
                Toast.makeText(this, "App has been closed", Toast.LENGTH_SHORT).show();
                finish();
                break;


            case R.id.tts:
                Intent intent = new Intent(MainActivity.this, SpeakTheWord.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("We're exploring together!");  // provide compatibility to all the versions

        ImageButton btn_sayilar = (ImageButton) findViewById(R.id.btn_sayilar);
        ImageButton btn_letters = (ImageButton) findViewById(R.id.btn_letters);
        ImageButton btn_quiznumbers = (ImageButton) findViewById(R.id.quiznumbers);
        ImageButton btn_quizanimals = (ImageButton) findViewById(R.id.btn_quizanimals);
        ImageButton btn_aboutus = (ImageButton) findViewById(R.id.btn_aboutus);

        btn_sayilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e("OnClick", "Sayılar Clicked");
                Intent intent = new Intent(MainActivity.this, Numbers.class);


                startActivity(intent);

            }
        });

        btn_letters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e("OnClick", "Resimler Clicked");
                Intent intentLetters = new Intent(MainActivity.this, Letters.class);
                startActivity(intentLetters);
            }
        });


        btn_quizanimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuiz = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intentQuiz);
            }
        });


        btn_quiznumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Log.e("OnClick", "Image Clicked");
                Intent intentImage = new Intent(MainActivity.this, QuizNumber.class);
                startActivity(intentImage);
            }
        });

        btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Log.e("OnClick", "Image Clicked");
                Intent intentImage = new Intent(MainActivity.this, About.class);
                startActivity(intentImage);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

}
