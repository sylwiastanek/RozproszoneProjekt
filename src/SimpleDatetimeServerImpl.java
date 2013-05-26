import java.rmi.Remote;
import java.rmi.RemoteException;

//implementacja
public class SimpleDatetimeServerImpl implements SimpleDatetimeServer{
       private String description;

       SimpleDatetimeServerImpl(String desc){
             description = desc;
       }

       //implementacja metod ze zdalnego interfejsu
       public String getDescription() throws RemoteException{
             return description;
       }

       public long getTime() throws RemoteException{
             return System.currentTimeMillis();
       }

       //implementacja metod lokalnych
       public void setDescription(String desc){
             description = desc;
       }
}
