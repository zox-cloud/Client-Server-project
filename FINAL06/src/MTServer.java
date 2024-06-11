
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MTServer  {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1024);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Waiting for client request");
        Socket socket = serverSocket.accept();



        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in) ;


        System.out.println("New client is pop up");

        while (true) {
            System.out.print("Server: ");
            String write = scanner.nextLine();
            output.println(write);
            String client = input.readLine();
            System.out.println("Client: " + client);
        }



    }
}