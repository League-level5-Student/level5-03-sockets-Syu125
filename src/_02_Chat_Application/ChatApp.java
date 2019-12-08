package _02_Chat_Application;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
    Server server;
    Client client;
    
    public static void main(String[] args) {
        new ChatApp();
    }
    public ChatApp(){
        server = new Server(8080);
    }
}
