package com.javanauta.usuario.controller;

import com.javanauta.usuario.business.UsuarioService;
import com.javanauta.usuario.business.dto.UsuarioRecord;
import com.javanauta.usuario.business.dto.UsuarioRequestDTO;
import com.javanauta.usuario.business.dto.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;


    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario(@RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(service.salvaUsuario(dto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioRecord> buscaUsuarioPorEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(service.buscaUsuarioPorEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> buscaTodosUsuarios(){
        return ResponseEntity.ok(service.buscaTodosUsuarios());
    }

    @PutMapping
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@RequestBody UsuarioRequestDTO dto,
                                                            @RequestParam("id") Long id){
        return ResponseEntity.ok(service.updateUsuario(dto, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaUsuario(@RequestParam("email") String email){
        service.deletaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

}
