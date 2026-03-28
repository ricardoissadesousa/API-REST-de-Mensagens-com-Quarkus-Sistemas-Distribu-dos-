package com.ricardo.model;

import java.time.LocalDateTime;

public class Mensagem {

    public Long id;
    public String remetente;
    public String conteudo;
    public LocalDateTime timestamp;

    // Construtor vazio exigido pelo Jackson (conversor de JSON)
    public Mensagem() {
    }

    public Mensagem(Long id, String remetente, String conteudo, LocalDateTime timestamp) {
        this.id = id;
        this.remetente = remetente;
        this.conteudo = conteudo;
        this.timestamp = timestamp;
    }
}
