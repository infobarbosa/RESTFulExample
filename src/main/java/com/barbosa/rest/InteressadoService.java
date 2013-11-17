package com.barbosa.rest;

import java.net.URI;

import com.barbosa.model.Interessado;
import com.barbosa.dao.InteressadoDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Response;

@Path("/interessado")
public class InteressadoService {
	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Interessado obtemInteressado(@PathParam("id") Integer id){
		InteressadoDao dao = new InteressadoDao();
		Interessado interessado = dao.obtemInteressado(id);
		
		return interessado;
	}
	
	@POST
	@Consumes("application/xml")
	public Response criaInteressado(Interessado interessado){
		InteressadoDao dao = new InteressadoDao();
		dao.insereInteressado(interessado);
		
		return Response.created(URI.create("/" + interessado.getId())).build();
	}
	
	@PUT
	@Consumes("application/xml")
	public void atualizaInteressado(Interessado interessado){
		InteressadoDao dao = new InteressadoDao();
		dao.atualizaInteressado(interessado);
	}
	
	@DELETE
	@Path("{id}")
	public void excluiInteressado(@PathParam("id") Integer id){
		InteressadoDao dao = new InteressadoDao();
		dao.excluiInteressado(id);
		
	}
}
