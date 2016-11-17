package com.gmoneycorp.gmathbot;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import com.gmoneycorp.gmath.Main;

import java.util.Arrays;

public class CommandHandler {
	
	//Handles the event
	public static void handle(MessageReceivedEvent event) {
		//Gets all necessary information
		MessageChannel channel = event.getChannel();
		String stripped = event.getMessage().getContent().replaceFirst("!", "");
		String[] split = stripped.split(" ");
		String[] args = Arrays.copyOfRange(split, 1, split.length);

		//Checks which command was given and responds accordingly
		channel.sendMessage(Main.runner(args)).queue();
	}
}
