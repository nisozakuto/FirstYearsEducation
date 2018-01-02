package zakuto.firstyearseducation;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Locale;


public class SpeakTheWord extends ActionBarActivity  implements TextToSpeech.OnInitListener{

    private TextToSpeech tts;
    private Button btnSpeak;

    EditText enter;
    String text, sayiText = " ";
    TextView basilacaksayi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakheword);

        tts = new TextToSpeech(this, this);
        enter = (EditText) findViewById(R.id.ttstext);

        btnSpeak = (Button) findViewById(R.id.ttsbutton);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
    }

    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }



    private void speakOut() {
        String text = enter.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public void onInit(int status) {

    }
}

