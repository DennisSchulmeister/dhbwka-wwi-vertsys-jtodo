/*
 * Copyright © 2019 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.jtodo.tasks.rest;

import dhbwka.wwi.vertsys.javaee.jtodo.tasks.ejb.TaskBean;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.jtodo.tasks.jpa.TaskStatus;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Minimaler REST-Webservice zum Auslesen von Aufgaben. Kann nur aufgerufen
 * werden, wenn der Client sich via "HTTP Basic Auth" authentifizieren kann.
 */
@Path("task")
@Consumes("application/json")
@Produces("application/json")
public class TaskRestWebservice {
    
    @EJB
    private TaskBean taskBean;
    
    @GET
    @Path("/ByUsername/{username}/")
    public List<Task> findByUsername(@PathParam("username") String username) {
        return this.taskBean.findByUsername(username);
    }
    
    @GET
    @Path("/Search/")
    public List<Task> search(
            @QueryParam("search") String search,
            @QueryParam("category") Category category,
            @QueryParam("status") TaskStatus status) {
        return this.taskBean.search(search, category, status);
    }
    
}
