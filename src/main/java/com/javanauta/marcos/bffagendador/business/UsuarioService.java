package com.javanauta.marcos.bffagendador.business;


import com.javanauta.marcos.bffagendador.business.dto.in.EnderecoDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.LoginDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.TelefoneDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.in.UsuarioDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.javanauta.marcos.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.javanauta.marcos.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.javanauta.marcos.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO) {
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(UsuarioDTORequest dto, String token) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefonDTO, String token) {
        return client.atualizaTelefone(telefonDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(token, dto);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }

}
