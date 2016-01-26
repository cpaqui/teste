package br.com.alterdata.exemplo.cadastro;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alterdata.exemplo.modelo.Cupom;
import br.com.alterdata.exemplo.negocio.implementacoes.CupomDAOImpl;

@Path("/cupons")
@Produces(MediaType.APPLICATION_JSON)
public class EndPointCupom {

	@Inject
	private CupomDAOImpl cupomDAO;

	@GET
	public Response listarTodos () {
		return Response.ok(cupomDAO.listarTodosCompleto()).build();
	}

	@GET
	@Path("{identificacao} \\d+")
	public Response listarPorIdCompleto (@PathParam("id")Long id) {
		return Response.ok(cupomDAO.buscarPorIdCompleto(id)).build();
	}

	@POST
	public Response inserir (Cupom cupom) {
		return Response.ok(cupomDAO.inserir(cupom)).build();
	}

	@PUT
	public Response atualizar (Cupom cupom) {
		return Response.ok(cupomDAO.atualizar(cupom)).build();
	}

	@DELETE
	@Path("{id}")
	public Response excluir (@PathParam("id")Long id) {
		cupomDAO.excluir(id);

		return Response.ok().build();
	}
}
