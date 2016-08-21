package com.trainings.restful.messenger.database;

import java.util.HashMap;

import com.trainings.restful.messenger.model.Message;

public class DatabaseClass {

	private static HashMap<Long,Message> messages = new HashMap<Long, Message>();
	
	public static HashMap<Long,Message> getMessages(){
		return messages;
	}
}
