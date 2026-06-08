package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import model.Carro;
import service.CarroService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CarroController {

    private CarroService service = new CarroService();
    private ObjectMapper mapper = new ObjectMapper();

    private Long extrairId(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();

        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }

        return Long.parseLong(path.substring(path.lastIndexOf("/") + 1));
    }

    public void listar(HttpExchange exchange) throws IOException {
        List<Carro> carros = service.listar();

        byte[] response = mapper.writeValueAsBytes(carros);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    public void criar(HttpExchange exchange) throws IOException {

        InputStream is = exchange.getRequestBody();
        Carro carro = mapper.readValue(is, Carro.class);
        is.close();

        Carro novo = service.criar(carro);

        byte[] response = mapper.writeValueAsBytes(novo);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(201, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    public void buscarPorId(HttpExchange exchange) throws IOException {

        Long id = extrairId(exchange);

        Carro carro = service.buscar(id);

        byte[] response = mapper.writeValueAsBytes(carro);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    public void atualizar(HttpExchange exchange) throws IOException {

        Long id = extrairId(exchange);

        InputStream is = exchange.getRequestBody();
        Carro carro = mapper.readValue(is, Carro.class);
        is.close();

        Carro atualizado = service.atualizar(id, carro);

        byte[] response = mapper.writeValueAsBytes(atualizado);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    public void deletar(HttpExchange exchange) throws IOException {

        Long id = extrairId(exchange);

        service.deletar(id);

        byte[] response = "Carro deletado com sucesso".getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, response.length);

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }
}