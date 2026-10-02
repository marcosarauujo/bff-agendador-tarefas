package com.javanauta.marcos.bffagendador.business;


import com.javanauta.marcos.bffagendador.business.dto.out.TarefasDTOResponse;
import com.javanauta.marcos.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EmailService {

    private final EmailClient client;

    public void enviarEmail (TarefasDTOResponse dtoResponse) {
        client.enviarEmail(dtoResponse);
    }

}
