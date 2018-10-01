import java.net.*;
import java.io.*;

public class ClientThread implements Runnable
{
    private Socket socket;

    public ClientThread (Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        //TODO: make thread relay messages

    }
}
