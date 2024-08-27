package com.javanauta.usuario.business;

import com.javanauta.usuario.business.dto.UsuarioRequestDTO;
import com.javanauta.usuario.business.dto.UsuarioResponseDTO;
import com.javanauta.usuario.business.mapstruct.UsuarioMapper;
import com.javanauta.usuario.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO request){

        return mapper.paraResponseDTO(
                repository.save(
                        mapper.paraUsuarioEntity(request)));

    }

    public List<UsuarioResponseDTO> buscaTodosUsuarios(){
        return mapper.paraListaUsuarioResponseDTO(
                repository.findAll()
        );
    }

    public UsuarioResponseDTO buscaUsuarioPorEmail(String email){
        return mapper.paraResponseDTO(
                repository.findByEmail(email));
    }

    public void deletaUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }
}
