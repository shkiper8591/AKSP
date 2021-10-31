
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Calculator extends Remote {

    ArrayList<Double> quadraticEquation(int a, int b, int c) throws RemoteException;
}

// работа RMI основана на создании прокси
//работа прокси ведется на уровне интерфейсов, а не классов