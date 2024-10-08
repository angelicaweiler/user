package com.javanauta.usuario.business.mapstruct;

import com.javanauta.usuario.business.dto.UsuarioRequestDTO;
import com.javanauta.usuario.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioUpdate {

    void updateUsuario(UsuarioRequestDTO dto, @MappingTarget UsuarioEntity entity);

}
