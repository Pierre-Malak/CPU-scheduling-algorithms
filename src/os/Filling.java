/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr
 */
public class Filling {
   // int no; 
public void Fill() throws IOException

{
System.out.println("Choice The Method From Next :- ");
      System.out.println("FCFS Press 1 ");
      System.out.println("Priority Scheduling Press 2 ");
         System.out.println("RR Scheduling Press 3 ");
            System.out.println(" SJF Press 4 ");
        Scanner op=new Scanner(System.in);
 int choice =op.nextInt();
 
 if (choice ==1)
           {FCFS ch=new FCFS();try {ch.FCFSMethod();} catch (IOException ex) {System.err.println("Error In Filling Class ");}}
    
 
 else if (choice==2)
            {Priority pr=new Priority();pr.PriorityMethod();}
  
 
 else if (choice==3)
            {RR w=new RR();w.RRMethod();}

 else if (choice==4){SJF jf=new SJF();
 System.out.println(" Preemptive press 1 ");
  System.out.println(" Non-Preemptive press 2 ");
  Scanner o=new Scanner(System.in);
 int ch =o.nextInt();
  if(ch==1){PeemptiveSJF p=new PeemptiveSJF();p.preemptive(); }
  else if(ch==2){jf.nonpreemptive();}
 
 }
 
 else{System.err.println("Invalid Input");}
}


public void Fill(String choic) throws IOException
{System.out.println("Choice The Method From Next :- ");
      System.out.println("FCFS Press 1 ");
      System.out.println("Priority Scheduling Press 2 ");
         System.out.println("RR Scheduling Press 3 ");
            System.out.println(" SJF Press 4 ");
        Scanner op=new Scanner(System.in);
 int choice =op.nextInt();
 
 if (choice ==1)
 {FCFS ch=new FCFS();try {ch.FCFSMethod(choic);} catch (IOException ex){System.err.println("Error In Filling Class ");}}
 

 else if (choice==2)
            {try {Priority pr=new Priority();pr.PriorityMethod(choic);} catch (IOException ex) {System.err.println("Error In Filling Class ");}}

 
 
  else if (choice==3)
            {RR w=new RR();w.RRMethod(choic);}

  
  
 else if (choice==4){SJF jf=new SJF();
 System.out.println(" Preemptive press 1 ");
  System.out.println(" Non-Preemptive press 2 ");
  Scanner o=new Scanner(System.in);
 int ch =o.nextInt();
 if(ch==1){PeemptiveSJF p=new PeemptiveSJF();p.preemptiveMethod(choic);}
else if(ch==2){SJF pr=new SJF();pr.nonpreemptive(choic);}
 
 }
 
 else{System.err.println("Invalid Input");}
}



    }
    
