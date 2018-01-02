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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Letters extends Activity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button btn_listen, btn_next;
    private String a = "a", b = "b", c = "c",
            d = "d", e = "e", f = "f",
            g = "g", h = "h", i = "i",
            j = "j", k = "k", l = "l",
            m = "m", n = "n", o = "o",
            p = "p", q = "q", r = "r",
            s = "s", t = "t", u = "u",
            v = "v", w = "w", y = "y", x="x",
            z = "z", iyazi;
    EditText girilenyazi;
    TextView alphabet;
    int asci = 64;

    int[] letters = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.y,
            R.drawable.z,
    };


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.exit:
                Toast.makeText(this, "Geri gelindi", Toast.LENGTH_SHORT).show();
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        tts = new TextToSpeech(this, this);


        ImageButton play_a = (ImageButton) findViewById(R.id.btn_a);
        ImageButton play_b = (ImageButton) findViewById(R.id.btn_b);
        ImageButton play_c = (ImageButton) findViewById(R.id.btn_c);
        ImageButton play_d = (ImageButton) findViewById(R.id.btn_d);
        ImageButton play_e = (ImageButton) findViewById(R.id.btn_e);

        ImageButton play_f = (ImageButton) findViewById(R.id.btn_f);
        ImageButton play_g = (ImageButton) findViewById(R.id.btn_g);
        ImageButton play_h = (ImageButton) findViewById(R.id.btn_h);
        ImageButton play_i = (ImageButton) findViewById(R.id.btn_i);

        ImageButton play_j = (ImageButton) findViewById(R.id.btn_j);
        ImageButton play_k = (ImageButton) findViewById(R.id.btn_k);
        ImageButton play_l = (ImageButton) findViewById(R.id.btn_l);
        ImageButton play_m = (ImageButton) findViewById(R.id.btn_m);

        ImageButton play_n = (ImageButton) findViewById(R.id.btn_n);
        ImageButton play_o = (ImageButton) findViewById(R.id.btn_o);
        ImageButton play_p = (ImageButton) findViewById(R.id.btn_p);
        ImageButton play_q = (ImageButton) findViewById(R.id.btn_q);

        ImageButton play_r = (ImageButton) findViewById(R.id.btn_r);
        ImageButton play_s = (ImageButton) findViewById(R.id.btn_s);
        ImageButton play_t = (ImageButton) findViewById(R.id.btn_t);
        ImageButton play_u = (ImageButton) findViewById(R.id.btn_u);

        ImageButton play_v = (ImageButton) findViewById(R.id.btn_v);
        ImageButton play_w = (ImageButton) findViewById(R.id.btn_w);
        ImageButton play_y = (ImageButton) findViewById(R.id.btn_y);
        ImageButton play_z = (ImageButton) findViewById(R.id.btn_z);


        play_a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
               // tts.speak(a.toString(), TextToSpeech.QUEUE_FLUSH, null);
            speakOut(a);
            }
        });
        play_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(b);

            }
        });
        play_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(c);
            }
        });
        play_d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(d);
            }
        });
        play_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(e);

            }
        });
        play_f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(f);

            }
        });
        play_g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(g);
            }
        });
        play_h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(h);
            }
        });
        play_i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(i);
            }
        });
        play_j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(j);

            }
        });
        play_k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(k);
            }
        });
        play_l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(l);

            }
        });
        play_m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(m);

            }
        });
        play_n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(n);

            }
        });
        play_o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(o);
            }
        });
        play_p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(p);
            }
        });
        play_q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(q);

            }
        });
        play_r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(r);

            }
        });
        play_s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(s);
            }
        });
        play_t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(t);
            }
        });
        play_u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(u);

            }
        });
        play_v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(v);
            }
        });
        play_w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(w);
            }
        });
        play_y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(x);
            }
        });
        play_y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(y);
            }
        });

        play_z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                speakOut(z);
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

    private void speakOut(String letters) {
        letters.toString();
        tts.speak(letters, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_letters, menu);

        return super.onCreateOptionsMenu(menu);
    }
}