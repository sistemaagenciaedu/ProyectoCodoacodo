package codoacodo.example.codo.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncriptarPassword {

    public static String encriptarPassword(String pass){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }
}
