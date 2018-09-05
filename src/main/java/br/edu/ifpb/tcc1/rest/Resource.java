package br.edu.ifpb.tcc1.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("empenho")
public class Resource {

    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaJSON() {

        JSONObject json = new JSONObject();
        json.put("nome", "flavio");

        return Response
                .ok()
                .entity(json.toString())
                .build();
    }

    @GET
    @Path("/array")
    public String retornaArray() {
        return "PREVIDENCIA SOCIAL,"
                + "DESPORTO E LAZER,"
                + "EDUCACAO"
                + ",COMERCIO E SERVICOS,"
                + "ENERGIA,"
                + "DIREITOS DA CIDADANIA,"
                + "URBANISMO,"
                + "SEGURANCA PUBLICA,"
                + "CIENCIA E TECNOLOGIA,"
                + "ASSISTENCIA SOCIAL,"
                + "COMUNICACOES,"
                + "ENCARGOS ESPECIAIS,"
                + "ORGANIZACAO AGRARIA,"
                + "SAUDE,"
                + "CULTURA,"
                + "AGRICULTURA,"
                + "SANEAMENTO,"
                + "ADMINISTRACAO,"
                + "DEFESA NACIONAL,"
                + "TRABALHO,"
                + "RELACOES EXTERIORES,"
                + "GESTAO AMBIENTAL,"
                + "INDUSTRIA,"
                + "TRANSPORTE,"
                + "ESSENCIAL A JUSTICA";

    }

    @GET
    @Path("/grafico")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaGrafico() {

        Gson gson = new Gson();

        List<Teste> lista = new ArrayList<>();
        Random random = new Random();
        int[] array = new int[25];
        for (int k = 0; k < 25; k++) {
            array[k] = random.nextInt();
        }
        for (int k = 14; k <= 18; k++) {
            int ano = 2000 + k;
            lista.add(new Teste("ano " + ano, array));
        }

        return Response
                .ok()
                .entity(gson.toJson(lista))
                .build();
    }
}
