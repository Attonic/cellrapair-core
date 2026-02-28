package io.github.cellrepair.controller;

import io.github.cellrepair.config.security.AuthenticationDto;
import io.github.cellrepair.config.security.LoginResponseDto;
import io.github.cellrepair.dto.UsuarioDto;
import io.github.cellrepair.exception.ConflitoException;
import io.github.cellrepair.model.entity.Usuario;
import io.github.cellrepair.repository.UserRepository;
import io.github.cellrepair.config.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.nomeUsuario(), dto.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    //apagarDepois
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioDto dto){
        if (repository.findByNomeUsuario(dto.nomeUsuario()) != null){
            throw new ConflitoException("Nome de Usuário já cadastrado.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        Usuario newUsuario = new Usuario(dto.nomeUsuario(), encryptedPassword, dto.role());
        repository.save(newUsuario);
        return ResponseEntity.ok().build();
    }

}

