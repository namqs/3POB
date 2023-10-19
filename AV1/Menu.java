import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Menu {
    private int opcao = 0;

    public void Processamento() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Digite a opção:");
            System.out.println("1- Ver lista de produtos");
            System.out.println("2- Adicionar um item ao carrinho");
            System.out.println("3- Ver carrinho");
            System.out.println("4-Finalizar compra");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ListarProdutos();
                    break;
                case 2:
                    IncluirItem();
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
    public Boolean VerificaId(int id) {
    Pattern pattern = Pattern.compile("^[0-9]{1}$");
    Matcher matcher = pattern.matcher(id);
    boolean matchFound = matcher.matches();
    if (matchFound) {
        System.out.println("Adicionando item ao carrinho.");
    } else {
        System.out.println("Código inválido. Tente novamente.");
    }
    return matchFound;
    }
  
    public boolean IncluirItem() {
        int id;
        int quantidade;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva o código do item: ");
        id = sc.next();
        if (!VerificaId(Id)) {
            System.out.println("Código inválido. Tente novamente.");
            return false;
        }

        System.out.println("Digite a quantidade desejada desse produto(somente os números): ");
        quantidade = sc.next();
        
        ItensCarrinho item = new ItensCarrinho(id, quantidade);
        Carrinho.addItem(item);
        return true;
    }
  
  public void ExibirCarrinho() { //total = (PRECOId*quantidade) de todos
    System.out.println("Carrinho:");
    for (ItensCarrinho item : Carrinho) {
        System.out.println(item.getId() + " - " + item.getQuantidade() + " unidades");
    }
}
}
