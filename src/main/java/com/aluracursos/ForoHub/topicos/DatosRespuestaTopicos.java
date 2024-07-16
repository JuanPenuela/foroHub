package com.aluracursos.ForoHub.topicos;

public record DatosRespuestaTopicos(
        String titulo,
        String mensaje,
        String autor,
        String curso
) {

    public DatosRespuestaTopicos(Topicos datos) {
        this(datos.getTitulo(),datos.getMensaje(), datos.getAutor(), datos.getCurso());
    }

}
