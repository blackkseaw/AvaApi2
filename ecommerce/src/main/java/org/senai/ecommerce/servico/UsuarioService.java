package org.senai.ecommerce.servico;

import org.senai.ecommerce.entidade.Usuario;
import org.senai.ecommerce.entidade.dto.NovoUsuario;
import org.senai.ecommerce.repositorio.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(NovoUsuario novoUsuario){
        Usuario usuario = new Usuario();
        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setPermissao(novoUsuario.getPermissao());
        String senhaCrypt = passwordEncoder.encode(novoUsuario.getSenha());
        usuario.setSenha(senhaCrypt);
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> getUsuarioAutenticacao(String email){
        return usuarioRepositorio.findByEmail(email);
    }


}
