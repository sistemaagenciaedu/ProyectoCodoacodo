package codoacodo.example.codo.service;


import codoacodo.example.codo.Entities.Usuario;


import java.util.List;

public interface UsuarioService {

    public Usuario createUsuario(Usuario usuario);
    public List<Usuario> findAllUsuario();
    public Usuario saveUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public Usuario findUsuario(Usuario usuario);
    public Usuario findUsuarioById(Long id);


}