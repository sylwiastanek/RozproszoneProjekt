import java.rmi.*;
import java.text.*;
import java.util.*;

public class SimpleDatetimeClientApp{
        public static void main(String[] s){
        int registryPort = 8000;
        SimpleDatetimeServer server = null;
        try{
                System.setSecurityManager(new RMISecurityManager());
                server = (SimpleDatetimeServer)Naming.lookup("//localhost:"+registryPort+"/dServer");
                String desc = server.getDescription();
                System.out.println("\n\npolaczenie z serwerem "+desc+" przebieglo pomyslnie");
                long time = server.getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                StringBuffer data = new StringBuffer();
                System.out.println("czas na serwerze: "+df.format(new Date(time), data, new FieldPosition(0))+"\n\n");                 
        }
        catch(Exception ex){
                System.out.println(ex);
        }
	}
}