package com.backend.sge.service.mapper;

import com.backend.sge.domain.Usuario;
import com.backend.sge.domain.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

}

