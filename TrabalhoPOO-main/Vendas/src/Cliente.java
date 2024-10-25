import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String cpf;
    private int id;
    private static int contador = 1;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = contador++;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }
}