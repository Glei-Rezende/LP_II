import database.DatabaseInit;
import model.Carro;
import repository.CarroRepository;

public class TesteCarroApp {

    public static void main(String[] args) {

        // cria tabela se não existir
        DatabaseInit.criarTabela();

        CarroRepository repo = new CarroRepository();

        // =========================
        // CREATE
        // =========================
        Carro carro = new Carro();
        carro.setModelo("Onix");
        carro.setCor("Prata");
        carro.setAno(2024);

        repo.salvar(carro);

        System.out.println("Carro criado ID: " + carro.getId());

        // =========================
        // READ ALL
        // =========================
        System.out.println("\nLISTA:");
        for (Carro c : repo.listar()) {
            System.out.println(c.getId() + " - " + c.getModelo());
        }

        // =========================
        // READ BY ID
        // =========================
        Carro buscado = repo.buscarPorId(carro.getId());

        System.out.println("\nBUSCAR POR ID:");
        System.out.println(buscado.getId() + " - " + buscado.getModelo());

        // =========================
        // UPDATE
        // =========================
        Carro atualizado = new Carro();
        atualizado.setModelo("Tracker");
        atualizado.setCor("Preto");
        atualizado.setAno(2025);

        repo.atualizar(carro.getId(), atualizado);

        System.out.println("\nAPÓS UPDATE:");
        for (Carro c : repo.listar()) {
            System.out.println(c.getId() + " - " + c.getModelo());
        }

        // =========================
        // DELETE
        // =========================
        repo.deletar(carro.getId());

        System.out.println("\nAPÓS DELETE:");
        for (Carro c : repo.listar()) {
            System.out.println(c.getId() + " - " + c.getModelo());
        }
    }
}