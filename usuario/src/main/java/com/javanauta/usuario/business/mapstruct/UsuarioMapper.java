package com.javanauta.usuario.business.mapstruct;

import com.javanauta.usuario.business.dto.UsuarioRecord;
import com.javanauta.usuario.business.dto.UsuarioRequestDTO;
import com.javanauta.usuario.business.dto.UsuarioResponseDTO;
import com.javanauta.usuario.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO dto);

    UsuarioResponseDTO paraResponseDTO(UsuarioEntity entity);

    UsuarioRecord paraUsuarioRecord(UsuarioEntity entity);

    List<UsuarioResponseDTO> paraListaUsuarioResponseDTO(List<UsuarioEntity> lista);


}
