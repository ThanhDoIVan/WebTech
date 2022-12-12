package client;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8081;
    private static final Socket clientSocket;

    static {
        try {
            clientSocket = new Socket(HOSTNAME, PORT);
        } catch (IOException e) {
            System.out.println("Unable to connect to server.");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        try(var clientSocketInputStream = new DataInputStream(clientSocket.getInputStream());
            var clientSocketOutputStream = new PrintWriter(clientSocket.getOutputStream())) {
            System.out.println("You're not logged in. Enter your data to continue");
            do {
                String email = System.console().readLine("Email: ");
                String password = String.valueOf(System.console().readPassword("Password: "));
                clientSocketOutputStream.println(email);
                clientSocketOutputStream.println(password);
                clientSocketOutputStream.flush();
                System.out.println("email " + email);
                System.out.println("password " + password);
                String authStatus = clientSocketInputStream.readLine();
                if (authStatus.equals("AUTHENTICATED")) {
                    System.out.println(authStatus);
                    break;
                } else {
                    System.out.println(authStatus);
                }
            } while (true);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true) {

        }
    }
}
