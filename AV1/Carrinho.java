import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItensCarrinho> itens;
    private float total;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void addItem(ItensCarrinho item) {
        itens.add(item);
    }
}
