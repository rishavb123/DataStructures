import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, HttpServer.Receiver> map = new HashMap<>();
        map.put("test", params -> "Hello, World! " + params);
        HttpServer server = new HttpServer(8000, map);
        server.start();
    }
}