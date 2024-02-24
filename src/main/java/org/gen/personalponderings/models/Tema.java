package org.gen.personalponderings.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "O atributo descricao é obrigatório")
    @NotBlank(message = "O atributo descricao não pode ser vazio")
    @Size(min = 3, message = "O atributo descricao deve ter no mínimo 3 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem;

    public Tema(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Tema() {
    }
}
