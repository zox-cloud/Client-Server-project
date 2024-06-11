
import java.net.*;
import java.io.*;



public class TCPPacketServer {
    private static final int PORT_NUMBER = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("Opening port....");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected " + clientSocket.getInetAddress().getHostAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        ) {
            while (true) {
                int serialNo = in.readInt();
                String data = in.readUTF();
                System.out.printf("Receiving from Clients Packet's serialNo# #%d and packet Data is %s \n", serialNo, data.toUpperCase());
                System.out.println();
                if ("CLOSE".equals(data.toUpperCase())) {
                    System.out.println("Closing connection...");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while communicating with the client: " + e.getMessage());
        }
    }
}





























