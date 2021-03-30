package put;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static String getContent(String str) {
        return str.split(" ")[1].split("=")[1];
    }

    public static void main(String[] args){
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
                                out.write(("Hello too!\r\n").getBytes());
                                break;
                            case ("Exit"):
                                out.write("Bye!\r\n".getBytes());
                                out.flush();
                                socket.close();
                                break;
                            default:
                                out.write("What\r\n".getBytes());
                                break;
                        }
                } catch (Exception e) {
                    LOG.error("Exception in log example", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}