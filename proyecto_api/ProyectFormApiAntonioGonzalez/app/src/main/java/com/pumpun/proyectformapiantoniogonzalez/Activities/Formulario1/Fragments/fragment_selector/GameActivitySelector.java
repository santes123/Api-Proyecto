package com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_selector;

/**
 * Created by pumpun5 on 4/10/17.
 */
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AlertDialogLayout;
import android.util.Log;
import android.view.Display;
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
import android.widget.Toast;

import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_text.GameActivityText;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_radioButtons.GameActivityRadioButtons;
import com.pumpun.proyectformapiantoniogonzalez.Activities.GameActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.PlayActivity;
import com.pumpun.proyectformapiantoniogonzalez.Activities.SettingsActivity;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
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

public class GameActivitySelector extends AppCompatActivity {

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

    public ArrayList<String> listaResultados;

    //items de el formulario


    Button btnEnviar;
    Button btnSiguiente;
    RadioGroup rbSatiscaccion;
    TextView tvPregunta,tvMessage,tvTitle,TvPorcentaje;
    ProgressDialog progressDialog;
    ProgressBar simpleProgressBar;
    public String InputType;
    public Integer contador =  0;
    int progress=0;
    public ImageView img;


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
        img = (ImageView) findViewById(R.id.ic_launcher);
        simpleProgressBar=(ProgressBar) findViewById(R.id.PbSelector); // initiate the progress bar
        TvPorcentaje = (TextView) findViewById(R.id.tv_porcentaje);


        simpleProgressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#80DAEB"),
                android.graphics.PorterDuff.Mode.MULTIPLY);
        simpleProgressBar.setBackgroundColor(Color.GREEN);
        simpleProgressBar.incrementProgressBy(10);
        simpleProgressBar.setProgress(0);

        String id = "2";
        getForm(id);
        generateTextProgressBar();
        rbSatiscaccion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getEntryData("2");
                Log.i("listaResultados ondestroy",String.valueOf(listaResultados));

            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "2";
                getType(id);
                setProgressValue(progress+10);
                // String type = getType(id);

                Log.d("progress : ", String.valueOf(progress));

                if(getType(id)=="radio"){
                    Log.d("aviso : ", "Game activity radioButtons");
                    Intent intent = new Intent(v.getContext(), GameActivityRadioButtons.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2",progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="likert"){
                    Log.d("aviso : ", "Game activity Selector");
                    Intent intent = new Intent(v.getContext(), GameActivitySelector2.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2",progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    startActivityForResult(intent, 0);
                }else if(getType(id)=="textarea"){
                    Log.d("aviso : ", "Game activity Text");
                    Intent intent = new Intent(v.getContext(), GameActivityText.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2",progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    startActivityForResult(intent, 0);
                }else{
                    Log.d("aviso : ", "Game activity");
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("parametro", contador);
                    intent.putExtra("parametro2",progress);
                    intent.putStringArrayListExtra("parametro3", (ArrayList<String>) listaResultados);
                    Log.d("listResultados = ", String.valueOf((listaResultados.size())));

                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                    startActivityForResult(intent, 0);

                }
                //METODO GUARDAR DATOS DEL FORMULARIO
                com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods.UtilityMethods.saveData();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ic_launcher:

                return true;
            case R.id.about_us:

                return true;
            case R.id.how_to_play:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //METODO CONECTA CON LA API

    protected void getForm(String id) {
        super.onResume();

        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("we are loading your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "2";
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;

        APIClientGravity.getInstance().getApi().getFormApi(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {
                        if (!GameActivitySelector.this.isFinishing() && progressDialog.isShowing())
                            Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Todo correcto ", Toast.LENGTH_SHORT).show();

                            tvMessage.setText("");
                            Form form = response.body();

                            String titulo = form.response.getTitle();
                            contador =  0;
                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contador));
                            String pregunta = form.response.fields.get(contador).label;
                            List<Form.Choice> list = form.response.fields.get(contador).getChoices();

                            for(Form.Choice opcion : list) {

                                RadioButton nuevoRadio = crearRadioButton(opcion.getText());
                                rbSatiscaccion.addView(nuevoRadio);
                                nuevoRadio.setTextColor(WHITE);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                                //METER MARGENES PARA TODAS LAS RESOLUCIONES
                                //METER POR DEFECTO INGLES Y ESPAÑOL
                                //ARREGLAR EL getType
                                //ACABAR EL METODO DE VOLVER ATRAS CON EL BOTON DE ANDROID

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

                            if(contador == form.response.fields.size()){
                                btnEnviar.setVisibility(View.VISIBLE);
                            }
                            contador++;
                            Log.d("contador fuera del metodo getForm = ", String.valueOf(contador));
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }

                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivitySelector.this.isFinishing() && progressDialog.isShowing())
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
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("We are fetching user data.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        id = "2";
        APIClientGravity.getInstance().getApi().getType(Integer.valueOf(id)).enqueue(
                new Callback<Form>() {

                    @Override
                    public void onResponse(Call<Form> call,
                                           Response<Form> response) {

                        if (!GameActivitySelector.this.isFinishing() && progressDialog.isShowing())

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
                        if (GameActivitySelector.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();

                    }

                });
        progressDialog.show();
        return "likert";
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
                        if (!GameActivitySelector.this.isFinishing() && progressDialog.isShowing())
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {

                            tvMessage.setText("");
                            Form form = response.body();

                            String titulo = form.response.getTitle();
                            contador =  0;
                            listaResultados  = new ArrayList<String>();
                            Log.d("contador dentro del metodo getForm = ", String.valueOf(contador));

                            int radioButtonID = rbSatiscaccion.getCheckedRadioButtonId();
                            View radioButton = rbSatiscaccion.findViewById(radioButtonID);
                            int idx = rbSatiscaccion.indexOfChild(radioButton);
                            RadioButton r = (RadioButton)  rbSatiscaccion.getChildAt(idx);
                            String selectedText = r.getText().toString();

                            Log.d("radioValor = ", selectedText);
                            String pregunta = form.response.fields.get(contador).label;
                            List<Form.Choice> list = form.response.fields.get(contador).getChoices();




                            for(Form.Choice opcion : list) {
                                String objeto = (opcion.getValue());
                                if(opcion.getText().equals(selectedText)){
                                    listaResultados.add(objeto);
                                    Log.d("listResultadosEntrada = ", objeto);
                                    Log.d("listaResultadosSizeFor = ", String.valueOf(listaResultados.size()));
                                }else{
                                    Log.d("listResultadosEntrada = ", "NO HAY OBJETOS QUE COINCIDAN");
                                }
                            }

                            Log.d("listaResultadosSizeOutFor = ", String.valueOf(listaResultados.size()));


                            tvTitle.setText(titulo);
                            tvPregunta.setText((pregunta));

                            for (int i = 0; i < listaResultados.size(); i++){
                                String opcion = listaResultados.get(i);

                                Log.d("listResultadosSalida = ", opcion);
                            }
                            listaResultados.toArray();
                            contador++;
                            Log.d("contador fuera del metodo getForm = ", String.valueOf(contador));
                        } else {
                            tvMessage.setText("Status:" + response.code() + "\nMessage:" +
                                    response.message());
                        }

                    }
                    @Override
                    public void onFailure(Call<Form> call,
                                          Throwable t) {
                        if (GameActivitySelector.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();
                        tvMessage.setText(t.getLocalizedMessage());
                    }
                });

        progressDialog.show();
    }
    //METODO QUE GENERA LOS TEXTOS DEL PROGRESSBAR
    public void generateTextProgressBar(){
        TvPorcentaje.setTextSize(15);
        TvPorcentaje.setTextColor(WHITE);
        TvPorcentaje.setText("1/11");

    }
    //METODO QUE VUELVE ATRAS
    /*@Override
    public void onBackPressed()
    {
        super.onBackPressed();  // Invoca al método
        // Añade más funciones si fuese necesario
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Salir");
        dialogo1.setMessage("¿ Quiere salir de este formulario ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Intent intent = new Intent(GameActivitySelector.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.dismiss();
            }
        });
        dialogo1.create();
        dialogo1.show();

    }*/


}
