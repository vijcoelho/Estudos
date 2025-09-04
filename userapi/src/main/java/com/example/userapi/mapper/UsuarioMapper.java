package com.example.userapi.mapper;

import com.example.userapi.dto.request.CriarUsuarioRequest;
import com.example.userapi.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuario map(final CriarUsuarioRequest request) {
        return new Usuario(
                request.nome(),
                request.email(),
                request.senha(),
                request.idade());
    }

}

