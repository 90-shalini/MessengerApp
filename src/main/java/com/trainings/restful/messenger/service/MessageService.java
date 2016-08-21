package com.trainings.restful.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.trainings.restful.messenger.database.DatabaseClass;
import com.trainings.restful.messenger.model.Message;

public class MessageService {

	HashMap<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1L,"hello rest","shalini"));
		messages.put(2L, new Message(2L,"hello rest2","Vibhor"));
		
		
	}
	
	public Response getAllMessages(){
		List<Message> entity = new ArrayList<Message>(messages.values());
		
		GenericEntity<List<Message>> list = new GenericEntity<List<Message>>(entity) { };
		
		return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(list).build();
//		return new ArrayList<Message> (messages.values());
	}
	
	public Response getMessageWithID(long id){
		
		return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(messages.get(id)).build();
		//return messages.get(id);
	}
	
	public Response addNewMessage(Message message){
		message.setId((long) (messages.size()+1));
		messages.put(message.getId(), message);		
		//return message;
		return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(message).build();
	}
	
	public Response updateMessage(long id,Message message){
		message.setId(id);
		messages.put(id,message);
		//return messages.get(id);
		return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity((messages.get(id))).build();

	}
	
	public void deleteMessage(long id){
		messages.remove(id);
	
	}
	
}
