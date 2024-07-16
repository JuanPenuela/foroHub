package com.aluracursos.ForoHub.topicos.validaciones;


import com.aluracursos.ForoHub.infra.manejoErrores.ValidacionDeIntegridad;
import com.aluracursos.ForoHub.topicos.DatosRegistroTopicos;
import com.aluracursos.ForoHub.topicos.TopicosRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;

@Component
public class TopicosDuplicados implements ValidadorDeTopicos{
    @Autowired
    TopicosRepository topicosRepository;

    @Override
    public void validar(DatosRegistroTopicos datos) {
        var topicoDuplicado = topicosRepository.findByTituloAndMensaje(datos.titulo(),datos.mensaje());

        if (topicoDuplicado.isPresent()){
            throw new ValidacionDeIntegridad("No se puede registrar un Topico Duplicado (ya existe un topico con ese nombre o mensaje.)");
        }

    }
}
