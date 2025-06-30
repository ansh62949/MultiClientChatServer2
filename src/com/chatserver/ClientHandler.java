package com.chatserver;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Welcome to the chat!");
        } catch (IOException e) {
            System.err.println("ClientHandler setup error: " + e.getMessage());
        }
    }

    public void run() {
        String message;
        try {
            while ((message = input.readLine()) != null) {
                System.out.println("Message from client: " + message);
                Server.broadcast(message, this);
            }
        } catch (IOException e) {
            System.err.println("Client disconnected.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
            Server.clients.remove(this);
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }
}