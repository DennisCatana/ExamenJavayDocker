import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversorRemotoImpl extends UnicastRemoteObject implements ConversorRemoto {
    protected ConversorRemotoImpl() throws RemoteException {
        super();
    }

    public double celsiusAFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9/5) + 32;
    }

    public double fahrenheitACelsius(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) * 5/9;
    }
}
