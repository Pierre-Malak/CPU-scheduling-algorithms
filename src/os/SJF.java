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
public class SJF {
    public void nonpreemptive()
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
         double totalbrst=0;
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
            

                   // Sorting brst items
                  
     
//     
       for(int h=0;h<no;h++)
             for (int k=0;k<no-(h+1);k++)
                {if(brst[k]>brst[k+1])
                { tmp=brst[k+1];
                brst[k+1]=brst[k];
                brst[k]=tmp;
                
                tmp=arrival[k+1];
                arrival[k+1]=arrival[k];
               arrival[k]=tmp;
                
                tmp=id[k+1];
                id[k+1]=id[k];
                id[k]=tmp;
                }
                  
                }
     
 int min=arrival[0];
 int endo;
 int count=0;
 
// Finding Smallest arrival time
  for(int a =0;a<no;a++)
 {if (arrival[a]<min){min=arrival[a];}}
  
  //Filling The Start & end
  
for(int i=0;i<no;i++)
{  if(arrival[i]==min)
    { count+=1;
       if(count==no)
        { for(int y=0;y<no;y++)
           {   if(y==0)
               { start[y]=arrival[y];
                 end[y]=start[y]+brst[y];
                 //endo=end[y];
               }
              else
               {
                  start[y]=end[y-1];end[y]=start[y]+brst[y];
               }
           }
        }
       
       else
       {
           for(int y=0;y<no;y++)
           {     if(arrival[y]==min)
                { start[y]=arrival[y];end[y]=start[y]+brst[y];
                 endo=end[y];

                 for(int j=0;j<no-1;j++)
                 {
      
                   start[j]=endo;end[j]=start[j]+brst[j];endo=end[j];
                  }
                }
           }
       }
    }   
}
  
 
 
   

//sorting the arrival times
    
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
                
                 tmp=start[i+1];
                start[i+1]=start[i];
                start[i]=tmp;
                
                 tmp=end[i+1];
                end[i+1]=end[i];
                end[i]=tmp;
                }
                }
            } 


    //Printing Results
     System.out.println("id  Arrival  Burst  start  end");
            BR.write("\n"+"id  Arrival  Burst  start  end \n ");
            for (int i=0;i<no;i++)
            {
                System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                totalbrst+=brst[i];
                totalend+=end[i];
                totalturnaroundtime+=end[i]-arrival[i];
                 
                BR.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
              
            }
            
                for(int j=0;j<no;j++)
            {
                for (int i=0;i<no-(j+1);i++)
                {if(start[i]>start[i+1])
                { tmp=start[i+1];
                start[i+1]=start[i];
                start[i]=tmp;
                
                tmp=brst[i+1];
                brst[i+1]=brst[i];
                brst[i]=tmp;
                
                tmp=id[i+1];
                id[i+1]=id[i];
                id[i]=tmp;
                }
                }
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
               
               
               
            wtime+=totalturnaroundtime-totalbrst;
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
             System.out.println("The Results Wrote In the File Results.txt"); 
            
        } 
        catch (IOException ex) {System.err.println("File NOt found SFJ");}
    
    }
    
    
    
    
    
    public void nonpreemptive(String choic) throws FileNotFoundException, IOException
    {   String a ;
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
         double wtime=0;
         double avgwtime,responstime;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
         double totalbrst=0;
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
        
        
        } for(int h=0;h<no;h++)
             for (int k=0;k<no-(h+1);k++)
                {if(brst[k]>brst[k+1])
                { tmp=brst[k+1];
                brst[k+1]=brst[k];
                brst[k]=tmp;
                
                tmp=arrival[k+1];
                arrival[k+1]=arrival[k];
               arrival[k]=tmp;
                
                tmp=id[k+1];
                id[k+1]=id[k];
                id[k]=tmp;
                }
                  
                }
     
 int min=arrival[0];
 int endo;
 int count=0;
// 
//  Finding The smallest arrival time
  for(int y =0;y<no;y++)
 {if (arrival[y]<min)min=arrival[y];}
   
  

// filling Start and end time of each proccess
    
for(int t=0;t<no;t++)
{  if(arrival[t]==min)
    { count+=1;
       if(count==no)
        { for(int y=0;y<no;y++)
           {   if(y==0)
               { start[y]=arrival[y];
                 end[y]=start[y]+brst[y];
                 //endo=end[y];
               }
              else
               {
                  start[y]=end[y-1];end[y]=start[y]+brst[y];
               }
           }
        }
       
       else
       {
           for(int y=0;y<no;y++)
           {     if(arrival[y]==min)
                { start[y]=arrival[y];end[y]=start[y]+brst[y];
                 endo=end[y];

                 for(int j=0;j<no-1;j++)
                 {
      
                   start[j]=endo;end[j]=start[j]+brst[j];endo=end[j];
                  }
                }
           }
       }
    }   
} 
       try (BufferedWriter BR = new BufferedWriter(new FileWriter("results.txt",true))) {


           
           
           
           
           
           
    //Printing Results
     System.out.println("id  Arrival  Burst  start  end");
            BR.write("\n"+"id  Arrival  Burst  start  end \n ");
            for (int u=0;u<no;u++)
            {
                System.out.println(id[u]+"     "+arrival[u]+"       "+brst[u]+"      "+start[u]+"    "+end[u]);
               totalbrst+=brst[u];
                totalend+=end[u];
                totalturnaroundtime+=end[u]-arrival[u];
                 
                BR.write(id[u]+"     "+arrival[u]+"       "+brst[u]+"      "+start[u]+"    "+end[u]+"\n");
              
            }
            
            
            
            
               for(int j=0;j<no;j++)
            {
                for (int k=0;k<no-(j+1);k++)
                {if(start[k]>start[k+1])
                { tmp=start[k+1];
                start[k+1]=start[k];
                start[k]=tmp;
                
                tmp=brst[k+1];
                brst[k+1]=brst[k];
                brst[k]=tmp;
                
                tmp=id[k+1];
                id[k+1]=id[k];
                id[k]=tmp;
                }
                }
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
            wtime+=totalturnaroundtime-totalbrst;
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
             System.out.println("The Results Wrote In the File Results.txt"); 
        } catch (IOException ex) {System.err.println("File NOt found SFJ");}
    
    
    }
    
    
}
