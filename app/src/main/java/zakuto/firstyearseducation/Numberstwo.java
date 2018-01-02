package zakuto.firstyearseducation;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;


public class Numberstwo extends Activity implements  TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private Button btnSpeak;
    String sayiText = " ";
    TextView basilacaksayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numberstwo);

        basilacaksayi = (TextView) findViewById(R.id.editText);
        tts = new TextToSpeech(this, this);


        final ImageButton bir = (ImageButton) findViewById(R.id.btn_one);
        bir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "1";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);
            }
        });

        final ImageButton iki = (ImageButton) findViewById(R.id.btn_two);
        iki.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "2";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton uc = (ImageButton) findViewById(R.id.btn_three);
        uc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "3";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton dort = (ImageButton) findViewById(R.id.btn_four);
        dort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "4";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton bes = (ImageButton) findViewById(R.id.btn_five);
        bes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "5";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton alti = (ImageButton) findViewById(R.id.btn_six);
        alti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "6";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton yedi = (ImageButton) findViewById(R.id.btn_seven);
        yedi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "7";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton sekiz = (ImageButton) findViewById(R.id.btn_eight);
        sekiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "8";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton dokuz = (ImageButton) findViewById(R.id.btn_nine);
        dokuz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "9";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final ImageButton sifir = (ImageButton) findViewById(R.id.btn_zero);
        sifir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = BasilacakString + "0";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);

            }
        });

        final Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String BasilacakString = sayiText.toString();
                BasilacakString = "";
                sayiText = BasilacakString.toString();
                basilacaksayi.setText(sayiText);
                //Try to improve deleting only last char
            }
        });


        final ImageButton play =(ImageButton) findViewById(R.id.playnumberstwo);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut(sayiText);
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

    private void speakOut(String letters) {
        sayiText.toString();
        tts.speak(sayiText, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_numberstwo, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
