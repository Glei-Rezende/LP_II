package model;

import java.util.ArrayList;
import java.util.List;

public class Acessorio extends BaseEntity {

    private String nome;
    private List<Carro> carros = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }
}