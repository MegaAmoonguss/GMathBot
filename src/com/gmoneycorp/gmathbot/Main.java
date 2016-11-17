package com.gmoneycorp.gmathbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {
	
	public static void main(String[] args){
		
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken("MjQ4NjAyMTAzNDcwMjI3NDU3.Cw6OWA.MZGUL9xZD4Rbl0z-MMzGxqNfRkU")
                    .addListener(new BotListener())
                    .buildBlocking();
            jda.setAutoReconnect(true);
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
