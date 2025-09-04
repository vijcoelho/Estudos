package com.example.userapi.controller;

import com.example.userapi.dto.request.AlterarSenhaRequest;
import com.example.userapi.dto.request.CriarUsuarioRequest;
import com.example.userapi.dto.response.BaseResponse;
import com.example.userapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> criar(@RequestBody @Valid final CriarUsuarioRequest request) {
        return ResponseEntity.ok(usuarioService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable final String id) {
        return ResponseEntity.ok(usuarioService.get(id));
    }

    @PatchMapping
    public ResponseEntity<BaseResponse> alterar(@RequestBody @Valid final AlterarSenhaRequest request) {
        return ResponseEntity.ok(usuarioService.alterarSenha(request));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable final String id) {
        usuarioService.delete(id);
    }
}
