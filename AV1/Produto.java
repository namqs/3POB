public class Produto {
      public int id;
      public String nome;
      public float preco;
      
      public Produto(int id, String nome, float preco) {
          this.id = id;
          this.nome = nome;
          this.preco = preco;
      }

      public int getId(){
        return id;
      }
      public void setId(int id){
        this.id = id;
      }
  
      public String getNome() {
          return nome;
      }

      public void setNome(String nome) {
          this.nome = nome;
      }

      public float getPreco() {
          return preco;
      }

      public void setPreco(float preco) {
          this.preco = preco;
      }

      public void status(){
        System.out.println("Código: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
      }
 }
