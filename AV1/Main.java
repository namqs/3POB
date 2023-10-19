import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
       ArrayList<Produto> produtos = new ArrayList<Produto>();
       produtos.add(new Produto(1,"Banana", 0.50f));
       produtos.add(new Produto(2,"Bis", 4.50f));
       produtos.add(new Produto(3,"Detergente", 1.20f));
       produtos.add(new Produto(4,"Mingau", 1.99f));
       produtos.add(new Produto(5,"Nuggets", 8.99f));
      
       Menu menu = new Menu();
       menu.Processamento();

    }
}
