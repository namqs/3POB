import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private int opcao = 0;
    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Cama> camas;
    private List<Reserva> reservas;
    private Scanner scanner;

  public Menu(List<Cliente> clientes, List<Quarto> quartos, List<Cama> camas, List<Reserva> reservas, Scanner scanner) {
      this.clientes = clientes;
      this.quartos = quartos;
      this.camas = camas;
      this.reservas = reservas;
      this.scanner = scanner;
  }


    public void processamento() {
        do {
            exibirMenu();
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    incluirQuarto();
                    break;
                case 6:
                    alterarQuarto();
                    break;
                case 7:
                    excluirQuarto();
                    break;
                case 8:
                    listarQuartos();
                    break;
                case 9:
                    incluirCama();
                    break;
                case 10:
                    alterarCama();
                    break;
                case 11:
                    excluirCama();
                    break;
                case 12:
                    listarCamas();
                    break;
                case 13:
                    incluirReserva();
                    break;
                case 14:
                    alterarReserva();
                    break;
                case 15:
                    excluirReserva();
                    break;
                case 16:
                    listarReservas();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("1. Incluir Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Excluir Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Incluir Quarto");
        System.out.println("6. Alterar Quarto");
        System.out.println("7. Excluir Quarto");
        System.out.println("8. Listar Quartos");
        System.out.println("9. Incluir Cama");
        System.out.println("10. Alterar Cama");
        System.out.println("11. Excluir Cama");
        System.out.println("12. Listar Camas");
        System.out.println("13. Incluir Reserva");
        System.out.println("14. Alterar Reserva");
        System.out.println("15. Excluir Reserva");
        System.out.println("16. Listar Reservas");
        System.out.println("0. Sair");
    }

  private void incluirCliente() {
  Scanner scanner = new Scanner(System.in);

      System.out.println("Digite seu nome:");
      String nome = scanner.nextLine();
      System.out.println("Digite seu cpf:");
      String cpf = scanner.nextLine();
      System.out.println("Digite o passaporte do cliente:");
      String passaporte = scanner.nextLine();

      if (Cliente.validarCliente(nome, cpf, passaporte)) {
          Cliente novoCliente = new Cliente(clientes.size() + 1, nome, "", "", "", cpf, passaporte, "", "");
          clientes.add(novoCliente);
          System.out.println("Cliente adicionado com sucesso!");
      } else {
          System.out.println("Erro ao adicionar cliente. Verifique os dados informados.");
      }
  }

  private void alterarCliente() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o ID do cliente a ser alterado:");
      int idCliente = scanner.nextInt();
      scanner.nextLine();  
    
      Cliente clienteParaAlterar = encontrarClientePorId(idCliente);
      if (clienteParaAlterar != null) {
          System.out.println("Digite o novo nome do cliente:");
          String novoNome = scanner.nextLine();
          System.out.println("Digite o novo CPF do cliente:");
          String novoCpf = scanner.nextLine();
          System.out.println("Digite o novo passaporte do cliente:");
          String novoPassaporte = scanner.nextLine();

          if (Cliente.validarCliente(novoNome, novoCpf, novoPassaporte)) {
              clienteParaAlterar.setNome(novoNome);
              clienteParaAlterar.setCpf(novoCpf);
              clienteParaAlterar.setPassaporte(novoPassaporte);

              System.out.println("Cliente alterado com sucesso!");
          } else {
              System.out.println("Erro ao alterar cliente. Verifique os dados informados.");
          }
      } else {
          System.out.println("Cliente não encontrado. Verifique o ID informado.");
      }
  }

  private Cliente encontrarClientePorId(int idCliente) {
      for (Cliente cliente : clientes) {
          if (cliente.getId() == idCliente) {
              return cliente;
          }
      }
      return null;
  }

  private void excluirCliente() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o ID do cliente a ser excluído:");
      int idCliente = scanner.nextInt();
      scanner.nextLine(); 
    
      Cliente clienteParaExcluir = encontrarClientePorId(idCliente);
      if (clienteParaExcluir != null) {
              clientes.remove(clienteParaExcluir);
              System.out.println("Cliente excluído com sucesso!");
      } else {
          System.out.println("Cliente não encontrado. Verifique o ID informado.");
      }
  }

  private void incluirQuarto() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o nome do quarto:");
      String nomeQuarto = scanner.nextLine();
      System.out.println("Digite a quantidade de camas no quarto (4, 8 ou 12):");
      int qtdeCamas = scanner.nextInt();
      scanner.nextLine();  
    
      boolean temBanheiro = false;
      if (qtdeCamas == 4 || qtdeCamas == 12) {
          System.out.println("O quarto terá banheiro? (S/N)");
          temBanheiro = scanner.nextLine().equalsIgnoreCase("S");
      }

      System.out.println("Digite uma descrição para o quarto:");
      String descricao = scanner.nextLine();

      Quarto novoQuarto = new Quarto(quartos.size() + 1, nomeQuarto, qtdeCamas, temBanheiro, descricao);

      if (Quarto.validarQuarto(novoQuarto)) {
          quartos.add(novoQuarto);
          System.out.println("Quarto adicionado com sucesso!");
      } else {
          System.out.println("Erro ao adicionar quarto. Verifique os dados informados.");
      }
  }


  private void alterarQuarto() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o ID do quarto a ser alterado:");
      int idQuarto = scanner.nextInt();
      scanner.nextLine();  
      Quarto quartoParaAlterar = encontrarQuartoPorId(idQuarto);
      if (quartoParaAlterar != null) {
          System.out.println("Digite o novo nome do quarto:");
          String novoNomeQuarto = scanner.nextLine();
          System.out.println("Digite a nova quantidade de camas no quarto (4, 8 ou 12):");
          int novaQtdeCamas = scanner.nextInt();
          scanner.nextLine(); 
          boolean novoTemBanheiro = false;
          if (novaQtdeCamas == 4 || novaQtdeCamas == 12) {
              System.out.println("O novo quarto terá banheiro? (S/N)");
              novoTemBanheiro = scanner.nextLine().equalsIgnoreCase("S");
          }

          System.out.println("Digite a nova descrição para o quarto:");
          String novaDescricao = scanner.nextLine();
          if (Quarto.validarQuarto(novoNomeQuarto, novaQtdeCamas, novoTemBanheiro, novaDescricao)) {
              quartoParaAlterar.setNomeQuarto(novoNomeQuarto);
              quartoParaAlterar.setQtdeCamas(novaQtdeCamas);
              quartoParaAlterar.setTemBanheiro(novoTemBanheiro);
              quartoParaAlterar.setDescricao(novaDescricao);

              System.out.println("Quarto alterado com sucesso!");
          } else {
              System.out.println("Erro ao alterar quarto. Verifique os dados informados.");
          }
      } else {
          System.out.println("Quarto não encontrado. Verifique o ID informado.");
      }
  }

  private Quarto encontrarQuartoPorId(int idQuarto) {
      for (Quarto quarto : quartos) {
          if (quarto.getId() == idQuarto) {
              return quarto;
          }
      }
      return null;
  }
  
  private void excluirQuarto() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o ID do quarto a ser excluído:");
      int idQuarto = scanner.nextInt();
      scanner.nextLine(); 
      Quarto quartoParaExcluir = encontrarQuartoPorId(idQuarto);

      if (quartoParaExcluir != null) {
              quartos.remove(quartoParaExcluir);
              System.out.println("Quarto excluído com sucesso!");
      } else {
          System.out.println("Quarto não encontrado. Verifique o ID informado.");
      }
  }

  private void incluirCama() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o código da cama:");
      String codigoCama = scanner.nextLine();
      System.out.println("A cama é beliche? (S/N)");
      boolean ehBeliche = scanner.nextLine().equalsIgnoreCase("S");
      System.out.println("Digite a posição da cama (cima/baixo):");
      String posicao = scanner.nextLine();
      System.out.println("Digite uma descrição para a cama:");
      String descricao = scanner.nextLine();

      if (Cama.validarCama(codigoCama, ehBeliche, posicao, descricao)) {
          Cama novaCama = new Cama(camas.size() + 1, codigoCama, ehBeliche, posicao, descricao);
          camas.add(novaCama);
          System.out.println("Cama adicionada com sucesso!");
      } else {
          System.out.println("Erro ao adicionar cama. Verifique os dados informados.");
      }
  }

  private void alterarCama() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o ID da cama a ser alterada:");
      int idCama = scanner.nextInt();
      scanner.nextLine(); 
      Cama camaParaAlterar = encontrarCamaPorId(idCama);
      if (camaParaAlterar != null) {
          System.out.println("Digite o novo código da cama:");
          String novoCodigoCama = scanner.nextLine();
          System.out.println("A nova cama é beliche? (S/N)");
          boolean novaEhBeliche = scanner.nextLine().equalsIgnoreCase("S");
          System.out.println("Digite a nova posição da cama (cima/baixo):");
          String novaPosicao = scanner.nextLine();
          System.out.println("Digite uma nova descrição para a cama:");
          String novaDescricao = scanner.nextLine();

          if (Cama.validarCama(novoCodigoCama, novaEhBeliche, novaPosicao, novaDescricao)) {
              camaParaAlterar.setCodigoCama(novoCodigoCama);
              camaParaAlterar.setEhBeliche(novaEhBeliche);
              camaParaAlterar.setPosicao(novaPosicao);
              camaParaAlterar.setDescricao(novaDescricao);

              System.out.println("Cama alterada com sucesso!");
          } else {
              System.out.println("Erro ao alterar cama. Verifique os dados informados.");
          }
      } else {
          System.out.println("Cama não encontrada. Verifique o ID informado.");
      }
  }

  private Cama encontrarCamaPorId(int idCama) {
      for (Cama cama : camas) {
          if (cama.getId() == idCama) {
              return cama;
          }
      }
      return null;
  }

  private void excluirCama() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o ID da cama a ser excluída:");
      int idCama = scanner.nextInt();
      scanner.nextLine();
      Cama camaParaExcluir = encontrarCamaPorId(idCama);

      if (camaParaExcluir != null) {
              camas.remove(camaParaExcluir);
              System.out.println("Cama excluída com sucesso!");
      } else {
          System.out.println("Cama não encontrada. Verifique o ID informado.");
      }
  }

  private void incluirReserva() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("=== Incluir Reserva ===");

      System.out.println("Digite o ID do quarto:");
      int idQuarto = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Digite o ID da cama:");
      int idCama = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Digite o ID do cliente:");
      int idCliente = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Digite a data de entrada (AAAA-MM-DD):");
      String dataEntrada = scanner.nextLine();
      System.out.println("Digite a data de saída (AAAA-MM-DD):");
      String dataSaida = scanner.nextLine();

      if (Reserva.validarReserva(idQuarto, idCama, idCliente, dataEntrada, dataSaida)) {
          Reserva novaReserva = new Reserva(reservas.size() + 1, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
          reservas.add(novaReserva);
          System.out.println("Reserva adicionada com sucesso!");
      } else {
          System.out.println("Erro ao adicionar reserva. Verifique os dados informados.");
      }
  }

  private void alterarReserva() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("=== Alterar Reserva ===");

      System.out.println("Digite o ID da reserva a ser alterada:");
      int idReserva = scanner.nextInt();
      scanner.nextLine();
      Reserva reservaParaAlterar = encontrarReservaPorId(idReserva);

      if (reservaParaAlterar != null) {
          System.out.println("Digite o novo ID do quarto:");
          int novoIdQuarto = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Digite o novo ID da cama:");
          int novoIdCama = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Digite o novo ID do cliente:");
          int novoIdCliente = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Digite a nova data de entrada (AAAA-MM-DD):");
          String novaDataEntrada = scanner.nextLine();
          System.out.println("Digite a nova data de saída (AAAA-MM-DD):");
          String novaDataSaida = scanner.nextLine();

          if (Reserva.validarReserva(novoIdQuarto, novoIdCama, novoIdCliente, novaDataEntrada, novaDataSaida)) {
              reservaParaAlterar.setIdQuarto(novoIdQuarto);
              reservaParaAlterar.setIdCama(novoIdCama);
              reservaParaAlterar.setIdCliente(novoIdCliente);
              reservaParaAlterar.setDataEntrada(novaDataEntrada);
              reservaParaAlterar.setDataSaida(novaDataSaida);

              System.out.println("Reserva alterada com sucesso!");
          } else {
              System.out.println("Erro ao alterar reserva. Verifique os dados informados.");
          }
      } else {
          System.out.println("Reserva não encontrada. Verifique o ID informado.");
      }
  }

  private void excluirReserva() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("=== Excluir Reserva ===");

      System.out.println("Digite o ID da reserva a ser excluída:");
      int idReserva = scanner.nextInt();
      scanner.nextLine();
      Reserva reservaParaExcluir = encontrarReservaPorId(idReserva);

      if (reservaParaExcluir != null) {
          reservas.remove(reservaParaExcluir);
          System.out.println("Reserva excluída com sucesso!");
      } else {
          System.out.println("Reserva não encontrada. Verifique o ID informado.");
      }
  }
  private Reserva encontrarReservaPorId(int idReserva) {
      for (Reserva reserva : reservas) {
          if (reserva.getId() == idReserva) {
              return reserva;
          }
      }
      return null;
  }
    private void listarClientes() {
        System.out.println("=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", E-mail: " + cliente.getEmail());
        }
        System.out.println("=========================");
    }

    private void listarQuartos() {
        System.out.println("=== Lista de Quartos ===");
        for (Quarto quarto : quartos) {
            System.out.println("ID: " + quarto.getId() + ", Nome: " + quarto.getNomeQuarto() +
                    ", Banheiro: " + (quarto.isTemBanheiro() ? "Sim" : "Não") + ", Descrição: " + quarto.getDescricao());
        }
        System.out.println("=========================");
    }

    private void listarCamas() {
        System.out.println("=== Lista de Camas ===");
        for (Cama cama : camas) {
            System.out.println("ID: " + cama.getId() + ", Código: " + cama.getCodigoCama() +
                    ", Beliche: " + (cama.isEhBeliche() ? "Sim" : "Não") + ", Posição: " + cama.getPosicao() +
                    ", Descrição: " + cama.getDescricao());
        }
        System.out.println("=========================");
    }

    private void listarReservas() {
        System.out.println("=== Lista de Reservas ===");
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId() + ", Cliente: " + getNomeCliente(reserva.getIdCliente()) +
                    ", Quarto: " + getNomeQuarto(reserva.getIdQuarto()) + ", Entrada: " + reserva.getDataEntrada() +
                    ", Saída: " + reserva.getDataSaida());
        }
        System.out.println("=========================");
    }

    private String getNomeCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idCliente) {
                return cliente.getNome();
            }
        }
        return "Cliente não encontrado";
    }

    private String getNomeQuarto(int idQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getId() == idQuarto) {
                return quarto.getNomeQuarto();
            }
        }
        return "Quarto não encontrado";
    }
}
