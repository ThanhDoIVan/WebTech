package server;

import server.dao.UserDAO;
import server.model.User;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SessionHandler extends Thread{

    private final Socket clientSocket;
    private final UserDAO userDAO;
    private User authenticatedUser;

    public SessionHandler(Socket socket, UserDAO userDAO) {
        this.clientSocket = socket;
        this.userDAO = userDAO;
    }

    @Override
    public void run() {
        try(var clientSocketInput = new DataInputStream(this.clientSocket.getInputStream());
            var clientSocketOutput = new PrintWriter(this.clientSocket.getOutputStream())) {
            while (clientSocket.isConnected()) {
                while (authenticatedUser == null){
                    final String email = clientSocketInput.readLine();
                    System.out.println(email);
                    final String password = clientSocketInput.readLine();
                    System.out.println(password);
                    authenticatedUser = authenticateUser(email, password);
                    if (authenticatedUser != null) {
                        clientSocketOutput.println("AUTHENTICATED");
                        clientSocketOutput.flush();
                    } else {
                        clientSocketOutput.println("AUTHENTICATION ERR");
                        clientSocketOutput.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User authenticateUser(String email, String password){
        return userDAO.findUserByEmailAndPassword(email, password);
    }
}
