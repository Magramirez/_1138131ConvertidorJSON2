package com.edu.mx.practica.uno.gui;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class Convertidor {

    String cadena;

    public String convertidorJAVA(String texto) {
        try {
            Gson gson = new Gson();
            cadena = gson.toJson(texto);
        }
        catch (Exception e) {
            cadena = "no";
        }
        finally {
            return cadena;
        }
    }

    public String convertidorXML(String texto) {
        try {
            JSONObject xml = XML.toJSONObject(texto);
            cadena = xml.toString();
        }
        catch (Exception e) {
            cadena = "no";
        }
        finally {
            return cadena;
        }
    }
}


//otras maneras de intentar hacer el codigo


/* public class Convertidor {
    //metodo para convertir calse a json

    public String convertidorClase(String clase){
        JSONObject xmlJson = XML.toJSONObject(clase);
        String json = xmlJson.toString();

        return json;

    }

    public String convertirXml(String sml , int var)
    {
        //String Cadena ,xml = "";
        JSONObject jsoObject = org.json.XML.toJSONObject(sml);
        String cadena = jsoObject.toString(var);
        return cadena;
    }
}


*/