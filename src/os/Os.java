/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

/**
 *
 * @author Mr
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Os {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Press 1 to fill data Manully");
        System.out.println("Press 2 to read from file");
        Scanner fi =new Scanner(System.in);
        int choice = fi.nextInt();
        if (choice==1)
        {  Filling f=new Filling();
        f.Fill();
        
        }
        else if (choice==2)
        {
            
                    System.out.println("Enter The Name Of the file");
                  Scanner f =new Scanner(System.in);
            String choic = f.next();
         
            
            Filling read=new Filling();
           read.Fill(choic);
           

        
        
        }
            
    }
    
}
