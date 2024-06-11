







import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final int PORT_NUMBER = 1024;
    private static final String SERVER_ADDRESS = "localhost";

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT_NUMBER);


             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {

            System.out.println("Request sent successfully");

            while (true) {
                String line = input.readLine();
                System.out.println("Server: " + line);
                System.out.print("Client: ");
                String readClientMessage = reader.readLine();
                out.println(readClientMessage);

            }
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}























