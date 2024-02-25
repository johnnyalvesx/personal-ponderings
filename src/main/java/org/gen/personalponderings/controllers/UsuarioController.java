package org.gen.personalponderings.controllers;

import org.gen.personalponderings.exception.EmailAlreadyRegisteredException;
import org.gen.personalponderings.models.Usuario;
import org.gen.personalponderings.models.validations.UsuarioValidator;
import org.gen.personalponderings.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        UsuarioValidator.validarNome(usuario.getNome());
        UsuarioValidator.validarEmail(usuario.getEmail());

        Optional<Usuario> existingEmail = repository.findByEmail(usuario.getEmail());
        if (existingEmail.isPresent()) {
            throw new EmailAlreadyRegisteredException("Erro, o e-mail já está cadastrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
        if (usuario.getNome() != null) {
            UsuarioValidator.validarNome(usuario.getNome());
        }
        if (usuario.getEmail() != null) {
            UsuarioValidator.validarEmail(usuario.getEmail());
        }
        return ResponseEntity.ok(repository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
