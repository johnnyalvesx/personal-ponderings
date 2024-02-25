package org.gen.personalponderings.models.validations;

public class UsuarioValidator {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo nome é obrigatório");
        }
        if (nome.length() <  3) {
            throw new IllegalArgumentException("O atributo nome deve ter no mínimo 3 caracteres");
        }
    }

    public static void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo email é obrigatório");
        }
    }
}
