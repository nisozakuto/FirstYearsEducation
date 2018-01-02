package zakuto.firstyearseducation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
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
import java.util.Random;

public class QuizActivity extends Activity {

    TextView Question_Number, status;
    private ImageButton img_btn1, img_btn2, img_btn3, img_btn4, play_btn;
    MediaPlayer mediaPlayer, mp;
    ProgressDialog notification;
    int level = 0;

    int[] picId = {
            R.drawable.bear,
            R.drawable.cat,
            R.drawable.cow,
            R.drawable.chicken,
            R.drawable.elephant,
            R.drawable.mosquito,
            R.drawable.horse,
            R.drawable.seagulls,
            R.drawable.sheep,
    };

    int[] soundId = {
            R.raw.bear,
            R.raw.cat,
            R.raw.cow,
            R.raw.chicken,
            R.raw.elephant,
            R.raw.mosquito,
            R.raw.horse,
            R.raw.seagulls,
            R.raw.sheep,
    };

    int[] randompicIdIndex = new int[4];
    int correctId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Question_Number = (TextView) findViewById(R.id.Question_Number);
        img_btn1 = (ImageButton) findViewById(R.id.img_btn1);
        img_btn2 = (ImageButton) findViewById(R.id.img_btn2);
        img_btn3 = (ImageButton) findViewById(R.id.img_btn3);
        img_btn4 = (ImageButton) findViewById(R.id.img_btn4);
        play_btn = (ImageButton) findViewById(R.id.play_btn);
        status = (TextView) findViewById(R.id.Status);
        mp = MediaPlayer.create(this, R.raw.applause);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (!mediaPlayer.isPlaying())
                        mediaPlayer.start();
                }
            }
        });

        prepareRandomNumbers();
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
                        if (mediaPlayer.isPlaying() == true) {
                            mediaPlayer.pause();
                            mediaPlayer.seekTo(0);
                        }

                        break;
                    case R.id.img_btn2:
                        selectedPicture = randompicIdIndex[1];
                        if (mediaPlayer.isPlaying() == true) {
                            mediaPlayer.pause();
                            mediaPlayer.seekTo(0);
                        }
                        break;
                    case R.id.img_btn3:
                        selectedPicture = randompicIdIndex[2];
                        if (mediaPlayer.isPlaying() == true) {
                            mediaPlayer.pause();
                            mediaPlayer.seekTo(0);
                        }
                        break;
                    case R.id.img_btn4:
                        selectedPicture = randompicIdIndex[3];
                        if (mediaPlayer.isPlaying() == true) {
                            mediaPlayer.pause();
                            mediaPlayer.seekTo(0);
                        }
                        break;
                }

                if (selectedPicture == correctId) {

                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    mediaPlayer.stop();
                    notification = new ProgressDialog(QuizActivity.this);
                    notification.setMessage("Congratulations");
                    notification.show();

                    Thread timer = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(2000);
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
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }

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
                            QuizActivity.this.finish();
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

        if (level < 11) {
            mediaPlayer = MediaPlayer.create(this, soundId[correctId]);
            mediaPlayer.start();
        }


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
        Log.e("Sayi", " " + number1);

        return number1;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            if (mp != null) {
                mp.pause();
                mp.seekTo(0);
            }


            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
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