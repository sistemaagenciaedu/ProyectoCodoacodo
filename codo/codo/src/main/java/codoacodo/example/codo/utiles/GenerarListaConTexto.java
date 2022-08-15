package codoacodo.example.codo.utiles;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenerarListaConTexto {
    public List<String>generarLista(String texto){
        List <String> lista=new ArrayList<>();
        String palabra="";
        for (int i = 0; i < texto.length(); i++) {
            String letra= String.valueOf(texto.charAt(i));
            if (!letra.equals(",")){
                palabra=palabra+letra;
            }else{
                lista.add(palabra);
                palabra="";
            }
        }
        return lista;
    }
}
