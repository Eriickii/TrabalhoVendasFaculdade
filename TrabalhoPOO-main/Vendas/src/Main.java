import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println();
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println();
            System.out.println("5 - Cadastrar Pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println();
            System.out.println("7 - Cancelar Item do Pedido");
            System.out.println("8 - Cancelar Pedido");
            System.out.println("╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾╼╾");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");


            try {
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrando Cliente: ");
                        System.out.print("Informe nome: ");
                        String nome = scan.nextLine();
                        System.out.print("Informe CPF: ");
                        String cpf = scan.nextLine();
                        clientes.add(new Cliente(nome, cpf));
                        break;

                    case 2:
                        System.out.println("Listando Clientes: ");
                        for (Cliente c : clientes) {
                            System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf());
                        }
                        break;

                    case 3:
                        System.out.println("Cadastrando Produto: ");
                        System.out.print("Informe nome do produto: ");
                        String nomeProduto = scan.nextLine();
                        System.out.print("Informe preço do produto: ");
                        double preco = scan.nextDouble();
                        System.out.print("Informe quantidade do produto: ");
                        int quantidade = scan.nextInt();
                        produtos.add(new Produto(nomeProduto, preco, quantidade));
                        break;

                    case 4:
                        System.out.println("Listando Produtos: ");
                        for (Produto p : produtos) {
                            System.out.println("ID: " + p.getId() + ", Nome: " + p.getNomeProduto() + ", Preço: " + p.getPrecoProduto() + ", Quantidade: " + p.getQuantidadeProduto());
                        }
                        break;

                    case 5:
                        System.out.println("Cadastrando Pedido: ");
                        System.out.print("Informe ID do cliente: ");
                        int idCliente = scan.nextInt();
                        Cliente cliente = null;
                        for (Cliente c : clientes) {
                            if (c.getId() == idCliente) {
                                cliente = c;
                                break;
                            }
                        }
                        if (cliente != null) {
                            Pedido pedido = new Pedido(cliente);
                            System.out.print("Informe ID do produto: ");
                            int idProduto = scan.nextInt();
                            Produto produtoEncontrado = null;
                            for (Produto p : produtos) {
                                if (p.getId() == idProduto) {
                                    produtoEncontrado = p;
                                    break;
                                }
                            }
                            if (produtoEncontrado != null) {
                                System.out.print("Informe quantidade: ");
                                int qtd = scan.nextInt();
                                pedido.adicionarItem(produtoEncontrado, qtd);
                            } else {
                                System.out.println("Produto não encontrado.");
                            }
                            pedidos.add(pedido);
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;

                    case 6:
                        System.out.println("Listando Pedidos: ");
                        for (Pedido p : pedidos) {
                            System.out.println("Número do pedido: " + p.getNumPedido() + ", Cliente: " + p.getCliente().getNome());
                            for (ItemPedido item : p.getItens()) {
                                System.out.println("  Produto: " + item.getProduto().getNomeProduto() + ", Quantidade: " + item.getQuantidade());
                            }
                        }
                        break;

                    case 7:
                        System.out.println("Informe o número do pedido: ");
                        int numPedido = scan.nextInt();
                        Pedido pedidoCancelamento = null;
                        for (Pedido p : pedidos) {
                            if (p.getNumPedido() == numPedido) {
                                pedidoCancelamento = p;
                                break;
                            }
                        }
                        if (pedidoCancelamento != null) {
                            System.out.println("Itens do pedido:");
                            for (int i = 0; i < pedidoCancelamento.getItens().size(); i++) {
                                ItemPedido item = pedidoCancelamento.getItens().get(i);
                                System.out.println(i + ": " + item.getProduto().getNomeProduto() + ", Quantidade: " + item.getQuantidade());
                            }
                            System.out.print("Informe o índice do item a cancelar: ");
                            int index = scan.nextInt();
                            pedidoCancelamento.cancelarItem(index);
                        } else {
                            System.out.println("Pedido não encontrado.");
                        }
                        break;

                    case 8:
                        System.out.println("Informe o número do pedido a cancelar: ");
                        int numPedidoCancelar = scan.nextInt();
                        Pedido pedidoCancel = null;
                        for (Pedido p : pedidos) {
                            if (p.getNumPedido() == numPedidoCancelar) {
                                pedidoCancel = p;
                                break;
                            }
                        }
                        if (pedidoCancel != null) {
                            pedidoCancel.cancelarPedido();
                            pedidos.remove(pedidoCancel);
                            System.out.println("Pedido cancelado com sucesso.");
                        } else {
                            System.out.println("Pedido não encontrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scan.nextLine();
            }
        } while (opcao != 0);

        scan.close();
    }
}
