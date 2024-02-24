package org.gen.personalponderings.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    private String email;

    @NotNull(message = "O atributo senha é obrigatório")
    @Size(min = 5, message = "O atributo senha deve ter no mínimo 5 caracteres")
    private String senha;

    private String foto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagem> postagem;

    public Usuario(long id, String nome, String email, String senha, String foto, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {
    }
}
