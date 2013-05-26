import java.rmi.Remote;
import java.rmi.RemoteException;

//interfejs
interface SimpleDatetimeServer extends Remote{
       public String getDescription() throws RemoteException;
       public long getTime() throws RemoteException;
}
