package lk.ijse.chatApp;

import lk.ijse.chatApp.model.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4006);
        Socket socket;

        while (true){
            System.out.println("Waiting for Client..");
            socket = serverSocket.accept();
            System.out.println("Client Connected");
            Client clientThread = new Client(socket,clients);
            clients.add(clientThread);
            clientThread.start();
        }
    }
}
