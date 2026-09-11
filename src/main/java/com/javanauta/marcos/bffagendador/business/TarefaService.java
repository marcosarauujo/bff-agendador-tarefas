package com.javanauta.marcos.bffagendador.business;


import com.javanauta.marcos.bffagendador.business.dto.in.TarefasDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.out.TarefasDTOResponse;
import com.javanauta.marcos.bffagendador.infrastructure.client.TarefasClient;
import com.javanauta.marcos.bffagendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefaService {

    private final TarefasClient client;

    public TarefasDTOResponse gravarTarefas(String token, TarefasDTORequest dto) {
        return client.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefaAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return client.buscaListaTarefaPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefaPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        client.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
        return client.alteraStatus(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return client.updateTarefas(dto, id, token);
    }
}
