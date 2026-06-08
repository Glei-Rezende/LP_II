package repository;

import model.Carro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CarroRepository {

    private static List<Carro> carros = new ArrayList<>();
    private static AtomicLong idGenerator = new AtomicLong(1);

    public List<Carro> listar() {
        return carros;
    }

    public Carro salvar(Carro carro) {
        carro.setId(idGenerator.getAndIncrement());
        carros.add(carro);
        return carro;
    }

    public Carro buscarPorId(Long id) {
        return carros.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Carro atualizar(Long id, Carro carroAtualizado) {
        Carro existente = buscarPorId(id);

        if (existente != null) {
            existente.setModelo(carroAtualizado.getModelo());
            existente.setCor(carroAtualizado.getCor());
            existente.setAno(carroAtualizado.getAno());
        }

        return existente;
    }

    public void deletar(Long id) {
        carros.removeIf(c -> c.getId().equals(id));
    }
}