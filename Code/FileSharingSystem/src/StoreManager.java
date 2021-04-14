/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakamoto Jin
 */

import java.io.*;

public class StoreManager extends Thread 
{
  boolean flag;
  long prevUpdate;
  File fileStore;
  String iKey;
  IndexManager iMgr;
  
  StoreManager(String  indexKey)
  {
    flag = true;
    prevUpdate = 0;
    fileStore = new File(Presets.STORE_LOCATION);
    iKey = indexKey;
    iMgr = IndexManager.getObject(indexKey);
    
    start();
  }
  
  public void run()
  {
    polling();
  }//run
  
  public void stopParsing()
  {
    flag = false;
  }
  
  private void polling()
  {
    while(flag)
    {
      parseStore();
      
      try
      { //10 second delay
        Thread.sleep(10000);
      }
      catch(InterruptedException ex)
      {}
    }//while
  }//polling
  
  
  private void parseStore()
  {
    long currentStatus = fileStore.lastModified();
    if(prevUpdate == 0 || prevUpdate != currentStatus)
    {//parse
      try
      {
        iMgr.makeIndex();
        prevUpdate = currentStatus;
      }
      catch(Exception ex)
      {
        System.out.println("Err: " + ex);
      }
    } 
    
  }//parseStore

  
}//StoreManager

