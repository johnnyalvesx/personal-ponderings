package org.gen.personalponderings.controllers;

import org.apache.coyote.BadRequestException;
import org.gen.personalponderings.exception.EmailAlreadyRegisteredException;
import org.gen.personalponderings.exception.InternalServerErrorException;
import org.gen.personalponderings.exception.NoContenException;
import org.gen.personalponderings.exception.ResponseMessage;
import org.gen.personalponderings.models.Usuario;
import org.gen.personalponderings.models.validations.UsuarioValidator;
import org.gen.personalponderings.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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

    //    @PostMapping("/cadastrar")
//    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
//        UsuarioValidator.validarNome(usuario.getNome());
//        UsuarioValidator.validarEmail(usuario.getEmail());
//
//        Optional<Usuario> existingEmail = repository.findByEmail(usuario.getEmail());
//        if (existingEmail.isPresent()) {
//            throw new EmailAlreadyRegisteredException("Erro, o e-mail já está cadastrado");
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
//    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        try {
            UsuarioValidator.validarNome(usuario.getNome());
            UsuarioValidator.validarEmail(usuario.getEmail());

            Optional<Usuario> existingEmail = repository.findByEmail(usuario.getEmail());
            if (existingEmail.isPresent()) {
                throw new EmailAlreadyRegisteredException("Erro, o e-mail já está cadastrado");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
        } catch (EmailAlreadyRegisteredException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (NoContenException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (InternalServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) throws BadRequestException {
        try {
            if (usuario.getNome() != null) {
                UsuarioValidator.validarNome(usuario.getNome());
            }
            if (usuario.getEmail() != null) {
                UsuarioValidator.validarEmail(usuario.getEmail());
            }
            return ResponseEntity.ok(repository.save(usuario));
        } catch (EmailAlreadyRegisteredException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (NoContenException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (InternalServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
