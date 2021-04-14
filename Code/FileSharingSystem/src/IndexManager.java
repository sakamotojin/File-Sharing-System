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
import java.util.HashMap;



public class IndexManager 
{
  private static HashMap<String, IndexManager> allObjects;
  
  static
  {
    allObjects = new HashMap<String, IndexManager>();
  }
  private IndexManager() {}
  
  public static IndexManager getObject(String key)
  {
    if(allObjects.containsKey(key))
      return allObjects.get(key);//return object associated with the key
    else
    {
      //create a new object
      IndexManager iMgr = new IndexManager();
      //make hashmap entry
      allObjects.put(key, iMgr);
      //return the object as well
      return iMgr;
    }
  }
  
  public static boolean clearObject(String key)
  {
    return allObjects.remove(key) != null;
  }
  
  
  //sequential access
  synchronized void makeIndex() throws Exception
  {
    //update index files
    File fileStore = new File(Presets.STORE_LOCATION);
    String all[] = fileStore.list();
    String nm, fileName;
    int i, firstChar;

    FileWriter allFiles[] = new FileWriter[27];
    for(i =0; i < 26; i++)
      allFiles[i] = new FileWriter(Presets.INDEX_LOCATION + "/" + (char)(65+i)+ ".txt");

    allFiles[i]= new FileWriter(Presets.INDEX_LOCATION + "/Others.txt");
    
    for(String s : all)
    {
      nm = s.toUpperCase();
      firstChar = nm.charAt(0);
      if(firstChar >=65 && firstChar <=90)
        i = firstChar - 65;
      else
        i = 26;
      
      
      allFiles[i].write(s.toUpperCase() + "\n");
      
    }//for each
    
    for(i = 0; i< 27; i++)
      allFiles[i].close();
    
  }//makeIndex
  
  void readIndex()
  {
  
  }
  
}