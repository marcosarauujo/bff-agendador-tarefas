package com.javanauta.marcos.bffagendador.infrastructure.client;


import com.javanauta.marcos.bffagendador.business.dto.in.EnderecoDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.LoginDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.TelefoneDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.UsuarioDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.javanauta.marcos.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.javanauta.marcos.bffagendador.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginDTORequest usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestHeader("Authorization") String token,
                                         @RequestBody EnderecoDTORequest dto);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);

}
