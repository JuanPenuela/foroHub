package com.aluracursos.ForoHub.controller;


import com.aluracursos.ForoHub.infra.security.DatosJWTToken;
import com.aluracursos.ForoHub.infra.security.TokenService;
import com.aluracursos.ForoHub.usuarios.DatosUsuariosAuthenticatios;
import com.aluracursos.ForoHub.usuarios.Usuarios;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class AuthenticactionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    @Operation(summary = "autentica el usuario en la base de datos y genera token")
    public ResponseEntity login(@RequestBody @Valid DatosUsuariosAuthenticatios datos){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.email(),
                datos.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuarios) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));

    }

}
