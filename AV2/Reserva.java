public class Reserva {
    private int id;
    private int idQuarto;
    private int idCama;
    private int idCliente;
    private String dataEntrada;
    private String dataSaida;

    public Reserva(int id, int idQuarto, int idCama, int idCliente, String dataEntrada, String dataSaida) {
        this.id = id;
        this.idQuarto = idQuarto;
        this.idCama = idCama;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public int getIdCama() {
        return idCama;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

  public static boolean validarReserva(int idQuarto, int idCama, int idCliente, String dataEntrada, String dataSaida) {
      if (idQuarto <= 0 || idCama <= 0 || idCliente <= 0) {
          System.out.println("Erro: IDs de quarto, cama e cliente devem ser números positivos.");
          return false;
      }
      if (dataEntrada == null || dataEntrada.trim().isEmpty() || dataSaida == null || dataSaida.trim().isEmpty()) {
          System.out.println("Erro: Datas de entrada e saída devem ser fornecidas.");
          return false;
      }
      return true;
  }
}
