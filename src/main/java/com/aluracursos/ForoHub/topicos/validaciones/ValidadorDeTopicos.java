package com.aluracursos.ForoHub.topicos.validaciones;

import com.aluracursos.ForoHub.topicos.DatosRegistroTopicos;

import java.sql.SQLIntegrityConstraintViolationException;
public interface ValidadorDeTopicos {
    public void validar(DatosRegistroTopicos datos);
}
