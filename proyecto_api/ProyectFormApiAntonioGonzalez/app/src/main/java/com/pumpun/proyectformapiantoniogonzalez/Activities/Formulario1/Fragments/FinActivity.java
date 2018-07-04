package com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments;

/**
 * Created by pumpun5 on 5/10/17.
 */

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.pumpun.proyectformapiantoniogonzalez.Activities.Formulario1.Fragments.fragment_selector.GameActivitySelector7;
import com.pumpun.proyectformapiantoniogonzalez.Activities.PlayActivity;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Rest.APIClientGravity;
import com.pumpun.proyectformapiantoniogonzalez.MainActivity;
import com.pumpun.proyectformapiantoniogonzalez.POJO.EntryForm;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Form;
import com.pumpun.proyectformapiantoniogonzalez.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinActivity extends AppCompatActivity {
    final Context context = this;
    //ARRAY CON LOS OBJETOS DEL RESULTADO
    public List<String> listaResultados;
    ProgressDialog progressDialog;
    public List<EntryForm.Entry> lista;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        //String id = "2";

        EntryForm formulario = new EntryForm();
        EntryForm.Response response = new EntryForm.Response();
        EntryForm.Entry entry = new EntryForm.Entry();
        ArrayList<String> ListaResultadosConvertida ;
        ListaResultadosConvertida= (ArrayList<String>) getIntent().getExtras().get("parametro3");

        mostrarDatos();
        entry.set1(ListaResultadosConvertida.get(0));
        entry.set2(ListaResultadosConvertida.get(1));
        entry.set3(ListaResultadosConvertida.get(2));
        entry.set4(ListaResultadosConvertida.get(3));
        entry.set5(ListaResultadosConvertida.get(4));
        entry.set6(ListaResultadosConvertida.get(5));
        entry.set7(ListaResultadosConvertida.get(6));
        entry.set8(ListaResultadosConvertida.get(7));
        entry.set9(ListaResultadosConvertida.get(8));
        entry.set10(ListaResultadosConvertida.get(9));
        entry.set11(ListaResultadosConvertida.get(10));
        entry.setId("8");
       /* entry.setFormId(id);
        entry.setDateCreated( FechaHora());
        entry.setIsStarred(0);
        entry.setIsRead(0);
        entry.setIp("192.168.0.1");
        entry.setSourceUrl("Android View");
        entry.setPostId("null");
        entry.setCurrency("EUR");
        entry.setPaymentStatus(null);
        entry.setPaymentDate(null);
        entry.setTransactionId(null);
        entry.setPaymentAmount(null);
        entry.setPaymentMethod(null);
        entry.setIsFulfilled(null);
        entry.setCreatedBy("2");
        entry.setTransactionType(null);
        entry.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        entry.setStatus("active");*/


        lista = new ArrayList<EntryForm.Entry>();

        lista.add(entry);
        response.setTotalCount("2");
        formulario.setResponse(response);

        response.setEntries(lista);
       formulario.setResponse(response);




        PostEntry(formulario);
        cargarFin();

    }
    private void mostrarDatos() {
        ArrayList<String> ListaResultadosConvertida ;
        ListaResultadosConvertida= (ArrayList<String>) getIntent().getExtras().get("parametro3");

        Log.d("posicion0 = ", ListaResultadosConvertida.get(0));
        Log.d("posicion1 = ", ListaResultadosConvertida.get(1));
        Log.d("posicion2 = ", ListaResultadosConvertida.get(2));
        Log.d("posicion3 = ", ListaResultadosConvertida.get(3));
        Log.d("posicion4 = ", ListaResultadosConvertida.get(4));
        Log.d("posicion5 = ", ListaResultadosConvertida.get(5));
        Log.d("posicion6 = ", ListaResultadosConvertida.get(6));
        Log.d("posicion7 = ", ListaResultadosConvertida.get(7));
        Log.d("posicion8 = ", ListaResultadosConvertida.get(8));
        Log.d("posicion9 = ", ListaResultadosConvertida.get(9));
        Log.d("posicion10 = ", ListaResultadosConvertida.get(10));
        Log.d("Tamaño = ", String.valueOf(ListaResultadosConvertida.size()));

    }
    private void PostEntry(EntryForm form) {

        super.onResume();

        //Setup ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("we are sending your form.");
        progressDialog.setCancelable(false);
        progressDialog.show();
       // id = "2";

       

        ArrayList<String> ListaResultadosConvertida ;
        ListaResultadosConvertida= (ArrayList<String>) getIntent().getExtras().get("parametro3");

        //OBJETO ENTRY

        form = new EntryForm();
        EntryForm.Response response = new EntryForm.Response();
        EntryForm.Entry entry = new EntryForm.Entry();
        entry.set1(ListaResultadosConvertida.get(0));
        entry.set2(ListaResultadosConvertida.get(1));
        entry.set3(ListaResultadosConvertida.get(2));
        entry.set4(ListaResultadosConvertida.get(3));
        entry.set5(ListaResultadosConvertida.get(4));
        entry.set6(ListaResultadosConvertida.get(5));
        entry.set7(ListaResultadosConvertida.get(6));
        entry.set8(ListaResultadosConvertida.get(7));
        entry.set9(ListaResultadosConvertida.get(8));
        entry.set10(ListaResultadosConvertida.get(9));
        entry.set11(ListaResultadosConvertida.get(10));
        entry.setId("8");
       /* entry.setFormId(id);
        entry.setDateCreated( FechaHora());
        entry.setIsStarred(0);
        entry.setIsRead(0);
        entry.setIp("192.168.0.1");
        entry.setSourceUrl("Android View");
        entry.setPostId("null");
        entry.setCurrency("EUR");
        entry.setPaymentStatus(null);
        entry.setPaymentDate(null);
        entry.setTransactionId(null);
        entry.setPaymentAmount(null);
        entry.setPaymentMethod(null);
        entry.setIsFulfilled(null);
        entry.setCreatedBy("2");
        entry.setTransactionType(null);
        entry.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        entry.setStatus("active");*/

        lista = new ArrayList<EntryForm.Entry>();

        //lista.toArray();
       // Log.i("lista antes", String.valueOf(lista.get(0)));
        lista.add(entry);
       // Log.i("lista despues", String.valueOf(lista.get(0)));
        response.setEntries(lista);
        response.setTotalCount("2");
        form.setResponse(response);

        com.google.gson.JsonObject jsonObj = new JsonObject();


        jsonObj.addProperty("input_1",  ListaResultadosConvertida.get(0));
        jsonObj.addProperty("input_2", ListaResultadosConvertida.get(1));
        jsonObj.addProperty("input_3", ListaResultadosConvertida.get(2));
        jsonObj.addProperty("input_4", ListaResultadosConvertida.get(3));
        jsonObj.addProperty("input_5", ListaResultadosConvertida.get(4));
        jsonObj.addProperty("input_6", ListaResultadosConvertida.get(5));
        jsonObj.addProperty("input_7", ListaResultadosConvertida.get(6));
        jsonObj.addProperty("input_8",  ListaResultadosConvertida.get(7));
        jsonObj.addProperty("input_9", ListaResultadosConvertida.get(8));
        jsonObj.addProperty("input_10", ListaResultadosConvertida.get(9));
        jsonObj.addProperty("input_11",  ListaResultadosConvertida.get(10));


        /*jsonObj.addProperty("input_1_1", "glikertcol18e2d9b61:glikertrow51c4376b");
        jsonObj.addProperty("input_2_1", "glikertcol22f175ea0:glikertrow0b653ea6");
        jsonObj.addProperty("input_3_1", "glikertcol3a3c2e727:glikertrow3a40ea1b");
        jsonObj.addProperty("input_4_1", "glikertcol481ae5bde:glikertrow3bb4244d");
        jsonObj.addProperty("input_5_1", "glikertcol5d5c524ef:glikertrowfd13056b");
        jsonObj.addProperty("input_6_1", "glikertcol6f92fa90a:glikertrow7f777094");
        jsonObj.addProperty("input_7_1", "glikertcol79fd23df7:glikertrowb7e2542b");
        jsonObj.addProperty("input_1", "texto:glikertrow87cea2f3");
        jsonObj.addProperty("input_9_1", "glikertrow87cea2f3:glikertrow958cf89f");
        jsonObj.addProperty("input_10_1","gsurvey104851f552:glikertrowb26b3ca7");
        jsonObj.addProperty("input_2",  "texto2:glikertrowf6afee32");*/

        /*jsonObj.addProperty("input_1", "glikertcol18e2d9b61");
        jsonObj.addProperty("input_2", "glikertcol22f175ea0");
        jsonObj.addProperty("input_3", "glikertcol3a3c2e727");
        jsonObj.addProperty("input_4", "glikertcol481ae5bde");
        jsonObj.addProperty("input_5", "glikertcol5d5c524ef");
        jsonObj.addProperty("input_6", "glikertcol6f92fa90a");
        jsonObj.addProperty("input_7", "glikertcol79fd23df7");
        jsonObj.addProperty("input_8", "texto");
        jsonObj.addProperty("input_9", "glikertrow87cea2f3");
        jsonObj.addProperty("input_10","gsurvey104851f552");
        jsonObj.addProperty("input_11",  "texto2");*/

        JsonObject json = new JsonObject();
        json.add("input_values", jsonObj);


       // ------------------------------------------------------------------------------------------------------------------------

       /* APIClientGravity.getInstance().getApi().postEntry(Integer.valueOf(id),formulario).enqueue(*/
                APIClientGravity.getInstance().getApi().postEntry(json).enqueue(
                new Callback<EntryForm>() {

                    @Override
                    public void onResponse(Call<EntryForm> call,
                                           Response<EntryForm> response) {
                        if (!FinActivity.this.isFinishing() && progressDialog.isShowing())
                            Toast.makeText(getApplicationContext(), "Status : Objetos obtenidos ", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Status : Objetos enviados ", Toast.LENGTH_SHORT).show();

                            EntryForm form = response.body();
                            form.response.setEntries(lista);
                            form.response.setTotalCount(form.response.getTotalCount()+1);


                            }else {
                            Toast.makeText(getApplicationContext(), "Status : algo ha fallado en el response ", Toast.LENGTH_SHORT).show();

                        }

                        }


                    @Override
                    public void onFailure(Call<EntryForm> call,
                                          Throwable t) {
                        if (FinActivity.this.isFinishing() && progressDialog.isShowing())
                            progressDialog.dismiss();

                    }
                });

        progressDialog.show();
    }
    public String FechaHora()

    {
        //Fecha actual en formato completo:
        //Tue Sep 23 01:18:48 CEST 2014
        Date fechaActual = new Date();

        //Formateando la fecha:
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        //Fecha actual desglosada:
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        String fechaDeHoy = String.valueOf(año+mes+dia+hora+minuto+segundo);
        return fechaDeHoy;

    }
    public void cargarFin(){
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonBack);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(v.getContext(), PlayActivity.class);
                startActivityForResult(intent, 0);

            }
        });
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        dialog.show();
    }
}