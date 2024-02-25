package org.gen.personalponderings.models.validations;

public class TemaValidator {

    public static void validarDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("O atributo descricao é obrigatório");
        }
        if (descricao.length() <  3) {
            throw new IllegalArgumentException("O atributo descricao deve ter no mínimo 3 caracteres");
        }
    }
}
