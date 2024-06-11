import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class tcpserver {
    public static void main (String [] args){
        try{
            ServerSocket ss = new ServerSocket(1111);
            System.out.println("Waiting For Connection:-");
            Socket s= ss.accept();
            Scanner scanner = new Scanner(System.in);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            while (true) 
            {
             String cmsg=din.readUTF();
             System.out.println("Client:-"+cmsg);
             if(cmsg.equals("exit"))
             {
                System.out.println("Quiting");
                din.close();
                dout.close();
                scanner.close();
                s.close();
                System.exit(0);
             }   
             System.out.println("Enter message:-");
             String smsg = scanner.nextLine();
             dout.writeUTF(smsg);
             if(smsg.equals("exit"))
             {
                System.out.println("Quiting!!!");
                din.close();
                dout.close();
                scanner.close();
                System.exit(0);
                }
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
