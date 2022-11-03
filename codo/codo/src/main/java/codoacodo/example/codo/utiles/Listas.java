package codoacodo.example.codo.utiles;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class Listas {
    public List<String> devolverNacionalidades() {
        List<String> listaNacionalidades = Arrays.asList(
                "Argentina",
                "Boliviana",
                "Brasileña",
                "Chilena",
                "Colombiana",
                "Costarricense",
                "Cubana",
                "Dominicana",
                "Ecuatoriana",
                "Guatemalteca",
                "Hondureña",
                "Mexicana",
                "Nicaragüense",
                "Panameña",
                "Paraguaya",
                "Peruana",
                "Puertorriqueña",
                "Salvadoreña",
                "Uruguaya",
                "Venezolana",
                "Otra"

        );
        return listaNacionalidades;
    } public List<String> devolverProvincias() {
        List<String> listaNacionalidades = Arrays.asList(
                "Ciudad Autonoma de Buenos Aires","Buenos Aires","Catamarca","Chaco","Chubut","Cordoba","Corrientes","Entre Rios","Formosa","Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquen","Rio Negro","Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucuman"
        );
        return listaNacionalidades;
    }
}
