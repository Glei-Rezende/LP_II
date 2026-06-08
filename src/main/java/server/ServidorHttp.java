package server;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import controller.CarroController;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServidorHttp {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        CarroController carroController = new CarroController();

        // Rota de teste
        server.createContext("/teste", exchange -> {
            String response = "API funcionando!";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // Rota carros (CRUD completo)
        server.createContext("/carros", exchange -> {

            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();

            // remove barra final se existir
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }

            // /carros
            if (path.equals("/carros")) {

                if (method.equalsIgnoreCase("GET")) {
                    carroController.listar(exchange);

                } else if (method.equalsIgnoreCase("POST")) {
                    carroController.criar(exchange);

                } else {
                    String response = "Método não permitido";
                    exchange.sendResponseHeaders(405, response.length());

                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }

            }
            // /carros/{id}
            else if (path.startsWith("/carros/")) {

                if (method.equalsIgnoreCase("GET")) {
                    carroController.buscarPorId(exchange);

                } else if (method.equalsIgnoreCase("PUT")) {
                    carroController.atualizar(exchange);

                } else if (method.equalsIgnoreCase("DELETE")) {
                    carroController.deletar(exchange);

                } else {
                    String response = "Método não permitido";
                    exchange.sendResponseHeaders(405, response.length());

                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }

            } else {
                String response = "Rota não encontrada";
                exchange.sendResponseHeaders(404, response.length());

                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        System.out.println("Servidor rodando em http://localhost:8080");

        server.start();
    }
}