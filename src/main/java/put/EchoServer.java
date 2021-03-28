package put;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static String getContent(String str) {
        return str.split(" ")[1].split("=")[1];
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    System.out.println("User: " + (getContent(str)));
                        switch (getContent(str)) {
                            case ("Hello"):
                                out.write(("Hello too!\r\r\r\n").getBytes());
                                break;
                            case ("Exit"):
                                out.write("Bye!\r\r\r\n".getBytes());
                                out.flush();
                                socket.close();
                                break;
                            default:
                                out.write("What\r\n\r\n".getBytes());
                                break;
                        }
                }
            }
        }
    }
}