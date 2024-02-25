package org.gen.personalponderings.models.validations;

public class UsuarioValidator {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo nome é obrigatório");
        }
        if (nome.length() <  3) {
            throw new IllegalArgumentException("O atributo nome deve ter no mínimo  3 caracteres");
        }
    }

    public static void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo email é obrigatório");
        }
        // Aqui você pode adicionar uma validação mais robusta de email, se necessário.
    }

    public static void validarSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo senha é obrigatório");
        }
        if (senha.length() <  5) {
            throw new IllegalArgumentException("O atributo senha deve ter no mínimo  5 caracteres");
        }
    }

    // Adicione métodos para validar outros campos conforme necessário.
}

