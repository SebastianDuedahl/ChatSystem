import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class ChatServer
{
    int portNumber = 3333;
    public static void main(String[] args)
    {
        ChatServer chatServer = new ChatServer();

        try
        {
            ServerSocket serverSocket = new ServerSocket(chatServer.portNumber);
            chatServer.acceptClients(serverSocket);
        }
        catch(IOException ioException)
        {
            System.out.println("Could not listen on port: " +chatServer.portNumber);
        }
    }

    private void acceptClients(ServerSocket serverSocket)
    {
        ArrayList<ClientThread> clients = new ArrayList<>();
        while(true)
        {
            try
            {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
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
