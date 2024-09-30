package com.backend.sge.builder;

import com.backend.sge.domain.Usuario;
import com.backend.sge.domain.dto.UsuarioDTO;
import com.backend.sge.service.UsuarioService;
import com.backend.sge.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario> {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario construirEntidade() throws ParseException {

        Usuario usuario = new Usuario();
        usuario.setNome("Luan");
        usuario.setCpf("12345678901");
        usuario.setEmail("luan.lima@maisunifacisa.com.br");
        usuario.setTelefone("40028922");
        usuario.setDataNascimento(LocalDate.of(1996, 7, 7));
        usuario.setAdm(Boolean.FALSE);

        return usuario;
    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        UsuarioDTO usuarioDTO = usuarioService.salvar(usuarioMapper.toDto(entidade));
        return usuarioMapper.toEntity(usuarioDTO);
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        return usuarioMapper.toEntity(usuarioService.listar());
    }

    @Override
    protected Usuario obterPorId(Integer id) {
        return usuarioMapper.toEntity(usuarioService.obterPorId(id));
    }
}
