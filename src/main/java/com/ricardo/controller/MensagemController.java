package com.ricardo.controller;

import com.ricardo.model.Mensagem;
import com.ricardo.repository.MensagemRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/mensagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MensagemController {

    @Inject
    MensagemRepository repository;

    @GET
    public Response listarTodas() {
        List<Mensagem> mensagens = repository.listarTodas();
        return Response.ok(mensagens).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Optional<Mensagem> mensagem = repository.buscarPorId(id);

        if (mensagem.isPresent()) {
            return Response.ok(mensagem.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response criar(Mensagem novaMensagem) {
        Mensagem mensagemSalva = repository.salvar(novaMensagem);
        return Response.status(Response.Status.CREATED).entity(mensagemSalva).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = repository.deletar(id);

        if (removido) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}