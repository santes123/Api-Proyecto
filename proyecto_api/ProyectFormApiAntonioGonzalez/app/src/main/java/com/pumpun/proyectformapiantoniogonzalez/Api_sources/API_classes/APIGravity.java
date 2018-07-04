package com.pumpun.proyectformapiantoniogonzalez.Api_sources.API_classes;

/**
 * Created by pumpun5 on 4/10/17.
 */

import com.google.gson.JsonObject;
import com.pumpun.proyectformapiantoniogonzalez.Api_sources.Methods.UtilityMethods;
import com.pumpun.proyectformapiantoniogonzalez.POJO.EntryForm;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Form;
import com.pumpun.proyectformapiantoniogonzalez.POJO.Formulario;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;

import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.API_KEY;
import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.FORM_ID;
import static com.pumpun.proyectformapiantoniogonzalez.Global_Variables.GlobalVariables.PRIVATE_KEY;

/**
 * Created by pumpun5 on 28/9/17.
 */

public interface APIGravity {



    long timestamp = System.currentTimeMillis()/1000;
    long expires = timestamp + 10000;
    //String signature = UtilityMethods.HmacSha1Signature.calculateRFC2104HMAC(API_KEY + ":POST:forms/" + FORM_ID + "/submissions:" + timestamp, PRIVATE_KEY);




    //METODOS CON LA URL A PELO
    // ---------------------------------------------------------------------------------------------------------------------------------------------


    @retrofit2.http.GET("forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getType(@retrofit2.http.Path("id") Integer id);

    @retrofit2.http.GET("forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getFormApi(@retrofit2.http.Path("id") Integer id);

    @retrofit2.http.GET("forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getEntryData(@retrofit2.http.Path("id") Integer id);

    //POST ENTRY
    @retrofit2.http.POST("forms/2/submissions/?api_key=843263d000&signature=QmdP%2Blkpr8XsUURpOLYW1nSo1HE%3D&expires=1508139861")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<EntryForm> postEntry(@Body JsonObject form);



    //METODOS A HACER CON LOS METODOS DE HMAC
   // ---------------------------------------------------------------------------------------------------------------------------------------------


    /*
    //GET TIPO DE FORMULARIO(LINKZ,SURVEY,RADIO...)
    @retrofit2.http.GET("forms/{id}/?api_key="+API_KEY+"&signature="+signature+"&expires="+expires)
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getType2(@retrofit2.http.Path("id") Integer id);

    //GET RESPUESTA A RELLENAR EN LA APP
    @retrofit2.http.GET("forms/{id}/?api_key="+API_KEY+"&signature="+signature+"&expires="+expires)
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getFormApi2(@retrofit2.http.Path("id") Integer id);

    //GET RESPUESTAS A PASAR AL POST
    @retrofit2.http.GET("forms/{id}/?api_key="+API_KEY+"&signature="+signature+"&expires="+expires)
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Form> getEntryData2(@retrofit2.http.Path("id") Integer id);

    //POST ENTRY
    @retrofit2.http.POST("forms/2/submissions/?api_key="+API_KEY+"&signature="+signature+"&expires="+expires)
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<EntryForm> postEntry2(@Body JsonObject form);
    */





















    //METODOS ANTERIORES,REFERENCIAS

    //GET
    //http://evaluartes.com/gravityformsapi/forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868
    //POST
    //http://evaluartes.com/gravityformsapi/forms/2/entries/?api_key=843263d000&signature=V%2FEYZIzR%2F0421QFcegg1AX2iVGE%3D&expires=1508137605

    //POST ENTRY
    //https://evaluartes.com/gravityformsapi/forms/FORM_ID/submissions?api_key=APIKEY&signature=SIGNATURE=&expires=EXPIRES
    //http://evaluartes.com/gravityformsapi/forms/2/submissions/?api_key=843263d000&signature=QmdP%2Blkpr8XsUURpOLYW1nSo1HE%3D&expires=1508139861


    @retrofit2.http.GET("forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Formulario> getForm(@retrofit2.http.Path("id") Integer id);
/*
    @retrofit2.http.GET("forms/{id}/?api_key=843263d000&signature=4YdGYhCljbhMYUSmLby8Y98%2FI1I%3D&expires=1507875868")
    @Headers({"Content-Type:application/json","Accept: application/json"})
    Call<Formulario> getForm2(@retrofit2.http.Path("id") Integer id);*/
}

