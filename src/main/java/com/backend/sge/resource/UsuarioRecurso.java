package com.backend.sge.resource;


import com.backend.sge.domain.dto.UsuarioDTO;
import com.backend.sge.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {

    private final UsuarioService usuarioServico;

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> usuarios = usuarioServico.listar();
        return ResponseEntity.ok(usuarios);
    }

    // Obter usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterPorId(@PathVariable Integer id) {
        UsuarioDTO usuarioDTO = usuarioServico.obterPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    // Salvar um novo usuário
    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // Editar um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editar(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id); // Assegura que o ID corresponde ao usuário a ser editado
        UsuarioDTO usuarioEditado = usuarioServico.editar(usuarioDTO);
        return ResponseEntity.ok(usuarioEditado);
    }

    // Remover um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        usuarioServico.remover(id);
        return ResponseEntity.noContent().build();
    }
}

