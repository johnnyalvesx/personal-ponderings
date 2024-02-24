package org.gen.personalponderings.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo nome é obrigatório")
    @Size(min = 5, max = 100, message = "O atributo nome deve ter no mínimo 05 e no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "O atributo usuário é obrigatório")
    @NotBlank(message = "O atributo usuário não pode ser vazio")
    @Email(message = "O atributo usuário deve ser um email")
    private String usuario;

    @NotNull(message = "O atributo senha é obrigatório")
    @Size(min = 5, message = "O atributo senha deve ter no mínimo 5 caracteres")
    private String senha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    public Usuario(long id, String nome, String usuario, String senha, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {
    }
}
