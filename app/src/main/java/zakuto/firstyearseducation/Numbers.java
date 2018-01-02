package zakuto.firstyearseducation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class Numbers extends Activity implements TextToSpeech.OnInitListener {
    ImageButton btnNext;
    private TextToSpeech tts;
    String zero = "zero", one = "one", two = "" + 2,
            three = "" + 3, four = "" + 4, five = "" + 5,
            six = "" + 6, seven = "" + 7, eight = "" + 8,
            nine = "" + 9;


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.exit:
                Toast.makeText(this, "Back Menu", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        tts = new TextToSpeech(this, this);

        final ImageButton calbir = (ImageButton) findViewById(R.id.btn_one);
        calbir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(one);
            }
        });

        final ImageButton caliki = (ImageButton) findViewById(R.id.btn_two);
        caliki.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(two);
            }
        });

        final ImageButton caluc = (ImageButton) findViewById(R.id.btn_three);
        caluc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(three);
            }
        });

        final ImageButton caldort = (ImageButton) findViewById(R.id.btn_four);
        caldort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(four);
            }
        });

        final ImageButton calbes = (ImageButton) findViewById(R.id.btn_five);
        calbes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(five);
            }
        });

        final ImageButton calalti = (ImageButton) findViewById(R.id.btn_six);
        calalti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(six);
            }
        });

        final ImageButton calyedi = (ImageButton) findViewById(R.id.btn_seven);
        calyedi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(seven);
            }
        });

        final ImageButton calsekiz = (ImageButton) findViewById(R.id.btn_eight);
        calsekiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(eight);
            }
        });

        final ImageButton caldokuz = (ImageButton) findViewById(R.id.btn_nine);
        caldokuz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(nine);
            }
        });

        final ImageButton calsifir = (ImageButton) findViewById(R.id.btn_zero);
        calsifir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(zero);
            }
        });

        final ImageButton ikincisayfa = (ImageButton) findViewById(R.id.nextbutton);
        ikincisayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberssecond = new Intent(Numbers.this, Numberstwo.class);
                startActivity(numberssecond);
            }
        });




    }


    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut(String numbers) {


        tts.speak(numbers, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_numbers, menu);
        return super.onCreateOptionsMenu(menu);
    }
}