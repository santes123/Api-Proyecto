package com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_text;

/**
 * Created by pumpun5 on 4/10/17.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.FinActivity;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
import com.pumpun.proyectformapiantoniogonzalez.POJO.EntryForm;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Form;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Formulario;
import com.pumpun.proyectformapiantoniogonzalez.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.WHITE;

/**
 * Created by pumpun5 on 29/9/17.
 */

public class GameActivityText2 extends AppCompatActivity {

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";

    //GRAVITY FORMS
    public static final String URL_EJEMPLO = "http://evaluartes.com/gravityformsapi/forms/1/?api_key=843263d000&signature=JN7RgV01Td%2FlrYh2Zxuab9x0uww%3D&expires=1507013829";

    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_ID_FORM = "1";
    public static final String API_KEY = "843263d000";
    public static final String API_EXPIRES= "1506585987";
    public static String API_SIGNATURE= API_KEY+":GET:forms/"+API_ID_FORM+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+API_ID_FORM+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;

    //ARRAY CON LOS OBJETOS DEL RESULTADO
    public List<String> listaResultados;

    //items de el formulario


    Button btnEnviar,btnNext;
    TextView tvPregunta,tvMessage,tvTitle,TvPorcentaje;
    ProgressDialog progressDialog;
    public int contador;
    EditText etRespuesta;
    public String InputType;
    public ImageView img;
    ProgressBar simpleProgressBar;
    int progress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game_option_text);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        tvTitle = (TextView) findViewById(R.id.tv_titulo);
        tvPregunta = (TextView) findViewById(R.id.tv_pregunta);
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        btnNext = (Button) findViewById(R.id.btn_next);
        img = (ImageView) findViewById(R.id.ic_launcher);
        etRespuesta = (EditText) findViewById(R.id.et_respuesta);
        TvPorcentaje = (TextView) findViewById(R.id.tv_porcentaje);
        etRespuesta.setTextColor(WHITE);
        simpleProgressBar=(ProgressBar) findViewById(R.id.PbSelector); // initiate the progress bar
       /* int maxValue=simpleProgressBar.getMax(); // get maximum value of the progress bar
        int progressValue=simpleProgressBar.getProgress();*/
        simpleProgressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#80DAEB"),
                android.graphics.PorterDuff.Mode.MULTIPLY);
        simpleProgressBar.setProgress(100);
        simpleProgressBar.setMax(110);
        // simpleProgressBar.setProgress(progress);
        simpleProgressBar.setBackgroundColor(Color.GREEN);// 50 default progress value for the progress bar

        String id = "2";
        //getForm(id);
        getForm2(id);
        generateTextProgressBar();

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
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEntryData();
                Integer newProgress =  getIntent().getExtras().getInt("parametro2");
                setProgressValue(newProgress+10);
                newProgress=newProgress+10;
                progress=newProgress;

                Intent intent = new Intent(view.getContext(), FinActivity.class);
                intent.putExtra("parametro", contador);
                intent.putExtra("parametro2", progress);
                intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                Log.d("listResultados11 = ", String.valueOf((listaResultados.size())));

                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                startActivityForResult(intent, 0);

                //METODO GUARDAR DATOS DEL FORMULARIO
                com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods.UtilityMethods.saveData();
                EntryForm form=new EntryForm();


                //form.get.....pregunta11
                PostData(form);
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

    private void setProgressValue(final int progress) {

        // set the progress
        simpleProgressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }


    public void btnEnviar() {
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEntryData();
                Integer newProgress =  getIntent().getExtras().getInt("parametro2");
                setProgressValue(newProgress+10);
                newProgress=newProgress+10;
                progress=newProgress;

                Intent intent = new Intent(view.getContext(), FinActivity.class);
                intent.putExtra("parametro", contador);
                intent.putExtra("parametro2", progress);
                intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                Log.d("listResultados11 = ", String.valueOf((listaResultados.size())));

                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                startActivityForResult(intent, 0);

                //METODO GUARDAR DATOS DEL FORMULARIO
                com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods.UtilityMethods.saveData();
                EntryForm form=new EntryForm();


                //form.get.....pregunta11
                PostData(form);
            }
        });

    }

    //METODO CONECTA CON LA API

    protected void getForm(String id) {
        super.onResume();

        //Setup ProgressDialog
        /*progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("We are fetching user data.");
        progressDialog.setCancelable(false);
        progressDialog.show();*/
        id = "2";

        APIClientGravity.getInstance().getApi().getFormApi(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {
                        if (!GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                           // Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            Form form = response.body();

                            String titulo = form.response.getTitle();
                            String pregunta = form.response.fields.get(0).label;
                            String respuesta1 = form.response.fields.get(0).getChoices().get(0).getValue();
                            String respuesta2 = form.response.fields.get(0).getChoices().get(1).getValue();;
                            String respuesta3 = form.response.fields.get(0).getChoices().get(2).getValue();;
                            String respuesta4 = form.response.fields.get(0).getChoices().get(3).getValue();;

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));
                            /*btnAnswer1.setText(String.valueOf(respuesta1));
                            btnAnswer2.setText(String.valueOf(respuesta2));
                            btnAnswer3.setText(String.valueOf(respuesta3));
                            btnAnswer4.setText(String.valueOf(respuesta4));*/


                            if(contador == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                                btnNext.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivityText2.this.isFinishing() && progressDialog.isShowing())
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
        progressDialog.setMessage("we are loading your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "2";

        APIClientGravity.getInstance().getApi().getForm(Integer.valueOf(id)).enqueue(
                new Callback<Formulario>() {

                    @Override
                    public void onResponse(Call<Formulario> call,
                                           Response<Formulario> response) {
                        if (!GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                            //Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            Formulario form = response.body();
                            Integer contadorConvertido =  getIntent().getExtras().getInt("parametro");

                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contadorConvertido));
                            String pregunta = form.response.fields.get(contadorConvertido).label;
                            String titulo = form.response.getTitle();

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));

                            //getEntryData();
                            contadorConvertido++;
                            contador=contadorConvertido;
                            if(contadorConvertido == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                                btnNext.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<Formulario> call,
                                          Throwable t) {
                        if (GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });
        progressDialog.show();
    }

    public void PostEntry(EntryForm form){

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------

    //METODO SELECCIONAR TIPO DE FORMULARIO

    public String getType(String id){
        super.onResume();

        //Setup ProgressDialog
       /* progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("We are fetching user data.");
        progressDialog.setCancelable(false);
        progressDialog.show();*/
        id = "2";

        APIClientGravity.getInstance().getApi().getType(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {
                        if (!GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                          //  Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            //tvMessage.setText("");
                            Form form = response.body();


                            InputType = form.response.fields.get(contador).inputType;
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

                            if(contador == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                                btnNext.setVisibility(View.INVISIBLE);
                            }

                        } else {
                           /* tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());*/
                        }
                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();

                    }

                });
        progressDialog.show();
        return "";
    }

    //--------------------------------------------------------------------------------------------------------------

    //METODO CAMBIAR FORMULARIO.

    protected void getEntryData() {
        listaResultados  = new ArrayList<String>();

        //RECOJEMOS LA LISTA DE LA ACTIVITY 2
        ArrayList<String> ListaResultadosConvertida ;
        ListaResultadosConvertida= (ArrayList<String>) getIntent().getExtras().get("parametro3");
        //METEMOS EL VALOR DEL EDITEXT EN UN ARRAY DE STRING
        //etRespuesta.setText("texto2");
        String objeto = String.valueOf(etRespuesta.getText());
        ListaResultadosConvertida.add(objeto);
        listaResultados=ListaResultadosConvertida;
        Log.d("listResultadosEntrada10 = ", objeto);
        Log.d("listaResultadosSizeFor10 = ", String.valueOf(ListaResultadosConvertida.size()));
    }
    //--------------------------------------------------------------------------------------------------------------
    //METODO PARA MANDAR EL POST A LA ENTRY
    public void PostData(EntryForm form){
       /* super.onResume();
        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("we are loading your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();


        APIClientGravity.getInstance().getApi().postEntry(form).enqueue(
                new Callback<EntryForm>() {

                    @Override
                    public void onResponse(Call<EntryForm> call,
                                           Response<EntryForm> response) {
                        if (!GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                            //Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            EntryForm form = response.body();
                            Integer contadorConvertido =  getIntent().getExtras().getInt("parametro");

                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contadorConvertido));
                            String pregunta = form.response.fields.get(contadorConvertido).label;
                            String titulo = form.response.getTitle();

                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));

                            contadorConvertido++;
                            contador=contadorConvertido;
                            if(contadorConvertido == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                                btnNext.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<EntryForm> call,
                                          Throwable t) {
                        if (GameActivityText2.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });
        progressDialog.show();*/
    }
    public void generateTextProgressBar(){
        TvPorcentaje.setTextSize(15);
        TvPorcentaje.setTextColor(WHITE);
        TvPorcentaje.setText("11/11");

    }
}
