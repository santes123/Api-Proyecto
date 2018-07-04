package com.pumpun.proyectformapiantoniogonzalez.Global_Variables;

import java.io.Serializable;

/**
 * Created by pumpun5 on 4/10/17.
 */

public class GlobalVariables implements Serializable {

    public static int contador;

    public int getContador(){
        return contador;
    }
    public void setContador(int contador){
        this.contador=contador;
    }


    public static final String API_BASE_URL = "http://evaluartes.com/gravityformsapi/";
    public static final String API_KEY = "843263d000";
    public static final String FORM_ID="";
    public static final String PRIVATE_KEY="843263d000";
    public static final String API_EXPIRES= "";



    public static String API_SIGNATURE= API_KEY+":GET:forms/"+FORM_ID+"/submisions:"+API_EXPIRES;

    public static String URL_FINAL = API_BASE_URL+"forms/"+FORM_ID+"/?"+API_KEY+API_SIGNATURE+API_EXPIRES;

    public static final String API_OAUTH_REDIRECT = "https://futurestud.io://callback";
}
