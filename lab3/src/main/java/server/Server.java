package server;

import lombok.extern.java.Log;
import server.dao.UserDAOImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;

@Log
public class Server {

    private static final int PORT = 8081;

    private void startServer() {
        try (var servetSocket = new ServerSocket(PORT)){
            while (true) {
                var socket = servetSocket.accept();
                log.log(Level.INFO, "Accepted new connection to server");
                Thread thread = new SessionHandler(socket, new UserDAOImpl());
                thread.start();
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error while initializing servesSocket in server.Server class");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().startServer();
    }
}
