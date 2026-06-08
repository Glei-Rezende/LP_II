package service;

import model.Carro;
import repository.CarroRepository;

import java.util.List;

public class CarroService {

    private static CarroRepository repository = new CarroRepository();

    public List<Carro> listar() {
        return repository.listar();
    }

    public Carro criar(Carro carro) {
        return repository.salvar(carro);
    }

    public Carro buscar(Long id) {
        return repository.buscarPorId(id);
    }

    public Carro atualizar(Long id, Carro carro) {
        return repository.atualizar(id, carro);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}