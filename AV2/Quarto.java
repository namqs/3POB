public class Quarto {
    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    public Quarto(int id, String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = id;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public void setQtdeCamas(int qtdeCamas) {
        this.qtdeCamas = qtdeCamas;
    }

    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  public static boolean validarQuarto(String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
          if (nomeQuarto.isEmpty()) {
              System.out.println("Erro: Nome do quarto não pode ser vazio.");
              return false;
          }

          if (qtdeCamas != 4 && qtdeCamas != 8 && qtdeCamas != 12) {
              System.out.println("Erro: A quantidade de camas deve ser 4, 8 ou 12.");
              return false;
          }

          if (qtdeCamas != 4 && qtdeCamas != 12 && temBanheiro) {
              System.out.println("Erro: Apenas quartos com 4 ou 12 camas podem ter banheiro.");
              return false;
          }

          if (descricao.isEmpty()) {
              System.out.println("Erro: Descrição do quarto não pode ser vazia.");
              return false;
          }
          return true;
      }
          }