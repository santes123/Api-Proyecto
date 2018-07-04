package com.pumpun.proyectformapiantoniogonzalez.Activities;

/**
 * Created by pumpun5 on 4/10/17.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_radioButtons.GameActivityRadioButtons;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_selector.GameActivitySelector;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_text.GameActivityText;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
import com.pumpun.proyectformapiantoniogonzalez.MainActivity;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Form;
import com.pumpun.proyectformapiantoniogonzalez.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pumpun5 on 28/9/17.
 */

public class PlayActivity extends AppCompatActivity {

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";

    //GRAVITY FORMS
    public static final String URL_EJEMPLO = "http://evaluartes.com/gravityformsapi/forms/1/?api_key=843263d000&signature=PZUvAW6eKwJD8MLQjIdCa2aksGU%3D&expires=1506585987";

    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_ID_FORM = "2";
    public static final String API_KEY = "843263d000";
    public static final String API_EXPIRES= "1506585987";
    public static String API_SIGNATURE= API_KEY+":GET:forms/"+API_ID_FORM+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+API_ID_FORM+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;
    public String InputType;
    ProgressDialog progressDialog;
    //items de el formulario
    public ImageView img;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_play);
        img = (ImageView) findViewById(R.id.ic_launcher);
        level1();
        level2();
        level3();
        level4();
        back();
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
  /*  public void girar() {
        img = (ImageView) findViewById(R.id.ic_launcher);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation giro;
                giro = AnimationUtils.loadAnimation(PlayActivity.this,R.animator.rotate);
                giro.reset();
                img.startAnimation(giro);
            }
    });
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ic_launcher:
                //metodoAdd()
                //info.setText("Se presionó Añadir");
                return true;
            case R.id.about_us:
                //metodoSearch()
                // info.setText("Se presionó Buscar");
                return true;
            case R.id.how_to_play:
                //metodoEdit()
                //  info.setText("Se presionó Editar");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //SWAP a Play mode
    public void level1() {
        Button btnGet = (Button) findViewById(R.id.btn_level_1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(v.getContext(), GameActivity.class);
                startActivityForResult(intent, 0);*/
                String id = "2";
                getType(id);
               // String type = getType(id);
                Log.d("valor : ", getType(id));
                 if(getType(id)=="radio"){
                     Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                     Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                     Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    startActivityForResult(intent, 0);
                }else{
                     Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    startActivityForResult(intent, 0);

                }
            }
        });

    }

    //SWAP a LeaderBoader
    public void level2() {
        Button btnGet = (Button) findViewById(R.id.btn_level_2);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                /*Intent intent = new Intent(v.getContext(), GameActivity.class);
                startActivityForResult(intent, 0);*/
                String id = "2";
                getType(id);
                // String type = getType(id);
                Log.d("valor : ", getType(id));
                if(getType(id)=="radio"){
                    Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                    Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                    Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    startActivityForResult(intent, 0);
                }else{
                    Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    startActivityForResult(intent, 0);

                }
            }
        });

    }

    //SWAP a Learn
    public void level3() {
        Button btnGet = (Button) findViewById(R.id.btn_level_3);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                /*Intent intent = new Intent(v.getContext(), GameActivity.class);
                startActivityForResult(intent, 0);*/
                String id = "2";
                getType(id);
                // String type = getType(id);
                Log.d("valor : ", getType(id));
                if(getType(id)=="radio"){
                    Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                    Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                    Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    startActivityForResult(intent, 0);
                }else{
                    Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    startActivityForResult(intent, 0);

                }
            }
        });

    }

    //SWAP a Settings
    public void level4() {
        Button btnGet = (Button) findViewById(R.id.btn_level_4);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                /*Intent intent = new Intent(v.getContext(), GameActivity.class);
                startActivityForResult(intent, 0);*/
                String id = "2";
                getType(id);
                // String type = getType(id);
                Log.d("valor : ", getType(id));
                if(getType(id)=="radio"){
                    Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                    Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector.class);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                    Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    startActivityForResult(intent, 0);
                }else{
                    Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    startActivityForResult(intent, 0);

                }
            }
        });

    }
    //SWAP a Achievements
    public void back() {

        Button btnAuth = (Button) findViewById(R.id.btn_back);
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });


    }

    public String getType(String id){
        super.onResume();

        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("we are loading your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "2";
        APIClientGravity.getInstance().getApi().getType(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {

                        if (!PlayActivity.this.isFinishing() && progressDialog.isShowing())
                           // Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                            //tvMessage.setText("");
                            Form form = response.body();


                              String type = form.response.fields.get(0).inputType;
                            /*String respuesta1 = form.response.fields.get(1).getChoices().get(0).getValue();
                            String respuesta2 = form.response.fields.get(1).getChoices().get(1).getValue();;
                            String respuesta3 = form.response.fields.get(1).getChoices().get(2).getValue();;
                            String respuesta4 = form.response.fields.get(1).getChoices().get(3).getValue();;

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));
                            btnAnswer1.setText(String.valueOf(respuesta1));
                            btnAnswer2.setText(String.valueOf(respuesta2));
                            btnAnswer3.setText(String.valueOf(respuesta3));
                            btnAnswer4.setText(String.valueOf(respuesta4));*/
                            InputType = type;
                            type = InputType;
                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (PlayActivity.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();

                    }

                });
        progressDialog.show();
        return "likert";
    }

   /* public String type(String id){

        return getType(id);
    }
    */
}
