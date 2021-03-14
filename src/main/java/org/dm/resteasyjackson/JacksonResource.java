package org.dm.resteasyjackson;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/resteasy-jackson/quarks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonResource {

    @GET
    public List<Quark> list() {
        return Quark.listAll();
    }

    @POST
    @Transactional
    public Quark add(Quark quark) {
        Quark q = new Quark();
        q.name = quark.name;
        q.description = quark.description;
        q.persist();

        return Quark.findById(q.id);
    }

    @DELETE
    @Transactional
    public boolean delete(Quark quark) {
        return Quark.deleteById(quark.id);
    }
}
