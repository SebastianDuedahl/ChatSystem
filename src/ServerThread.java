import java.net.*;
import java.io.*;

public class ServerThread implements Runnable
{
    private Socket socket;

    public ServerThread (Socket socket)
    {
        this.socket = socket;
    }


    @Override
    public void run()
    {
        //TODO: make thread relay messages
    }
}
