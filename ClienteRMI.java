import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    private ClienteRMI() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            ConversorRemoto stub = (ConversorRemoto) registry.lookup("Conversor");

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("Seleccione la conversión: 1. Celsius a Fahrenheit, 2. Fahrenheit a Celsius, 3. Salir");
                int opcion = scanner.nextInt();

                if (opcion == 3) {
                    continuar = false;
                    System.out.println("Saliendo...");
                } else if (opcion == 1 || opcion == 2) {
                    System.out.println("Ingrese la temperatura:");
                    double temperatura = scanner.nextDouble();

                    double resultado;
                    if (opcion == 1) {
                        resultado = stub.celsiusAFahrenheit(temperatura);
                    } else {
                        resultado = stub.fahrenheitACelsius(temperatura);
                    }

                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
