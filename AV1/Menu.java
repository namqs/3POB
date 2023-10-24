import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Menu {
    private int opcao = 0;
    private List<Produto> produtos;
    private Carrinho carrinho;

    public Menu() {
        produtos = new ArrayList<>();
        carrinho = new Carrinho();

        produtos.add(new Produto(1, "Banana", 0.50f));
        produtos.add(new Produto(2, "Bis", 4.50f));
        produtos.add(new Produto(3, "Detergente", 1.20f));
        produtos.add(new Produto(4, "Mingau", 1.99f));
        produtos.add(new Produto(5, "Nuggets", 8.99f));
    }

    public void Processamento() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite a opção:");
            System.out.println("1- Ver lista de produtos");
            System.out.println("2- Adicionar um item ao carrinho");
            System.out.println("3- Ver carrinho");
            System.out.println("4- Finalizar compra");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ListarProdutos();
                    break;
                case 2:
                    IncluirItem(sc);
                    break;
                case 3:
                    ExibirCarrinho();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 4);
    }

    public void ListarProdutos() {
        for (Produto produto : produtos) {
            produto.status();
            System.out.println();
        }
    }

    public boolean VerificaId(int id) {
        Pattern pattern = Pattern.compile("^[0-9]{1}$");
        Matcher matcher = pattern.matcher(String.valueOf(id));
        boolean matchFound = matcher.matches();
        if (matchFound) {
            System.out.println("Adicionando item ao carrinho.");
        } else {
            System.out.println("Código inválido. Tente novamente.");
        }
        return matchFound;
    }

    public boolean IncluirItem(Scanner sc) {
        int id;
        int quantidade;

        System.out.println("Escreva o código do item: ");
        id = sc.nextInt();
        if (!VerificaId(id)) {
            System.out.println("Código inválido. Tente novamente.");
            return false;
        }

        System.out.println("Digite a quantidade desejada desse produto (somente os números): ");
        quantidade = sc.nextInt();

        ItensCarrinho item = new ItensCarrinho(id, quantidade);
        carrinho.addItem(item);
        return true;
    }

  public void ExibirCarrinho() {
      System.out.println("Carrinho:");
      float total = 0.0f;
      for (ItensCarrinho item : carrinho.getItens()) {
          int idProduto = item.getIdProduto();
          int quantidade = item.getQuantidade();
          float precoProduto = 0.0f;

          for (Produto produto : produtos) {
              if (produto.getId() == idProduto) {
                  precoProduto = produto.getPreco();
                  System.out.println(produto.getNome() + " - " + quantidade + " unidades");
                  break;
              }
          }

          float subtotal = quantidade * precoProduto;
          total += subtotal;
      }
      System.out.println("Preço Total: " + total);
  }
}
