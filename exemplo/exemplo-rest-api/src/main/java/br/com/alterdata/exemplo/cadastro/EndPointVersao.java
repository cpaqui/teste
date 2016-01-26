package br.com.alterdata.exemplo.cadastro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/")
public class EndPointVersao {

	@GET
	@Path("versao")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response versao () {
		JSONObject versao = new JSONObject();

		versao.put("versao", "1.0.0");

		return Response.ok(versao.toString()).build();
	}
}
