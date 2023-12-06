public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String postalCode;
    private String pais;
    private String cpf;
    private String passaporte;
    private String email;
    private String dataNascimento;

    public Cliente(int id, String nome, String endereco, String postalCode, String pais, String cpf, String passaporte, String email, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCode = postalCode;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPais() {
        return pais;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


public static boolean validarCliente(String nome, String cpf, String passaporte) {
    if (!nome.matches("^[a-zA-Z]+$")) {
        System.out.println("Erro: Nome deve conter apenas letras.");
        return false;
    }

    if (cpf.length() != 11 || !cpf.matches("^[0-9]+$")) {
        System.out.println("Erro: CPF inválido. Deve conter 11 dígitos numéricos.");
        return false;
    }

    if (passaporte.isEmpty()) {
        System.out.println("Erro: Passaporte não pode ser vazio.");
        return false;
    }

    return true;

  }
}