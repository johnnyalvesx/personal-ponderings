package org.gen.personalponderings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Setter
@Getter
@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo titulo é obrigatório")
    @NotBlank(message = "O atributo titulo não pode ser vazio")
    @Size(min = 5, message = "O atributo titulo deve ter no mínimo 5 caracteres")
    private String titulo;

    @NotNull(message = "O atributo texto é obrigatório")
    @NotBlank(message = "O atributo texto não pode ser vazio")
    @Size(min = 10, message = "O atributo titulo deve ter no mínimo 10 caracteres")
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario usuario;

    public Postagem(long id, String titulo, String texto, Date date) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.date = date;
    }

    public Postagem() {
    }
}
