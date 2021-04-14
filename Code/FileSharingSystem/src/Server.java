/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakamoto Jin
 */
import java.net.*;

public class Server implements Runnable 
{
  //port
  ServerSocket port;
  Thread t;
  boolean flag;
  
  Server(int p) throws Exception
  {
    //open the port
    port = new ServerSocket(p);
    //create a thread to accept client connections
    flag = true;
    t = new Thread(this);
    t.start();
    
  }
  
  public void run()
  {//accept client connections
    
    try
    {
      //soTimeout is the time in milliseconds
      //after which an execption is raised to 
      //bring the thread out of accept.
      
      port.setSoTimeout(5000);
      while(flag == true)
      {
        acceptConnection();
      }
      
      //shut down the server
      port.close();
    }
    catch(Exception ex)
    {
      System.out.println("Err : " + ex);
    }
  }
  
  
  void acceptConnection()
  {//get a connection
    try
    {
      System.out.println("Waiting for client connection ...");
      Socket s = port.accept();
      System.out.println("... Got a client connection");
      //Process
      //new ClientProcessor(s);
    }
    catch(Exception ex)
    {}
  }//acceptConnection
}
