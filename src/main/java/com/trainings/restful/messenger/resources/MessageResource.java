package com.trainings.restful.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trainings.restful.messenger.model.Message;
import com.trainings.restful.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMessages(){
		return messageService.getAllMessages();
	}
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("messageId") Long id){
		return messageService.getMessageWithID(id);
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message){
		return messageService.addNewMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMessagesPut(@PathParam("messageId") Long id,Message message){
		return messageService.updateMessage(id, message);
	}
	
	
	
	@DELETE
	@Path("/{messageId}")	
	public void deleteMessage(@PathParam("messageId") Long id){
		messageService.deleteMessage(id);
	}
	
	
	

}
