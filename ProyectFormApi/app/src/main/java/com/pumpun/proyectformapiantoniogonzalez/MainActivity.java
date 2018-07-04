package com.pumpun.proyectformapiantoniogonzalez;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.pumpun.proyectformapiantoniogonzalez.Activities.AchievementsActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.LeaderBoardActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.LearnActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.PlayActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";

    //GRAVITY FORMS
    public static final String URL_EJEMPLO = "http://evaluartes.com/gravityformsapi/forms/1/?api_key=843263d000&signature=PZUvAW6eKwJD8MLQjIdCa2aksGU%3D&expires=1506585987";

    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_ID_FORM = "1";
    public static final String API_KEY = "843263d000";
    public static final String API_EXPIRES= "1506585987";
    public static String API_SIGNATURE= API_KEY+":GET:forms/"+API_ID_FORM+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+API_ID_FORM+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;
    public ImageView img;
    private VideoView mVideoView;
    android.app.ActionBar actionBar;

    //items de el formulario





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

       /* mVideoView =(VideoView)findViewById(R.id.surface_view);
        //de forma alternativa si queremos un streaming usar
        //mVideoView.setVideoURI(Uri.parse(URLstring));
        mVideoView.setVideoPath("https://youtu.be/8yaYQQr6_SU");
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
        mVideoView.requestFocus();*/

        actionBar = getActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        //setSupportActionBar(toolbar);

        /*actionBar.setIcon(R.drawable.img_fondo);             //Establecer icono
        actionBar.setTitle("Proyecto Gravity Forms");        //Establecer titulo
        actionBar.show();*/
        getWindow().
                getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        img = (ImageView) findViewById(R.id.ic_launcher);
        Play();
        LeaderBoard();
        Learn();
        Settings();
        Achievements();
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /*Animation giro;
                giro = AnimationUtils.loadAnimation(PlayActivity.this,R.animator.rotate);
                giro.reset();
                img.startAnimation(giro);*/
                RotateAnimation anim = new RotateAnimation(0f, 350f, 0f, 50f);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(Animation.ABSOLUTE);
                anim.setDuration(700);

// Start animating the image
                final ImageView splash = (ImageView) findViewById(R.id.ic_launcher);
                splash.startAnimation(anim);

// Later.. stop the animation
                // splash.setAnimation(null);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ic_launcher:
                Toast.makeText(getApplicationContext(), "SE PRESIONO EL IC_LAUNCHER ", Toast.LENGTH_SHORT).show();
                //metodoAdd()
               /* Intent intento = new Intent(getApplicationContext(), R.menu.menu.class); //layout que quieras abrir
                startActivity(intento);*/
                return true;
            case R.id.about_us:
                Toast.makeText(getApplicationContext(), "SE PRESIONO ABOUT US", Toast.LENGTH_SHORT).show();
                //metodoSearch()

                return true;
            case R.id.how_to_play:
                Toast.makeText(getApplicationContext(), "SE PRESIONO HOW TO PLAY ", Toast.LENGTH_SHORT).show();
                //metodoEdit()

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //SWAP a Play mode
    public void Play() {
        ImageButton btnGet = (ImageButton) findViewById(R.id.btn_play);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    //SWAP a LeaderBoader
    public void LeaderBoard() {
        ImageButton btnPost = (ImageButton) findViewById(R.id.btn_leaderboard);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LeaderBoardActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    //SWAP a Learn
    public void Learn() {
        ImageButton btnPut = (ImageButton) findViewById(R.id.btn_learn);
        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LearnActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    //SWAP a Settings
    public void Settings() {
        ImageButton btnDelete = (ImageButton) findViewById(R.id.btn_settings);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
    //SWAP a Achievements
    public void Achievements() {

        ImageButton btnAuth = (ImageButton) findViewById(R.id.btn_achievement);
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AchievementsActivity.class);
                startActivityForResult(intent, 0);
            }
        });


    }
    //SWAP a about us
    /*public void about_us() {
       MenuItem item = (MenuItem) findViewById(R.id.btn_play);
        MenuItem menuItem = item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(menuItem.getIntent().
                startActivityForResult(intent, 0);
                return true;
            }
        });

    }*/

    //SWAP a how to play
    public void how_to_play() {
        ImageButton btnGet = (ImageButton) findViewById(R.id.btn_play);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }


}
