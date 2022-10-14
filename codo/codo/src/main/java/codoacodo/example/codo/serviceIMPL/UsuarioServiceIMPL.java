package codoacodo.example.codo.serviceIMPL;


import codoacodo.example.codo.Entities.Usuario;
import codoacodo.example.codo.repositories.UsuarioRepository;
import codoacodo.example.codo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UsuarioServiceIMPL implements UsuarioService, UserDetailsService {
    @Autowired
    private UsuarioRepository ur;
    @Override
    public Usuario createUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> findAllUsuario() {
        return (List<Usuario>)ur.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return ur.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        ur.delete(usuario);
    }

    @Override
    public Usuario findUsuario(Usuario usuario) {
        return ur.findById(usuario.getId()).orElse(null);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return ur.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Usuario usuario=ur.findByUsername(username);
     if (usuario==null){
      throw new UsernameNotFoundException(username);
      }
     var role=new ArrayList<GrantedAuthority>();
     role.add(new SimpleGrantedAuthority(usuario.getPermisos()));
        return new User(usuario.getUsername(), usuario.getClave(), role);
    }
}
