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
import java.io.*;

public class ClientProcessor extends Thread 
{
  Socket clnt;
  ClientProcessor(Socket s)
  {
    clnt = s;
    //active the thread
    start();
    
  }
  
  public void run()
  {
    try
    {
      DataInputStream din = new DataInputStream(clnt.getInputStream());
      DataOutputStream dout = new DataOutputStream(clnt.getOutputStream());
      
      String key = "myIndex";
      FileManager fMgr = FileManager.getObject();
      fMgr.search( key, "B1.png");
    }
    catch(Exception ex)
    {
      System.out.println("Err : "+ ex);
    }
  
  }//run
  
}