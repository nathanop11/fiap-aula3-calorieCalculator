package br.com.fiap.fiapcap3calorieCalculator.controller;

import br.com.fiap.fiapcap3calorieCalculator.config.security.TokenService;
import br.com.fiap.fiapcap3calorieCalculator.dto.LoginDTO;
import br.com.fiap.fiapcap3calorieCalculator.dto.TokenDTO;
import br.com.fiap.fiapcap3calorieCalculator.dto.UsuarioCadastroDTO;
import br.com.fiap.fiapcap3calorieCalculator.dto.UsuarioExibicaoDTO;
import br.com.fiap.fiapcap3calorieCalculator.model.Usuario;
import br.com.fiap.fiapcap3calorieCalculator.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.email(),
                        usuarioDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){

        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = userService.salvarUsuario(usuarioCadastroDTO);

        return ResponseEntity.ok(usuarioSalvo);

    }
}
