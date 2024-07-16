package com.aluracursos.ForoHub.usuarios;

import jakarta.validation.constraints.NotBlank;
public record DatosUsuariosAuthenticatios(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
