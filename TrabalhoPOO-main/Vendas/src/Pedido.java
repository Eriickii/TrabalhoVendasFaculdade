import java.util.ArrayList;

class Pedido {
    private static int contador = 1;
    private int numPedido;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.numPedido = contador++;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getQuantidadeProduto() >= quantidade) {
            produto.removerQuantidade(quantidade);
            itens.add(new ItemPedido(produto, quantidade));
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    public void cancelarItem(int index) {
        if (index >= 0 && index < itens.size()) {
            ItemPedido item = itens.get(index);
            item.getProduto().adicionarQuantidade(item.getQuantidade());
            itens.remove(index);
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void cancelarPedido() {
        for (ItemPedido item : itens) {
            item.getProduto().adicionarQuantidade(item.getQuantidade());
        }
        itens.clear();
    }

    public int getNumPedido() {
        return numPedido;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
