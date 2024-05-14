package br.com.fiap.fiapcap3calorieCalculator.service;

import br.com.fiap.fiapcap3calorieCalculator.dto.UsuarioCadastroDTO;
import br.com.fiap.fiapcap3calorieCalculator.dto.UsuarioExibicaoDTO;
import br.com.fiap.fiapcap3calorieCalculator.exception.UsuarioNaoEncontradoException;
import br.com.fiap.fiapcap3calorieCalculator.model.Usuario;
import br.com.fiap.fiapcap3calorieCalculator.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuariodto){
        String senhaCriptografada = new
                BCryptPasswordEncoder().encode(usuariodto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuariodto, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioExibicaoDTO(usuarioSalvo);
    }

    public UsuarioExibicaoDTO buscarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não existe!");
        }
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }
    }

    public Usuario atualizar(Usuario usuario){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(usuario.getUsuarioId());

        if (usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado!");
        }
    }

}
