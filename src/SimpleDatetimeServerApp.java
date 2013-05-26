import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.security.*;

public class SimpleDatetimeServerApp{
       public static void main(String[] s){
              boolean err = false;
              int registryPort = 8055;
              try{
                     SimpleDatetimeServer server = 
                                   new SimpleDatetimeServerImpl("Simple datetime server: v. 1.0.0");
                     LocateRegistry.createRegistry(registryPort);
                     UnicastRemoteObject.exportObject(server);
                     Naming.rebind("//localhost:"+registryPort+"/dServer", server);
              }
              catch(java.rmi.UnknownHostException uhe){
                     System.out.println("[error] podana nazwa hosta nie jest \n identyfikatorem tego komputera\n"+uhe+"\n");
                     err = true;
              }
              catch(AccessControlException ace){
                     System.out.println("[error] nie masz uprawnien aby uruchomic serwer\n na tym porcie dla podanej nazwy hosta\n"+ace+"\n");
                     err = true;
              }
              catch(RemoteException re){
                     System.out.println("[error] nie udalo sie zarejestrowac \n zdalnego obiektu serwera\n"+re+"\n");
                     err = true;
              }
              catch(MalformedURLException mURLe){
                     System.out.println("[error] wewnetrzny blad" + mURLe+"\n");
                     err = true;
              }
              catch(Exception ee){
                     System.out.println("[error] cccc"+ee.getMessage()+"\n");
                     err = true;
              }
              if(!err)
                     System.out.println("\n[OK] Simple datetime server running...\n");

       }
}