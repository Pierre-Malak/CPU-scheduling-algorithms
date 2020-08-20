/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr
 */
public class Priority {
    public void PriorityMethod()
    {  System.out.println("Enter the no OF Proccess");
     Scanner n=new Scanner(System.in);
       int no=n.nextInt();
                  int []id=new int [no];
        int []arrival=new int [no];
         int []brst=new int [no];
        int []start=new int [no];
        int []end=new int [no];
        int []priority=new int [no];
         int tmp;
        double wtime=0;
         double avgwtime,avgresponstime;
         int totalend=0;
         int totalturnaroundtime=0;
         double avgturnaroundtime=0;
   
            try (BufferedWriter BR = new BufferedWriter(new FileWriter("results.txt",true))) {
         //Filling Data in arrays
         
         for (int i=0;i<no;i++)
            {
                id[i]=i+1;
                System.out.print("Enter the Priority of ");
                System.out.println(i+1);
                Scanner ar=new Scanner(System.in);
                int arval=ar.nextInt();
                priority[i]=arval;
                System.out.print("Enter the burst time of ");
                System.out.println(i+1);
                Scanner br=new Scanner(System.in);
                int burst=br.nextInt();
                brst[i]=burst;
            }                 
    
    
    //Sorting Priorities
    
     //  System.out.println("id  Arrival  Burst  start  end");
          for(int j=0;j<no;j++)
            {
                for (int i=0;i<no-(j+1);i++)
                {if(priority[i]>priority[i+1])
                { tmp=priority[i+1];
                priority[i+1]=priority[i];
                priority[i]=tmp;
                
                tmp=brst[i+1];
                brst[i+1]=brst[i];
                brst[i]=tmp;
                
                tmp=id[i+1];
                id[i+1]=id[i];
                id[i]=tmp;

                }
                }
            }
          
          
          
          
                  //Start & end Time
            for (int i=0;i<no;i++)
            {if(priority[i]==1)
            {arrival[i]=0;start[i]=arrival[i];end[i]=arrival[i]+brst[i];}
               
          else  
            {arrival[i]=end[i-1];end[i]=arrival[i]+brst[i];start[i]=arrival[i];}}
            
            
            
            
            
             // Printing Results
            
            System.out.println("id Priority Arrival  Burst  start  end");
            BR.write("\n"+"id Priority  Arrival  Burst  start  end \n ");
            for (int i=0;i<no;i++){
                System.out.println(id[i]+"     "+priority[i]+"        "+arrival[i]+"       "+brst[i]+"       "+start[i]+"     "+end[i]);
                wtime+=start[i];
                totalend+=end[i];
                totalturnaroundtime+=start[i]+brst[i];
                BR.write(id[i]+"     "+priority[i]+"        "+arrival[i]+"       "+brst[i]+"       "+start[i]+"     "+end[i]);
              
            }
            
           String ids="",value="";
            //printing sequence
      
            for(int e=0;e<no;e++)
            {     ids+="\t| P"+id[e];
                          value+="\t"+start[e];}
            
            
            
            
            
               // Printing avg waiting time , response time and the turnaround time 
               
               
                BR.write("The Gannt Chart is :-");
                  System.out.println("The Gannt Chart is :-");
                        System.out.println(ids);
                         System.out.println(value);
                           BR.write(ids);
                             BR.write(value);
            
            // Printing avg waiting time , response time and the turnaround time 
            avgresponstime=(totalend+wtime)/no;
            avgwtime=  wtime/no;
             avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
              System.out.println("The Avg Response Time is = "+ avgresponstime);
                 System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
                   System.out.println("The NO OF Context= "+ (no-1)+"\n");
            BR.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            BR.write("The Response Time is = "+ avgresponstime+"\n");
            BR.write("The Average Wating Time is = "+ avgwtime +"\n");
              BR.write("The NO OF Context= "+ (no-1)+"\n");
            
              BR.close();
        
    System.out.println("The Results Wrote In the File Results.txt");     
    }   catch (IOException ex) {
               System.err.println("Error in Priority Class");
        }
}
    
    
    
    
    
    
    
    
     public void PriorityMethod(String choic) throws FileNotFoundException, IOException
     {
         System.out.println("Be Sure That the file squence is like ");
                 System.out.println("id  Priority  Burst !");
     System.out.println("Enter the no OF Proccess");
     Scanner n=new Scanner(System.in);
       int no=n.nextInt();
                  int []id=new int [no];
        int []arrival=new int [no];
         int []brst=new int [no];
         int []start=new int [no];
         int []end=new int [no];
         int []priority=new int [no];
         int tmp;
         double wtime=0;
         double avgwtime,avgresponstime;
         int totalend=0;
         int totalturnaroundtime=0;
         double avgturnaroundtime=0;
               int i=0;
               String a;
               BufferedWriter B = new BufferedWriter(new FileWriter("results.txt",true));
               
               //read From File
         Scanner scan = new Scanner(new File(choic+".txt"));
        
        
           FileReader File=new FileReader(choic+".txt");
          try (BufferedReader BR = new BufferedReader(File)) {
            String ST;
            
            
           //Reading From Files And save to arrays
        
            while((ST=BR.readLine())!=null)
            {
            
  
              a=scan.nextLine();
              String[]v=a.split(" ");
            
            
              id[i]=Integer.parseInt(v[0]);
              priority[i]=Integer.parseInt(v[1]);
               brst[i]=Integer.parseInt(v[2]);
               //System.out.println(id[i]);
              i++;
            }
    
         } catch (IOException ex) { System.err.println("error 1");;}
          
          
          
             //Sorting Priorities
    
    
              for(int j=0;j<no;j++)
            {
                for (int g=0;g<no-(j+1);g++)
                {if(priority[g]>priority[g+1])
                { tmp=priority[g+1];
                priority[g+1]=priority[g];
                priority[g]=tmp;
                
                tmp=brst[g+1];
                brst[g+1]=brst[g];
                brst[g]=tmp;
                
                tmp=id[g+1];
                id[g+1]=id[g];
                id[g]=tmp;

                }
                }
            }
          
          
          
          
                  //Start & end Time
                for (int k=0;k<no;k++)
            {if(priority[k]==1)
            {arrival[k]=0;start[k]=arrival[k];end[k]=arrival[k]+brst[k];}
               
          else  
            {arrival[k]=end[k-1];end[k]=arrival[k]+brst[k];start[k]=arrival[k];}}
            
            
            
            
            
             // Printing Results
            System.out.println("id Priority Arrival  Burst  start  end");
            B.write("\n"+"id Priority  Arrival  Burst  start  end \n ");
            for (int p=0;p<no;p++){
                
                System.out.println(id[p]+"     "+priority[p]+"        "+arrival[p]+"       "+brst[p]+"       "+start[p]+"     "+end[p]);
                wtime+=start[p];
                totalend+=end[p];
                totalturnaroundtime+=start[p]+brst[p];
                B.write(id[p]+"     "+priority[p]+"        "+arrival[p]+"       "+brst[p]+"       "+start[p]+"     "+end[p]+"\n");
              
            }
            
            
            
   String ids="",value="";
            //printing sequence
           
            for(int e=0;e<no;e++)
            {     ids+="\t| P"+id[e];
                          value+="\t"+start[e];}
            
            
            
            
            
               // Printing avg waiting time , response time and the turnaround time 
               
               
                B.write("The Gannt Chart is :-");
                  System.out.println("The Gannt Chart is :-");
                        System.out.println(ids);
                         System.out.println(value);
                           B.write(ids);
                             B.write(value);
            
            
            
            // Printing avg waiting time , response time and the turnaround time 
            avgresponstime=(totalend+wtime)/no;
            avgwtime=  wtime/no;
             avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
              System.out.println("The Avg Response Time is = "+ avgresponstime);
                 System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
                   System.out.println("The NO OF Context= "+ (no-1)+"\n");
            B.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            B.write("The Response Time is = "+ avgresponstime+"\n");
            B.write("The Average Wating Time is = "+ avgwtime +"\n");
              B.write("The NO OF Context= "+ (no-1)+"\n");
            
              B.close();
        
                    System.out.println("The Results Wrote In the File Results.txt");     
                      }   //catch (IOException ex) { System.err.println("Error in Priority Class");}
          
          
     }
