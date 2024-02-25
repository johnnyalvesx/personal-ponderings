package org.gen.personalponderings.models.validations;

public class PostagemValidator {

    public static void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo titulo é obrigatório");
        }
        if (titulo.length() <  5) {
            throw new IllegalArgumentException("O atributo titulo deve ter no mínimo 5 caracteres");
        }
    }

    public static void validarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo texto é obrigatório");
        }
        if (texto.length() <  10) {
            throw new IllegalArgumentException("O atributo texto deve ter no mínimo 10 caracteres");
        }
    }
}
