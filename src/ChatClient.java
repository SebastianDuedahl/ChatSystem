import java.io.*;
import java.net.*;

public class ChatClient
{


    public static void main(String[] args)
    {
        Socket socket = null;
        int portNumber = 3333;

        try
        {
            socket = new Socket ("Localhost", portNumber);
        }
        catch(IOException e)
        {
            System.out.println("Connection Error");
        }

    }
}
