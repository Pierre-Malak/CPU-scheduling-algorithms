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
public class FCFS {
    public void FCFSMethod() throws IOException
    {System.out.println("enter The no of processes");
  Scanner n=new Scanner(System.in);
  int no=n.nextInt();
                int []id=new int [no];
        int []arrival=new int [no];
         int []brst=new int [no];
        int []start=new int [no];
        int []end=new int [no];
         int tmp;
         int wtime=0;
         double avgwtime,responstime;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
        //Filling Data
        try (BufferedWriter BR = new BufferedWriter(new FileWriter("results.txt",true))) {
          
            
                //Filling Data
            for (int i=0;i<no;i++)
            {
                id[i]=i+1;
                System.out.print("Enter the arrival time of ");
                System.out.println(i+1);
                Scanner ar=new Scanner(System.in);
                int arval=ar.nextInt();
                arrival[i]=arval;
                System.out.print("Enter the burst time of ");
                System.out.println(i+1);
                Scanner br=new Scanner(System.in);
                int burst=br.nextInt();
                brst[i]=burst;
            }                       
            

                   // Sorting Arrival items
            
            for(int j=0;j<no;j++)
            {
                for (int i=0;i<no-(j+1);i++)
                {if(arrival[i]>arrival[i+1])
                { tmp=arrival[i+1];
                arrival[i+1]=arrival[i];
                arrival[i]=tmp;
                
                tmp=brst[i+1];
                brst[i+1]=brst[i];
                brst[i]=tmp;
                
                tmp=id[i+1];
                id[i+1]=id[i];
                id[i]=tmp;
                }
                }
            }
            
            
            //Start & End
             for (int i=0;i<no;i++)
            {if(i==0)
            {start[i]=arrival[i];end[i]=arrival[i]+brst[i];}
               
          else  
            {start[i]=end[i-1];end[i]=start[i]+brst[i];}}
            
            
            
            
            
            // Printing Results
            System.out.println("id  Arrival  Burst  start  end");
            BR.write("\n"+"id  Arrival  Burst  start  end \n ");
            for (int i=0;i<no;i++){
                System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                wtime+=start[i];
                totalend+=end[i];
                totalturnaroundtime+=end[i]-arrival[i];
                BR.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
              
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
             responstime=(totalend+wtime)/no;
            avgwtime=  wtime/no;
             avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
              System.out.println("The Response Time is = "+ responstime);
                 System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
                   System.out.println("The NO OF Context= "+ (no-1)+"\n");
            BR.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            BR.write("The Response Time is = "+ responstime+"\n");
            BR.write("The Average Wating Time is = "+ avgwtime +"\n");
              BR.write("The NO OF Context= "+ (no-1)+"\n");
              BR.close();
              
              
        }
    System.out.println("The Results Wrote In the File Results.txt");     
    }
    
    
    
    
     public void FCFSMethod(String choic) throws FileNotFoundException, IOException
     {  String a ;
     System.out.println("Be Sure That the file squence is like ");
                 System.out.println("id  Arrival  Burst !");
     System.out.println("Enter the no OF Proccess");
     Scanner n=new Scanner(System.in);
       int no=n.nextInt();
      int []id;
      id=new int [no];
        int []arrival;
        arrival=new int [no];
         int []brst;
         brst=new int [no];
        int []start=new int [no];
        int []end=new int [no];
         int tmp;
         int wtime=0;
         double avgwtime,responstime;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
       int i=0;
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
            arrival[i]=Integer.parseInt(v[1]);
            brst[i]=Integer.parseInt(v[2]);
            //System.out.println(id[i]);
            i++;
            
          
            
            }
            
            // Sorting Arrival items
            
            for(int j=0;j<no;j++)
            {
                for (int h=0;h<no-(j+1);h++)
                {if(arrival[h]>arrival[h+1])
                { tmp=arrival[h+1];
                arrival[h+1]=arrival[h];
                arrival[h]=tmp;
                
                tmp=brst[h+1];
                brst[h+1]=brst[h];
                brst[h]=tmp;
                
                tmp=id[h+1];
                id[h+1]=id[h];
                id[h]=tmp;
                }
                }
            }
            
            //Start & end Time
            for ( int g=0;g<no;g++)
            {if(i==0){start[g]=arrival[g];end[g]=arrival[g]+brst[g];}
             else {start[i]=end[i-1];end[g]=arrival[g]+brst[g];}
            }
            
            
            
            
            
            // Printing Results
            System.out.println("id  Arrival  Burst  start  end");
            BufferedWriter B = new BufferedWriter(new FileWriter("results.txt",true));
            B.write("\n"+"id  Arrival  Burst  start  end \n ");
            for ( int k=0;k<no;k++){
                System.out.println(id[k]+"     "+arrival[k]+"       "+brst[k]+"      "+start[k]+"    "+end[k]);
               
                B.write(id[k]+"     "+arrival[k]+"       "+brst[k]+"      "+start[k]+"    "+end[k]+"\n");
              
                wtime+=start[k];
                totalend+=end[k];
                totalturnaroundtime+=end[k]-arrival[k];
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
             responstime=(totalend+wtime)/no;
            avgwtime=  wtime/no;
            avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
            System.out.println("The Response Time is = "+ responstime);
            System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
              System.out.println("The NO OF Context= "+ (no-1)+"\n");
            B.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            B.write("The Response Time is = "+ responstime+"\n");
            B.write("The Average Wating Time is = "+ avgwtime +"\n");
              B.write("The NO OF Context= "+ (no-1)+"\n");
            B.close();
        }
              
              
              
                  System.out.println("The Results Wrote In the File Results.txt"); 
        }
    
    }
    
         
          
       
        
       


