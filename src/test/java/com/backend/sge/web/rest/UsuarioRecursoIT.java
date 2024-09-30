package com.backend.sge.web.rest;


import com.backend.sge.builder.UsuarioBuilder;
import com.backend.sge.domain.Usuario;
import com.backend.sge.repository.UsuarioRepository;
import com.backend.sge.service.UsuarioService;
import com.backend.sge.service.mapper.UsuarioMapper;
import com.backend.sge.util.IntTestComum;
import com.backend.sge.util.TestUtil;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
class UsuarioRecursoIT extends IntTestComum {

    @Autowired
    private UsuarioBuilder usuarioBuilder;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private UsuarioService usuarioServico;

    @BeforeEach
    void incializar() {
        usuarioRepositorio.deleteAll();
    }

    //GET
    @Test
    void listarTest() throws Exception {
        usuarioBuilder.construir();
        getMockMvc().perform(get("/api/usuarios"))
                .andExpect(status().isOk());

    }

    @Test
    void obterPorIdTest() throws Exception {
        Usuario usuario = usuarioBuilder.construir();
        getMockMvc().perform(get("/api/usuarios/" + usuario.getId()))
                .andExpect(status().isOk());

    }


    @Test
    void salvarTest() throws Exception {
        Usuario usuario = usuarioBuilder.construirEntidade();
        usuario.setEmail("batotow@gmail.com");
        usuario.setCpf("12345678902");

        getMockMvc().perform(post("/api/usuarios")
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(usuarioMapper.toDto(usuario))))
                .andExpect(status().isCreated());
    }
}