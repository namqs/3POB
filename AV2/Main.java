public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Quarto> quartos = new ArrayList<>();
        List<Cama> camas = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(clientes, quartos, camas, reservas, scanner);
        menu.executarMenu();
        scanner.close();
    }
}


