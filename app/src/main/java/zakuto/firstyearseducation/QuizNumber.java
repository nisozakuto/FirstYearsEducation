package zakuto.firstyearseducation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.sql.BatchUpdateException;
import java.util.Locale;
import java.util.Random;

public class QuizNumber extends Activity implements TextToSpeech.OnInitListener {

    TextView Question_Number, status;
    private ImageButton img_btn1, img_btn2, img_btn3, img_btn4, play_btn;
    ProgressDialog notification;
    int level = 0;
    private TextToSpeech tts;


    int[] picId = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
    };

    String[] soundtxt;

    int[] randompicIdIndex = new int[4];
    int correctId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_number);

        tts = new TextToSpeech(this, this);

        soundtxt = new String[9];
        for (int i = 1; i < 10; i++) {
            soundtxt[i - 1] = "" + i;
        }

        Question_Number = (TextView) findViewById(R.id.Question_Number);
        img_btn1 = (ImageButton) findViewById(R.id.img_btn1);
        img_btn2 = (ImageButton) findViewById(R.id.img_btn2);
        img_btn3 = (ImageButton) findViewById(R.id.img_btn3);
        img_btn4 = (ImageButton) findViewById(R.id.img_btn4);
        play_btn = (ImageButton) findViewById(R.id.play_btn);
        status = (TextView) findViewById(R.id.Status);

        //mp = MediaPlayer.create(this, R.raw.applause);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut(soundtxt[correctId]);
            }
        });
        prepareRandomNumbers();
        speakOut(soundtxt[correctId]);


        img_btn1.setOnClickListener(picListener);
        img_btn2.setOnClickListener(picListener);
        img_btn3.setOnClickListener(picListener);
        img_btn4.setOnClickListener(picListener);


    }



    View.OnClickListener picListener;
    {
        picListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                int selectedPicture = -1;

                switch (id) {
                    case R.id.img_btn1:
                        selectedPicture = randompicIdIndex[0];
                        break;
                    case R.id.img_btn2:
                        selectedPicture = randompicIdIndex[1];
                        break;
                    case R.id.img_btn3:
                        selectedPicture = randompicIdIndex[2];
                        break;
                    case R.id.img_btn4:
                        selectedPicture = randompicIdIndex[3];
                        break;
                }

                if (selectedPicture == correctId) {


                    notification = new ProgressDialog(QuizNumber.this);
                    notification.setMessage("Congratulations");
                    notification.show();

                    Thread timer = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(500);
                                notification.dismiss();

                            } catch (Exception e) {
                            }
                        }
                    };
                    timer.start();
                    prepareRandomNumbers();
                } else {
                    status.setVisibility(View.VISIBLE);
                }
            }
        };
    }

    public void prepareRandomNumbers() {
        level++;
        if (level == 11) {
            notification.dismiss();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            // set dialog message
            alertDialogBuilder
                    .setMessage(R.string.endofgame)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, close
                            // current activity
                            QuizNumber.this.finish();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();

            //03.05.2015 edit oyun bitimi müzik çalmasýn
        } else {
            Question_Number.setText(level + " / 10");
        }

        status.setVisibility(View.INVISIBLE);

        for (int i = 0; i < 4; i++)
            randompicIdIndex[i] = -1;

        randompicIdIndex[0] = createRandomNumbers();
        randompicIdIndex[1] = createRandomNumbers();
        randompicIdIndex[2] = createRandomNumbers();
        randompicIdIndex[3] = createRandomNumbers();

        correctId = randompicIdIndex[(int) (Math.random() * randompicIdIndex.length)];

        img_btn1.setImageDrawable(getResources().getDrawable(picId[randompicIdIndex[0]]));
        img_btn2.setImageDrawable(getResources().getDrawable(picId[randompicIdIndex[1]]));
        img_btn3.setImageDrawable(getResources().getDrawable(picId[randompicIdIndex[2]]));
        img_btn4.setImageDrawable(getResources().getDrawable(picId[randompicIdIndex[3]]));
        speakOut(soundtxt[correctId]);

    }

    public int createRandomNumbers() {
        int number1;
        boolean issame;

        while (true) {
            issame = false;
            number1 = (int) (Math.random() * picId.length);

            for (int i = 0; i < randompicIdIndex.length; i++) {
                if (randompicIdIndex[i] == number1) {
                    issame = true;
                }
            }

            if (!issame) {
                break;
            }
        }
        Log.e("Rastgele seçilen sayý:", " " + number1);
        return number1;
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}