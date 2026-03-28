package com.ricardo.repository;

import com.ricardo.model.Mensagem;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MensagemRepository {

    private List<Mensagem> mensagens = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Mensagem> listarTodas() {
        return mensagens;
    }

    public Optional<Mensagem> buscarPorId(Long id) {
        return mensagens.stream()
                .filter(m -> m.id.equals(id))
                .findFirst();
    }

    public Mensagem salvar(Mensagem novaMensagem) {
        novaMensagem.id = idCounter++;
        novaMensagem.timestamp = LocalDateTime.now();
        mensagens.add(novaMensagem);
        return novaMensagem;
    }

    public boolean deletar(Long id) {
        return mensagens.removeIf(m -> m.id.equals(id));
    }
}