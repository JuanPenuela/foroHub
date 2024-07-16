package com.aluracursos.ForoHub.infra.manejoErrores;

public class ValidacionDeIntegridad extends RuntimeException{

    public ValidacionDeIntegridad(String s) {
        super(s);
    }

}
