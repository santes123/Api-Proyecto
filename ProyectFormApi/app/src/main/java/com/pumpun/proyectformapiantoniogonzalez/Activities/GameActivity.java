package com.pumpun.proyectformapiantoniogonzalez.Activities;

/**
 * Created by pumpun5 on 4/10/17.
 */
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Formulario;
import com.pumpun.proyectformapiantoniogonzalez.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pumpun5 on 29/9/17.
 */

public class GameActivity extends AppCompatActivity {

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";

    //GRAVITY FORMS
    public static final String URL_EJEMPLO = "http://evaluartes.com/gravityformsapi/forms/1/?api_key=843263d000&signature=JN7RgV01Td%2FlrYh2Zxuab9x0uww%3D&expires=1507013829";

    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_ID_FORM = "1";
    public static final String API_KEY = "843263d000";
    public static final String API_EXPIRES= "1506585987";
    public static String API_SIGNATURE= API_KEY+":GET:forms/"+API_ID_FORM+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+API_ID_FORM+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;

    //items de el formulario

    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;
    Button btnEnviar;
    TextView tvPregunta,tvMessage,tvTitle;
    ProgressDialog progressDialog;
    public int contador=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        tvTitle = (TextView) findViewById(R.id.tv_titulo);
        tvPregunta = (TextView) findViewById(R.id.tv_pregunta);
        btnAnswer1 = (Button) findViewById(R.id.btn_answer_1);
        btnAnswer2 = (Button) findViewById(R.id.btn_answer_2);
        btnAnswer3 = (Button) findViewById(R.id.btn_answer_3);
        btnAnswer4 = (Button) findViewById(R.id.btn_answer_4);
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        String id = "1";
        getForm(id);
        answer1();
        answer2();
        answer3();
        answer4();

        //AÑADIR DISTINTOS TIPOS DE PREGUNTAS(ESCRIBIR,SELECCIONAR,SATISFACCION..ETC)
        //AÑADIR METODO ENVIAR DATOS(HACIA GRAVITY EN LA SECCION ENTRIES(ENTRADAS)
        //AÑADIR CAMBIOS ENTRE LOS TIPOS DE PREGUNTA Y GUARDAR LOS DATOS.

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
    public void answer1() {
        btnAnswer1 = (Button) findViewById(R.id.btn_answer_1);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* tvPregunta.setText("");
                btnAnswer1.setText("");
                btnAnswer2.setText("");
                btnAnswer3.setText("");
                btnAnswer4.setText("");*/

                String id = "1";
                getForm2(id);
            }
        });

    }

    //SWAP a LeaderBoader
    public void answer2() {
        btnAnswer2 = (Button) findViewById(R.id.btn_answer_2);
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "1";
                getForm2(id);
            }
        });

    }

    //SWAP a Learn
    public void answer3() {
        btnAnswer3 = (Button) findViewById(R.id.btn_answer_3);
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "1";
                getForm2(id);
            }
        });

    }

    //SWAP a Settings
    public void answer4() {
        btnAnswer4 = (Button) findViewById(R.id.btn_answer_4);
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "1";
                getForm2(id);

            }
        });

    }

    //METODO CONECTA CON LA API

    protected void getForm(String id) {
        super.onResume();

        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("We are fetching user data.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "1";

        APIClientGravity.getInstance().getApi().getForm(Integer.valueOf(id)).enqueue(
                new Callback<Formulario>() {

                    @Override
                    public void onResponse(Call<Formulario> call,
                                           Response<Formulario> response) {
                        if (!GameActivity.this.isFinishing() && progressDialog.isShowing())
                            Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Todo correcto ", Toast.LENGTH_SHORT).show();

                            tvMessage.setText("");
                            Formulario form = response.body();

                            String titulo = form.response.getTitle();
                            String pregunta = form.response.fields.get(0).label;
                            String respuesta1 = form.response.fields.get(0).getChoices().get(0).getValue();
                            String respuesta2 = form.response.fields.get(0).getChoices().get(1).getValue();;
                            String respuesta3 = form.response.fields.get(0).getChoices().get(2).getValue();;
                            String respuesta4 = form.response.fields.get(0).getChoices().get(3).getValue();;

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));
                            btnAnswer1.setText(String.valueOf(respuesta1));
                            btnAnswer2.setText(String.valueOf(respuesta2));
                            btnAnswer3.setText(String.valueOf(respuesta3));
                            btnAnswer4.setText(String.valueOf(respuesta4));


                            if(contador == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                            }
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<Formulario> call,
                                          Throwable t) {
                        if (GameActivity.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });
        contador++;
        progressDialog.show();
    }


    //-------------------------------------------------------------------------------------------------------------------------------------------------

    //METODO CAMBIAR FORMULARIO.

    protected void getForm2(String id) {
        super.onResume();
        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("We are fetching user data.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "1";

        APIClientGravity.getInstance().getApi().getForm(Integer.valueOf(id)).enqueue(
                new Callback<Formulario>() {

                    @Override
                    public void onResponse(Call<Formulario> call,
                                           Response<Formulario> response) {
                        if (!GameActivity.this.isFinishing() && progressDialog.isShowing())
                            Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Todo correcto ", Toast.LENGTH_SHORT).show();

                            tvMessage.setText("");
                            Formulario form = response.body();

                            String titulo = form.response.getTitle();
                            String pregunta = form.response.fields.get(1).label;
                            String respuesta1 = form.response.fields.get(1).getChoices().get(0).getValue();
                            String respuesta2 = form.response.fields.get(1).getChoices().get(1).getValue();;
                            String respuesta3 = form.response.fields.get(1).getChoices().get(2).getValue();;
                            String respuesta4 = form.response.fields.get(1).getChoices().get(3).getValue();;

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));
                            btnAnswer1.setText(String.valueOf(respuesta1));
                            btnAnswer2.setText(String.valueOf(respuesta2));
                            btnAnswer3.setText(String.valueOf(respuesta3));
                            btnAnswer4.setText(String.valueOf(respuesta4));

                            if(contador == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                            }
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<Formulario> call,
                                          Throwable t) {
                        if (GameActivity.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });
        progressDialog.show();
        contador++;
    }
}
