import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {

    public static final String UNIQUE_BINDING_NAME = "server.quadratic";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry(5555);
        //передали порт

        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);
        //получаем из регистра нужный объект
        //Чтобы вызвать удаленный объект, клиенту нужна ссылка на этот
        //объект. В это время клиент выбирает объект из реестра, используя его имя
        //привязки (с помощью метода lookup () ).
        ArrayList<Double> res = calculator.quadraticEquation(2, 3,1);
        Result result= new Result(res.get(0),res.get(1));
        System.out.println(result.toString());
    }
}
