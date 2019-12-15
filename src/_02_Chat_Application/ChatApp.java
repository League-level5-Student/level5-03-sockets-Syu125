package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.swing.JOptionPane;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends Thread {
    Server server;
    Client client;
    ServerSocket serverSocket;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
			try {
				ChatApp ca = new ChatApp();
				ca.run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});	
		t.start();
    }

    public ChatApp() throws IOException {
        serverSocket = new ServerSocket(8080);

    }

    public void run() {
        boolean b = true;
        while (b) {
            try {
                System.out.println("The server is waiting for a client to connect");
                Socket socket = serverSocket.accept();
                System.out.println("The client has connected");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.out.println(dis.readUTF());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String message = JOptionPane.showInputDialog("write a message");
                dos.writeUTF(message);
                socket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("Socket Timeout Exception");
                b = false;
            } catch (IOException e) {
                System.out.println("IOException");
                b = false;
            }
        }
    }

}
