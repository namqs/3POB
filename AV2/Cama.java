public class Cama {
    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public Cama(int id, String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.id = id;
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigoCama(String codigoCama) {
        this.codigoCama = codigoCama;
    }

    public void setEhBeliche(boolean ehBeliche) {
        this.ehBeliche = ehBeliche;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

public static boolean validarCama(String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        if (codigoCama.isEmpty()) {
            System.out.println("Erro: Código da cama não pode ser vazio.");
            return false;
        }

        if (!posicao.equalsIgnoreCase("cima") && !posicao.equalsIgnoreCase("baixo")) {
            System.out.println("Erro: A posição da cama deve ser 'cima' ou 'baixo'.");
            return false;
        }

        if (descricao.isEmpty()) {
            System.out.println("Erro: Descrição da cama não pode ser vazia.");
            return false;
        }

        if (ehBeliche && (!posicao.equalsIgnoreCase("cima") && !posicao.equalsIgnoreCase("baixo"))) {
            System.out.println("Erro: Cama beliche deve ter posição 'cima' ou 'baixo'.");
            return false;
        }
        return true;
    }
}
