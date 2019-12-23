package com.sercheo.api.say.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Path("/say")
public class SayResource {
    private static final Logger LOGGER = LogManager.getLogger(SayResource.class.getName());

    @GET
    @Counted(name = "getSayCount",
            absolute = true,
            description = "Number of times for getSay")
    @Timed(name = "getSayCountTime",
            absolute = true,
            description = "Time needed to get the properties of" +
                    "a system from the given hostname")
    @Traced(operationName = "SayResource.getSay")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSay() {
        LOGGER.info("Execute getSay");
        Jsonb jsonb = null;

        try {
            jsonb = JsonbBuilder.create();

            Map<String, String> data = new HashMap<>();
            data.put("msg", "Hello");

            return Response.ok().entity(jsonb.toJson(data)).build();
        } catch (Exception e) {
            LOGGER.error("Error executing getSay", e);
        } finally {
            try {
                if (jsonb != null) {
                    jsonb.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error close resource", e);
            }
        }

        return Response.serverError().build();
    }

    @POST
    @Path("{name}")
    @Counted(name = "postSayCount",
            absolute = true,
            description = "Number of times for getSay")
    @Timed(name = "postSayCountTime",
            absolute = true,
            description = "Time needed to get the properties of" +
                    "a system from the given hostname")
    @Traced(operationName = "SayResource.postSay")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSay(@PathParam("name") String name) {
        LOGGER.info("Execute postSay");
        Jsonb jsonb = null;

        try {
            jsonb = JsonbBuilder.create();

            Map<String, String> data = new HashMap<>();
            data.put("msg", "Hello " + name);

            return Response.ok().entity(jsonb.toJson(data)).build();
        } catch (Exception e) {
            LOGGER.error("Error executing postSay", e);
        } finally {
            try {
                if (jsonb != null) {
                    jsonb.close();
                }
            } catch (Exception e) {
                LOGGER.error("Error close resource", e);
            }
        }

        return Response.serverError().build();
    }
}
