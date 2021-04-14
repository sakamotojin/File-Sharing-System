/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakamoto Jin
 */
import java.io.BufferedReader;
import java.util.*;
import java.io.*;


//Singleton : one instance 
public class FileManager 
{
  private static FileManager ref;
  
  static
  {
    ref = null;
  }
  
  public static FileManager getObject()
  {
    if(ref == null)
      ref = new FileManager();
    return ref;
  }
  
  private FileManager(){}
  
  //runs concurrently
  public String search(String key, String fileName)
  {
    //get IndexManager
    IndexManager iMgr = IndexManager.getObject(key);
    
    //get the keyword
    char keyWord = fileName.toUpperCase().charAt(0);
    
    //Access the Q (of 5 Pages)
    //Query the Page for keyword
    //if found 
      //find the fileName in Page
      //compose search result
    //else 
      //access index manager
      //access index file
      //load the file as a Page
      //find the fileName in Page
      //compose search result
      //let the Page replace the LFU element of Q
    //return search result
    
    return "to do";
  }
  
  
  class Page
  {
    char keyword;
    int frequency;
    LinkedList<String> index;
    
    Page(char k)
    {
      keyword = k;
      frequency = 1;
      index = new LinkedList<String>();
    }
    
    void loadPage() throws Exception
    {
      
      String fileName = Presets.INDEX_LOCATION + "/" + keyword + ".txt";
      //read 
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);  
      
      String thisLine;
      while((thisLine = br.readLine()) != null)
      {
        index.add(thisLine);
      }
      br.close();
    }
  }
}//FileManager