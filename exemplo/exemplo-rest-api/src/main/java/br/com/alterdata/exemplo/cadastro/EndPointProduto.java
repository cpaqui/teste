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

import br.com.alterdata.exemplo.modelo.Produto;
import br.com.alterdata.exemplo.negocio.implementacoes.ProdutoDAOImpl;

@Path("/produtos")
@Produces(value=MediaType.APPLICATION_JSON)
public class EndPointProduto {

	@Inject
	private ProdutoDAOImpl produtoDAO;

	@GET
	public Response listarTodos () {
		return Response.ok(produtoDAO.listarTodos()).build();
	}

	@GET
	@Path("{id}")
	public Response listarTodos (@PathParam("id")Long id) {
		return Response.ok(produtoDAO.buscarPorId(id, false)).build();
	}

	@POST
	public Response inserir (Produto produto) {
		return Response.ok(produtoDAO.inserir(produto)).build();
	}

	@PUT
	public Response atualizar (Produto produto) {
		return Response.ok(produtoDAO.atualizar(produto)).build();
	}

	@DELETE
	@Path("{id}")
	public Response excluir (@PathParam("id")Long id) {
		produtoDAO.excluir(id);

		return Response.ok().build();
	}
}
