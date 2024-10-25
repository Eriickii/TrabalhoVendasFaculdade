class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int id;
    private static int contador = 1;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = contador++;
    }

    public String getNomeProduto() {
        return nome;
    }

    public double getPrecoProduto() {
        return preco;
    }

    public int getQuantidadeProduto() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    public int getId() {
        return id;
    }
}