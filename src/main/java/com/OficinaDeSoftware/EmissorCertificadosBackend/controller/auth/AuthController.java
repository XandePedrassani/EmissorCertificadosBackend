package com.OficinaDeSoftware.EmissorCertificadosBackend.controller.auth;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.ErrorDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Auth")
@RequestMapping(value = "/api/auth", produces = {"application/json"})
public class AuthController {

    @Operation(summary = "Realiza a autenticação do usuario", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario autenticado com sucesso!", content = {@Content(schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "Acesso não autorizado!", content = {@Content(schema = @Schema(implementation = ErrorDto.class))})
    })

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody UserDto userDto) {
        // Lógica para realizar o signIn sem autenticação
        // Aqui você pode configurar o usuário conforme necessário
        // userDto.setAccessToken(...) - Se necessário gerar um token manualmente
        return ResponseEntity.ok(userDto);
    }
}
