import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class ChatServer
{
    int portNumber = 3333;
    ArrayList<ClientThread> clients = new ArrayList<>();

    public static void main(String[] args)
    {
        ChatServer chatServer = new ChatServer();
        chatServer.startServer();

    }

    public ArrayList<ClientThread> getClients()
    {
        return clients;
    }

    private void startServer()
    {

        ServerSocket serverSocket = null;
        try
        {
            serverSocket = new ServerSocket(portNumber);
            acceptClients(serverSocket);
        }
        catch (IOException ioe)
        {
                ioe.printStackTrace();
            System.out.println("Could not listen on port : " + portNumber);

        }

    }

    private void acceptClients(ServerSocket serverSocket)
    {
        System.out.println("Server starts port : " + serverSocket.getLocalSocketAddress());
        while(true)
        {
            try
            {
                Socket socket = serverSocket.accept();
                System.out.println("Accepts : " + socket.getRemoteSocketAddress());
                ClientThread client = new ClientThread(this, socket);
                Thread thread = new Thread (client);
                thread.start();
                clients.add(client);
            }
            catch (IOException e)
            {
                System.out.println("Accept failed on port: " + portNumber);
            }
        }


    }
}
