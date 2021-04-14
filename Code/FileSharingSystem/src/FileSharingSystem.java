/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sakamoto Jin
 */
public class FileSharingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String indexKey = "myIndex";
    StoreManager smgr = new StoreManager(indexKey);
    
    try
    {
      int pno = 8998;
      Server svr = new Server(pno);
        
    }
    catch(Exception ex)
    {
      System.out.println("Err : "+ ex);
    }
        
    }
    
}
