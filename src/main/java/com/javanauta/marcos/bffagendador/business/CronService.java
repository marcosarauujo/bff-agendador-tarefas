package com.javanauta.marcos.bffagendador.business;

import com.javanauta.marcos.bffagendador.business.dto.in.LoginDTORequest;
import com.javanauta.marcos.bffagendador.business.dto.out.TarefasDTOResponse;
import com.javanauta.marcos.bffagendador.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j

public class CronService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");

        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);

        List<TarefasDTOResponse> listaTarefas = tarefaService.buscaTarefaAgendadasPorPeriodo(
                horaAtual,horaFutura, token);
        log.info("Tarefas encontradas" + listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviarEmail(tarefa);
            log.info("email enviado para o usuario " + tarefa.getEmailUsuario());
            tarefaService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);
        });
        log.info("finalizada a busca e notificação de tarefas");
    }

    public String login(LoginDTORequest dto) {
        return usuarioService.loginUsuario(dto);
    }

    public LoginDTORequest converterParaRequestDTO() {
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
