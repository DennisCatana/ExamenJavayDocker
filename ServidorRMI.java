import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            ConversorRemotoImpl obj = new ConversorRemotoImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Conversor", obj);
            System.out.println("Servidor RMI listo");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
