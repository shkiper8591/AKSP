import java.rmi.RemoteException;
import java.util.ArrayList;

public class RemoteServer implements Calculator {
    private int x;

    @Override
    public ArrayList<Double> quadraticEquation(int a, int b, int c) throws RemoteException {
        Result result=new Result((b-Math.sqrt(b*b-4*a*c))/(2*a),(b+Math.sqrt(b*b-4*a*c))/(2*a));
        ArrayList<Double> res=new ArrayList<>();
        res.add(result.getX1());
        res.add(result.getX2());
        return res;
    }

}