
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPPacketClient {
    private static final String HOST = "localhost";
    private static final int PORT = 1;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             Scanner scanner = new Scanner(System.in);

             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("Connected to server");

            int serialNumber = 1;
            String data;
            do {
                System.out.print("Enter the data packet: ");
                data = scanner.nextLine();

                Packet packet = new Packet(serialNumber, data);
                out.writeInt(packet.getSerialNo());
                out.writeUTF(packet.getData());

                System.out.printf("FROM SERVER: Packet SerialNO# #%d is received\n", serialNumber);
                serialNumber++;
            } while (!data.toUpperCase().equals("CLOSE"));

            System.out.println("Closing connection...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}