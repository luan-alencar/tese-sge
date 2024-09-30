package com.backend.sge.service;

import com.backend.sge.domain.Usuario;
import com.backend.sge.domain.dto.UsuarioDTO;
import com.backend.sge.repository.UsuarioRepository;
import com.backend.sge.service.exceptions.RegraNegocioException;
import com.backend.sge.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    public UsuarioDTO obterPorId(Integer id) {
        Usuario usuario = obter(id);
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        validarEmail(usuarioDTO);
        validarCpf(usuarioDTO);

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(UUID.randomUUID().toString()); // Gera uma chave única para o usuário
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO) {
        validarEmail(usuarioDTO);
        validarCpf(usuarioDTO);

        Usuario usuarioSalvo = obter(usuarioDTO.getId());
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChave(usuarioSalvo.getChave()); // Mantém a chave do usuário original
        usuarioRepositorio.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    public void remover(Integer id) {
        Usuario usuario = obter(id);
        usuarioRepositorio.delete(usuario);
    }

    private Usuario obter(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
    }

    private void validarEmail(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepositorio.findByEmail(usuarioDTO.getEmail());
        if(usuario != null && !usuario.getId().equals(usuarioDTO.getId())) {
            throw new RegraNegocioException("Email já cadastrado");
        }
    }

    private void validarCpf(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepositorio.findByCpf(usuarioDTO.getCpf());
        if(usuario != null && !usuario.getId().equals(usuarioDTO.getId())) {
            throw new RegraNegocioException("CPF já cadastrado");
        }
    }
}
