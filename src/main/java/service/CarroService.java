package service;

import model.Carro;
import repository.AcessorioRepository;
import repository.CarroAcessorioRepository;
import repository.CarroRepository;
import repository.FabricanteRepository;

import java.util.List;

public class CarroService {

    private static final FabricanteRepository fabricanteRepository =
            new FabricanteRepository();

    private static final CarroAcessorioRepository carroAcessorioRepository =
            new CarroAcessorioRepository();

    private static final AcessorioRepository acessorioRepository =
            new AcessorioRepository();

    private static final CarroRepository repository =
            new CarroRepository(
                    fabricanteRepository,
                    carroAcessorioRepository,
                    acessorioRepository
            );

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