package com.example.userapi.service;

import com.example.userapi.dto.request.AlterarSenhaRequest;
import com.example.userapi.dto.request.CriarUsuarioRequest;
import com.example.userapi.dto.response.BaseResponse;
import com.example.userapi.entity.Usuario;
import com.example.userapi.mapper.UsuarioMapper;
import com.example.userapi.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public BaseResponse criar(final CriarUsuarioRequest request) {
        if (Objects.isNull(request)) {
            return new BaseResponse(
                    "Request esta nulo.",
                    HttpStatus.NO_CONTENT,
                    null);
        }

        final Usuario usuario = UsuarioMapper.map(request);
        usuario.setData(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return new BaseResponse(
                "Usuario criado com sucesso!",
                HttpStatus.CREATED,
                usuario);
    }

    public BaseResponse get(final String id) {
        return new BaseResponse(
                "Achou!!!",
                HttpStatus.FOUND,
                usuarioRepository.findById(id));
    }

    public BaseResponse alterarSenha(final AlterarSenhaRequest request) {
        if (Objects.isNull(request)) {
            return new BaseResponse(
                    "Request esta nulo.",
                    HttpStatus.NO_CONTENT,
                    null);
        }

        final Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado."));

        usuario.setSenha(request.novaSenha());
        usuarioRepository.save(usuario);

        return new BaseResponse(
                "Senha alterada com sucesso.",
                HttpStatus.ACCEPTED,
                usuario);
    }

    public void delete(final String id) {
        usuarioRepository.deleteById(id);
    }
}




































