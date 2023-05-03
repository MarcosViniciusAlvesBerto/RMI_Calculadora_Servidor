
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerCal {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        String nomeServico = "Calculadora";
        Calculadora calculadora = new CalculadoraImpl();
        Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(calculadora, 0);
        Registry registro = LocateRegistry.getRegistry(1099);
        registro.bind(nomeServico, calculadora);
        System.out.println("Nome Do Servidor: " + nomeServico);
    }
}
