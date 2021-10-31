import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    //уникальное имя удаленного объекта
    //по этому имени программа-клиент находит наш серве
    public static final String UNIQUE_BINDING_NAME = "server.quadratic";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {

        final RemoteServer server = new RemoteServer();
        //объект калькулятор

        final Registry registry = LocateRegistry.createRegistry(5555);
        //реестр удаленных объектов

        Remote stub = UnicastRemoteObject.exportObject(server, 0);
        registry.bind(UNIQUE_BINDING_NAME, stub);

        Thread.sleep(Integer.MAX_VALUE);
        //Stub - это класс, реализующий удаленный интерфейс и служащий в
        //качестве заполнителя на стороне клиента для удаленного объекта.

        //Когда клиент делает вызов удаленному объекту, он принимается
        //заглушкой, которая в конечном итоге передает этот запрос в RRL.

    }
}
