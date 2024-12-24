package org.example.excepciones;

public class OpcionInvalida extends Exception {
    public OpcionInvalida(String mensaje) {
        super(mensaje);
    }
}