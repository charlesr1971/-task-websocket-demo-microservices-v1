package cpp.context.work.management.proxy.taskapiservice.api;

import cpp.context.work.management.proxy.taskapiservice.domain.request.CreateTaskRequest;
import cpp.context.work.management.proxy.taskapiservice.domain.request.UpdateTaskRequest;
import cpp.context.work.management.proxy.taskapiservice.domain.response.CreateTaskResponse;
import cpp.context.work.management.proxy.taskapiservice.domain.response.DeleteTaskResponse;
import cpp.context.work.management.proxy.taskapiservice.domain.response.UpdateTaskResponse;
import cpp.context.work.management.proxy.taskapiservice.service.TaskService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

/**
 *
 * @author betrand.ugorji1
 */
@Path("task")
@Stateless
public class TaskController {

    @Inject
    private TaskService service;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("")
    public Response createTask(CreateTaskRequest request) {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "POST Create task: " + request);

        CreateTaskResponse response = null;
        try {
            response = service.createTask(request);
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "POST Create task response " + response);
            return Response.ok(response).build();
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return Response.status(404, e.getMessage()).build();
            }
        }

        return Response.serverError().build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{taskId}")
    public Response getTaskById(@PathParam("taskId") String taskId) {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "GET task /task/" + taskId);

        CreateTaskResponse response;
        try {
            response = service.getTaskById(taskId);
            if (response == null) {
                return Response
                        .status(404)
                        .entity(Entity.entity("Not Found Task with Id " + taskId, MediaType.APPLICATION_JSON_TYPE))
                        .build();
            } else {
                Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "GET task response " + response);
                return Response.ok(response).build();
            }
        } catch (Exception e) {
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "Exception: " + e);
        }

        return Response.serverError().build();
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("")
    public Response getTasks(@QueryParam("CJSCPPUID") String  CJSCPPUID) {

    	System.out.println("Got, "+CJSCPPUID);
        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "GET tasks");

        List<CreateTaskResponse> response = service.getTasks();
        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "GET tasks response " + response);
        return Response.ok(response).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("")
    public Response updateTask(CreateTaskRequest request) {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "PUT Update task: " + request);

        UpdateTaskResponse response;
        try {
            response = service.updateTask(request);
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "PUT Update task response " + response);
            return Response.ok(response).build();
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return Response.status(404, e.getMessage()).build();
            }
        }

        return Response.serverError().build();
    }

    @PATCH
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{taskId}")
    public Response updateTask(@PathParam("taskId") String taskId, UpdateTaskRequest request) {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "PATCH Update task: " + request);

        UpdateTaskResponse response;
        try {
            if (taskId != null) {
                request.setId(taskId);
            }
            response = service.updateTaskById(taskId, request);

            if (response == null) {
                return Response
                        .status(404)
                        .entity(Entity.entity("Not Found Task with Id " + taskId, MediaType.APPLICATION_JSON_TYPE))
                        .build();
            } else {
                Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "PATCH Update task response " + response);
                return Response.ok(response).build();
            }
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return Response.status(404, e.getMessage()).build();
            }
        }

        return Response.serverError().build();
    }

    @DELETE
    @Path("/{taskId}")
    public Response deleteTask(@PathParam("taskId") String taskId) {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "DELETE task: " + taskId);

        DeleteTaskResponse response;
        try {
            response = service.deleteTask(taskId);
            if (response == null) {
                return Response
                        .status(404)
                        .entity(Entity.entity("Not Found Task with Id " + taskId, MediaType.APPLICATION_JSON_TYPE))
                        .build();
            } else {
                Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "DELETE task response " + response);
                return Response.ok(response).build();
            }
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return Response.status(404, e.getMessage()).build();
            }
        }

        return Response.serverError().build();
    }

    @DELETE
    @Path("/all")
    public Response deleteTasks() {

        Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "DELETE tasks ");

        DeleteTaskResponse response;
        try {
            response = service.deleteTasks();
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO, null, "DELETE tasks response " + response);
            return Response.ok(response).build();
        } catch (Exception e) {
            if (e instanceof NotFoundException) {
                return Response.status(404, e.getMessage()).build();
            }
        }

        return Response.serverError().build();
    }
}
