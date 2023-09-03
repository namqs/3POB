import java.util.Scanner;

public class Aluno {
    private String nome;
    private String materia;
    private String siglaMateria;
    private String periodo;
    private int idade;
    private int matricula;

    // Construtor da classe definida como Aluno
    public Aluno(String nome, String materia, String siglaMateria, String periodo, int idade, int matricula) {
        this.nome = nome;
        this.materia = materia;
        this.siglaMateria = siglaMateria;
        this.periodo = periodo;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Getters e setters para cada campo escolhido
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSiglaMateria() {
        return siglaMateria;
    }

    public void setSiglaMateria(String siglaMateria) {
        this.siglaMateria = siglaMateria;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite a matéria do aluno:");
        String materia = scanner.nextLine();

        System.out.println("Digite a sigla da matéria:");
        String siglaMateria = scanner.nextLine();

        System.out.println("Digite o período que está cursando:");
        String periodo = scanner.nextLine();

        System.out.println("Digite a idade do aluno:");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite a matrícula do aluno:");
        int matricula = scanner.nextInt();

        
        Aluno aluno = new Aluno(nome, materia, siglaMateria, periodo, idade, matricula);

        // Exibindo os dados do aluno
        System.out.println("Dados do aluno:");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matéria: " + aluno.getMateria());
        System.out.println("Sigla da Matéria: " + aluno.getSiglaMateria());
        System.out.println("Período: " + aluno.getPeriodo());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());

        scanner.close();
    }
}
