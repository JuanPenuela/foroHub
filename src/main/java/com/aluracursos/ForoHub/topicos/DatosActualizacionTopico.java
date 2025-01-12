package com.aluracursos.ForoHub.topicos;

import jakarta.validation.constraints.NotBlank;
public record DatosActualizacionTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
