package app;

import database.DatabaseInit;
import model.Carro;
import repository.CarroRepository;

import java.util.List;
import java.util.Scanner;

public class MenuCarroApp {

    public static void main(String[] args) {

        DatabaseInit.criarTabela(); // garante banco pronto

        CarroRepository repo = new CarroRepository();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n======================");
            System.out.println(" SISTEMA DE CARROS ");
            System.out.println("======================");
            System.out.println("1 - Cadastrar carro");
            System.out.println("2 - Listar carros");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar carro");
            System.out.println("5 - Deletar carro");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                // =====================
                // CREATE
                // =====================
                case 1:
                    Carro novo = new Carro();

                    System.out.print("Modelo: ");
                    novo.setModelo(sc.nextLine());

                    System.out.print("Cor: ");
                    novo.setCor(sc.nextLine());

                    System.out.print("Ano: ");
                    novo.setAno(sc.nextInt());
                    sc.nextLine();

                    repo.salvar(novo);

                    System.out.println("Carro cadastrado com ID: " + novo.getId());
                    break;

                // =====================
                // READ ALL
                // =====================
                case 2:
                    List<Carro> lista = repo.listar();

                    System.out.println("\nLISTA DE CARROS:");

                    for (Carro c : lista) {
                        System.out.println(
                                c.getId() + " - " +
                                        c.getModelo() + " - " +
                                        c.getCor() + " - " +
                                        c.getAno()
                        );
                    }
                    break;

                // =====================
                // READ BY ID
                // =====================
                case 3:
                    System.out.print("Digite o ID: ");
                    Long idBusca = sc.nextLong();
                    sc.nextLine();

                    Carro buscado = repo.buscarPorId(idBusca);

                    if (buscado != null) {
                        System.out.println(
                                buscado.getId() + " - " +
                                        buscado.getModelo() + " - " +
                                        buscado.getCor() + " - " +
                                        buscado.getAno()
                        );
                    } else {
                        System.out.println("Carro não encontrado.");
                    }
                    break;

                // =====================
                // UPDATE
                // =====================
                case 4:
                    System.out.print("ID para atualizar: ");
                    Long idUpdate = sc.nextLong();
                    sc.nextLine();

                    Carro atual = new Carro();

                    System.out.print("Novo modelo: ");
                    atual.setModelo(sc.nextLine());

                    System.out.print("Nova cor: ");
                    atual.setCor(sc.nextLine());

                    System.out.print("Novo ano: ");
                    atual.setAno(sc.nextInt());
                    sc.nextLine();

                    repo.atualizar(idUpdate, atual);

                    System.out.println("Carro atualizado com sucesso!");
                    break;

                // =====================
                // DELETE
                // =====================
                case 5:
                    System.out.print("ID para deletar: ");
                    Long idDelete = sc.nextLong();
                    sc.nextLine();

                    repo.deletar(idDelete);

                    System.out.println("Carro removido com sucesso!");
                    break;

                // =====================
                // SAIR
                // =====================
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}