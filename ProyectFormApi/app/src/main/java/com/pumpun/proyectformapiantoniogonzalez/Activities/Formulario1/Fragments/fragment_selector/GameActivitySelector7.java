package com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_selector;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pumpun.proyectformapiantoniogonzalez.Activities.GameActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_radioButtons.GameActivityRadioButtons;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_text.GameActivityText;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
import com.pumpun.proyectformapiantoniogonzalez.POJO.EntryForm;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Form;
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

public class GameActivitySelector7 extends AppCompatActivity {

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";

    //GRAVITY FORMS

    public static final String URL_EJEMPLO = "http://evaluartes.com/gravityformsapi/forms/1/?api_key=843263d000&signature=JN7RgV01Td%2FlrYh2Zxuab9x0uww%3D&expires=1507013829";

    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_ID_FORM = "1";
    public static final String API_KEY = "843263d000";
    public static final String API_EXPIRES= "1506585987";
    public static String API_SIGNATURE= API_KEY+":GET:forms/"+API_ID_FORM+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+API_ID_FORM+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;

    //ARRAY CON LOS OBJETOS DE LA ENTRADA
    public List<EntryForm> listaEntradas;
    //ARRAY CON LOS OBJETOS DEL RESULTADO
    public List<String> listaResultados;


    //items de el formulario

    Button btnEnviar;
    Button btnSiguiente;
    RadioGroup rbSatiscaccion;
    TextView tvPregunta,tvMessage,tvTitle,TvPorcentaje;
    ProgressDialog progressDialog;
    public String InputType;
    public int contador;
    public ImageView img;
    ProgressBar simpleProgressBar;
    int progress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game_selector);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        tvTitle = (TextView) findViewById(R.id.tv_titulo);
        tvPregunta = (TextView) findViewById(R.id.tv_pregunta);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente) ;
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        rbSatiscaccion = (RadioGroup)findViewById(R.id.rg_opciones_satisfaccion);
        TvPorcentaje = (TextView) findViewById(R.id.tv_porcentaje);
        img = (ImageView) findViewById(R.id.ic_launcher);
        simpleProgressBar=(ProgressBar) findViewById(R.id.PbSelector); // initiate the progress bar
       /* int maxValue=simpleProgressBar.getMax(); // get maximum value of the progress bar
        int progressValue=simpleProgressBar.getProgress();*/
        simpleProgressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#80DAEB"),
                android.graphics.PorterDuff.Mode.MULTIPLY);
        simpleProgressBar.setProgress(60);
        simpleProgressBar.setMax(110);
        // simpleProgressBar.setProgress(progress);
        simpleProgressBar.setBackgroundColor(Color.GREEN);// 50 default progress value for the progress bar


        String id = "2";
        getForm2(id);
        generateTextProgressBar();
        btnSiguiente();

        rbSatiscaccion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getEntryData("2");
                Log.i("listaResultados ondestroy",String.valueOf(listaResultados));

            }
        });

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


    public void btnSiguiente() {

        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "2";
                getType(id);
                // String type = getType(id);
                Integer newProgress =  getIntent().getExtras().getInt("parametro2");
                setProgressValue(newProgress+10);
                newProgress=newProgress+10;
                progress=newProgress;

                Log.d("valor : ", getType(id));
                if(getType(id)=="radio"){
                    Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2", progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados7 = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                    Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector7.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2", progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados7 = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                    Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2", progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados7 = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    startActivityForResult(intent, 0);
                }else{
                    Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2", progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados7 = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    startActivityForResult(intent, 0);

                }
                //METODO GUARDAR DATOS DEL FORMULARIO
                com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods.UtilityMethods.saveData();
            }
        });

    }

    //METODO CONECTA CON LA API

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

        APIClientGravity.getInstance().getApi().getFormApi(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {
                        if (!GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
                            // Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            Form form = response.body();

                            String titulo = form.response.getTitle();
                            Integer contadorConvertido =  getIntent().getExtras().getInt("parametro");

                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contadorConvertido));
                            String pregunta = form.response.fields.get(contadorConvertido).label;
                            List<Form.Choice> list = form.response.fields.get(0).getChoices();

                            Log.i("lista =", String.valueOf(list.get(0)));
                            for(Form.Choice opcion : list) {
                                RadioButton nuevoRadio = crearRadioButton(opcion.getText());
                                rbSatiscaccion.addView(nuevoRadio);
                                nuevoRadio.setTextColor(WHITE);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                             /*  if(width<700 & height>1000){
                                   lp.setMargins(0, 40, 0, 0);
                               }else if(width<700 & height>1000){
                                   lp.setMargins(0, 40, 0, 0);
                               }else if(width<700 & height>1000){
                                   lp.setMargins(0, 40, 0, 0);
                               }else if(width<700 & height>1000){
                                   lp.setMargins(0, 40, 0, 0);
                               }else{
                                   lp.setMargins(0, 40, 0, 0);
                               }*/

                                //RESOLUCION PARA 5.96' PULGADAS
                                lp.setMargins(0, 40, 0, 0);

                                //METER UN IF ELSE Y DEPENDE LA RESOLUCION PONER DIFERENTES MARGENES
                                //MARGINS PARA RESOLUCION 7' O MAS
                                //lp.setMargins(0, 40, 30, 0);
                                nuevoRadio.setLayoutParams(lp);
                            }

                            RadioButton primerRadio = (RadioButton) rbSatiscaccion.getChildAt(0);
                            primerRadio.setChecked(true);


                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));


                            if(contadorConvertido == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                            }
                            //getEntryData("2");
                            contadorConvertido++;
                            contador = contadorConvertido;
                            Log.d("contador fuera del metodo getForm = ", String.valueOf(contadorConvertido));
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }

                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });

        progressDialog.show();
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------

    //METODO SELECCIONAR TIPO DE FORMULARIO

    public String getType(String id){
        super.onResume();

        //Setup ProgressDialog
        /*progressDialog = new ProgressDialog(this);
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

                        if (!GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
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
                        if (GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();

                    }

                });
        progressDialog.show();
        return "textarea";
    }

    private RadioButton crearRadioButton(String nivel) {
        RadioButton nuevoRadio = new RadioButton(this);
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(nivel);
        nuevoRadio.setTag(nivel);
        return nuevoRadio;
    }
    //---------------------------------------------------------------------------------------------------
    //METODO QUE RECOJE LOS RESULTADOS.

    protected void getEntryData(String id) {
        super.onResume();

        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("we are saving your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "2";


        APIClientGravity.getInstance().getApi().getEntryData(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {
                        if (!GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            Form form = response.body();

                            Integer contadorConvertido =  getIntent().getExtras().getInt("parametro");
                            String titulo = form.response.getTitle();
                            listaResultados  = new ArrayList<String>();

                            int radioButtonID = rbSatiscaccion.getCheckedRadioButtonId();
                            View radioButton = rbSatiscaccion.findViewById(radioButtonID);
                            int idx = rbSatiscaccion.indexOfChild(radioButton);
                            RadioButton r = (RadioButton)  rbSatiscaccion.getChildAt(idx);
                            String selectedText = r.getText().toString();

                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contadorConvertido));
                            String pregunta = form.response.fields.get(contadorConvertido).label;
                            List<Form.Choice> list = form.response.fields.get(contadorConvertido).getChoices();

                            //RECOJEMOS LA LISTA DE LA ACTIVITY 2
                            ArrayList<String> ListaResultadosConvertida ;
                            ListaResultadosConvertida= (ArrayList<String>) getIntent().getExtras().get("parametro3");
                            for(Form.Choice opcion : list) {
                                String objeto = (opcion.getValue());
                                //Log.d("listResultadosEntrada = ", objeto);
                                if(opcion.getText().equals(selectedText)){
                                    ListaResultadosConvertida.add(objeto);
                                    Log.d("listResultadosEntrada7 = ", objeto);
                                    Log.d("listaResultadosSizeFor7 = ", String.valueOf(ListaResultadosConvertida.size()));
                                }else{
                                    Log.d("listResultadosEntrada7 = ", "NO HAY OBJETOS QUE COINCIDAN");
                                }
                            }

                            Log.d("listaResultadosSizeOutFor7 = ", String.valueOf(ListaResultadosConvertida.size()));


                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));



                            //if(contador == form.response.fields.size()){
                            //btnEnviar.setVisibility(View.VISIBLE);
                            //}
                            for (int i = 0; i < ListaResultadosConvertida.size(); i++){
                                String opcion = ListaResultadosConvertida.get(i);

                                Log.d("listResultadosSalida7 = ", opcion);
                                // Objects.toString(opcion);
                            }
                            ListaResultadosConvertida.toArray();

                            contadorConvertido++;
                            contador=contadorConvertido;
                            listaResultados=ListaResultadosConvertida;
                            Log.d("contador fuera del metodo getForm = ", String.valueOf(contadorConvertido));
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }

                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivitySelector7.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });

        //Log.d("contador fuera del metodo getForm = ", String.valueOf(contador));
        progressDialog.show();

    }
    public void generateTextProgressBar(){
        TvPorcentaje.setTextSize(15);
        TvPorcentaje.setTextColor(WHITE);
        TvPorcentaje.setText("7/11");

    }
}
