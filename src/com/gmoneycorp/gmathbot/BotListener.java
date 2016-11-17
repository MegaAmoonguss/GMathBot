package com.gmoneycorp.gmathbot;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class BotListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		//Get information about the message sent
		User author = event.getAuthor();
		Message message = event.getMessage();

		String msg = message.getContent();

		//Work with the message if it was a command for the bot from a user
		if (msg.startsWith("!gmath") || author.getId() == event.getJDA().getSelfUser().getId()) {
			if (event.isFromType(ChannelType.TEXT)) {
				Guild guild = event.getGuild();
				TextChannel textChannel = event.getTextChannel();
				Member member = event.getMember();
				String name = member.getEffectiveName();

				System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
			}
			else if (event.isFromType(ChannelType.GROUP)) {
				Group group = event.getGroup();
				String groupName = group.getName() != null ? group.getName() : "";

				System.out.printf("[GRP: %s]<%s>: %s\n", groupName, author.getName(), msg);
			}
			
			//Invoke the command handler
			if (msg.startsWith("!gmath") && author.getId() != event.getJDA().getSelfUser().getId())
				CommandHandler.handle(event);
		}
	}
}