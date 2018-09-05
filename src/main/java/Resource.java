
import com.google.gson.Gson;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

        return "NARUTO, DBZ, ONE PIECE, BLEACH";

    }
}
