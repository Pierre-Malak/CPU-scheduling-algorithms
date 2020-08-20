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
public class RR {
   
    public void RRMethod()
    { int no,Qno;
   
        System.out.println("enter The no of processes");
  Scanner n=new Scanner(System.in);
   no=n.nextInt();
     int []id=new int [no];
        int []arrival=new int [no];
         int []brst=new int [no];
        int []start=new int [no];
        int []end=new int [no];
         int tmp;
         int wtime=0;
         double avgwtime,responstime,totalbrst=0;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
   System.out.println("enter The Quantum Number");
  Scanner nq=new Scanner(System.in);
   Qno=nq.nextInt();
   
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

    
            
             
              int counter[]=new int[no];
                int rrbrst[]=new int[no];
                boolean RR=true;
               boolean rr=true;
                //Creating Copy Of Brurst
                for(int i=0;i<no;i++)
                {rrbrst[i]=brst[i];}
                
                // implement counter
                       for(int i=0;i<no;i++)
                         {counter[i]=1;}
                
                       //implement array to help in printing
                       int endo=arrival[0];
                       
                       //Array to copy start array
                       int begin[]=new int [no];
                       for(int i=0;i<no;i++)
                       {if(i==0)
                          {
                              if(brst[i]<=Qno)
                           { start[i]=arrival[i];
                           end[i]=start[i]+brst[i];}else{ start[i]=arrival[i];
                           end[i]=start[i]+Qno;}
                            }
                       
                       else  {
                              if(brst[i]<=Qno)
                           { start[i]=end[i-1];
                           end[i]=start[i]+brst[i];}else{ start[i]=end[i-1];
                           end[i]=start[i]+Qno;}
                            }
                  totalbrst+=brst[i];
                totalend+=end[i];
            
                begin[i]=start[i];
                       }
                       
                       
                       
           
              
                       String ids=" ",value=" ";

                
                 while (RR)      
        {   
          
             for(int i=0;i<no;i++)
                { if (i==0&&counter[i]>0)
                    { if(rrbrst[i]<=Qno)
                        {  start[i]=endo;
                         
                          end[i]=start[i]+rrbrst[i];
                          endo=end[i];
                          counter[i]=-1;
              
                          ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                        }
                    
                      else if(rrbrst[i]>Qno)
                       {
                           start[i]=endo;
                          end[i]=start[i]+Qno;
                          endo=end[i];
                          rrbrst[i]=rrbrst[i]-Qno;
                   ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                        }
                      
                    }
                
                 else if(i!=0&&counter[i]>0)
                        { 
                            if(rrbrst[i]<=Qno)
                           {  start[i]=endo;
                             end[i]=start[i]+rrbrst[i];
                             endo=end[i];
                             counter[i]=-1;
                  ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                             
                           }
                    
                           else if(rrbrst[i]>Qno)
                            {
                                start[i]=endo;
                                end[i]=start[i]+Qno;
                                endo=end[i];
                               rrbrst[i]=rrbrst[i]-Qno;
                      
                               ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                            }
                         
                        }
                
                }
          
             int count=0;
            
                for(int i=0;i<no;i++)
           {
           
               
               if(counter[i]==-1)
                {
                   count+=1;
                   if(count==no)
                      {RR=false;}
                }
           }

        }
                 
                 
                  System.out.print("\n");BR.write("\n");
                 
                 

                 
                 

                 
                 
                 for(int i=0;i<no;i++)
                 {
                totalturnaroundtime+=end[i]-arrival[i];
                       }
                 
                 
                System.out.println("\n"+"id  Arrival  Burst  start  end");
      BR.write("\n"+"id  Arrival  Burst  start  end \n ");
int context=0;
        //  finding no of context switching
for (int i = 0; i < (ids.length()-5)/5; i++) {
  if (ids.charAt(i*5)!=ids.charAt((i*5)+5)){
      context++;     
}
  
}
context--;
ids+="\t|";
       value+="\t"+endo;

for(int i=0;i<no;i++)
{         System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+begin[i]+"    "+end[i]);
   BR.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+begin[i]+"    "+end[i]+"\n");
}

                 


    


      wtime+=totalturnaroundtime-totalbrst;
               responstime=(totalend)/no;
            avgwtime=  wtime/no;
            
            
               BR.write("The Gannt Chart is :-");
                  System.out.println("The Gannt Chart is :-");
                        System.out.println(ids);
                         System.out.println(value);
                           BR.write(ids);
                             BR.write(value);
            
            
            avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
            System.out.println("The Response Time is = "+ responstime);
            System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
              System.out.println("The NO OF Context= "+ context+"\n");
            BR.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            BR.write("The Response Time is = "+ responstime+"\n");
            BR.write("The Average Wating Time is = "+ avgwtime +"\n");
              BR.write("The NO OF Context= "+ context+"\n");
            BR.close();
             System.out.println("The Results Wrote In the File Results.txt"); 
    }   catch (IOException ex) {System.err.println("Error In RR Class");}
    
}
    
    
    
    
    
    
    
    
    
    public void RRMethod(String choic) throws FileNotFoundException, IOException
    {System.out.println("Be Sure That the file squence is like ");
                 System.out.println("id  Arrival  Burst !");
    int no,Qno;
   
        System.out.println("enter The no of processes");
  Scanner n=new Scanner(System.in);
   no=n.nextInt();
     int []id=new int [no];
        int []arrival=new int [no];
         int []brst=new int [no];
        int []start=new int [no];
        int []end=new int [no];
         int tmp;
         int wtime=0;
         double avgwtime,responstime,totalbrst=0;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
   System.out.println("enter The Quantum Number");
  Scanner nq=new Scanner(System.in);
   Qno=nq.nextInt();
               int b=0;
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
            
            
              id[b]=Integer.parseInt(v[0]);
             arrival[b]=Integer.parseInt(v[1]);
               brst[b]=Integer.parseInt(v[2]);
               //System.out.println(id[i]);
              b++;
            }
    
         } catch (IOException ex) { System.err.println("error 1");;}
          
          
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

    
            
             
              int counter[]=new int[no];
                int rrbrst[]=new int[no];
                boolean RR=true;
               boolean rr=true;
                //Creating Copy Of Brurst
                for(int i=0;i<no;i++)
                {rrbrst[i]=brst[i];}
                
                // implement counter
                       for(int i=0;i<no;i++)
                         {counter[i]=1;}
                
                       //implement array to help in printing
                       int endo=arrival[0];
                       
                       //Array to copy start array
                       int begin[]=new int [no];
                       for(int i=0;i<no;i++)
                       {if(i==0)
                          {
                              if(brst[i]<=Qno)
                           { start[i]=arrival[i];
                           end[i]=start[i]+brst[i];}else{ start[i]=arrival[i];
                           end[i]=start[i]+Qno;}
                            }
                       
                       else  {
                              if(brst[i]<=Qno)
                           { start[i]=end[i-1];
                           end[i]=start[i]+brst[i];}else{ start[i]=end[i-1];
                           end[i]=start[i]+Qno;}
                            }
                  totalbrst+=brst[i];
                totalend+=end[i];
            
                begin[i]=start[i];
                       }
                       
                       
                       
                   
                       String ids=" ",value=" ";

                
                 while (RR)      
        {   
          
             for(int i=0;i<no;i++)
                { if (i==0&&counter[i]>0)
                    { if(rrbrst[i]<=Qno)
                        {  start[i]=endo;
                         
                          end[i]=start[i]+rrbrst[i];
                          endo=end[i];
                          counter[i]=-1;
             ids+="\t|  p"+(i+1);
                      value+="\t"+start[i];
                        }
                    
                      else if(rrbrst[i]>Qno)
                       {
                           start[i]=endo;
                          end[i]=start[i]+Qno;
                          endo=end[i];
                          rrbrst[i]=rrbrst[i]-Qno;
                           ids+="\t|  p"+(i+1);
                      value+="\t"+start[i];
                        }
                      
                    }
                
                 else if(i!=0&&counter[i]>0)
                        { 
                            if(rrbrst[i]<=Qno)
                           {  start[i]=endo;
                             end[i]=start[i]+rrbrst[i];
                             endo=end[i];
                             counter[i]=-1;
                        ids+="\t|  p"+(i+1);
                      value+="\t"+start[i];
                             
                           }
                    
                           else if(rrbrst[i]>Qno)
                            {
                                start[i]=endo;
                                end[i]=start[i]+Qno;
                                endo=end[i];
                               rrbrst[i]=rrbrst[i]-Qno;
                      
                         ids+="\t|  p"+(i+1);
                      value+="\t"+start[i];
                            }
                         
                        }
                
                }
          
             int count=0;
            
                for(int i=0;i<no;i++)
           {
           
               
               if(counter[i]==-1)
                {
                   count+=1;
                   if(count==no)
                      {RR=false;}
                }
           }

        }
                 
                 
                  System.out.print("\n");B.write("\n");
                 
                 

                 

                 
                 
                 for(int i=0;i<no;i++)
                 {
                totalturnaroundtime+=end[i]-arrival[i];
                       }
                 
                 
                System.out.println("\n"+"id  Arrival  Burst  start  end");
      B.write("\n"+"id  Arrival  Burst  start  end \n ");



for(int i=0;i<no;i++)
{         System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+begin[i]+"    "+end[i]);
   B.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+begin[i]+"    "+end[i]+"\n");
}
                 
    
               
      wtime+=totalturnaroundtime-totalbrst;
               responstime=(totalend)/no;
            avgwtime=  wtime/no;
            avgturnaroundtime=totalturnaroundtime/no;
            
    int context=0;
        //  finding no of context switching
for (int i = 0; i < (ids.length()-5)/5; i++) {
  if (ids.charAt(i*5)!=ids.charAt((i*5)+5)){
      context++;     
}
  
}
context--;
ids+="\t|";
       value+="\t"+endo;

            
            
            
            B.write("The Gannt Chart is :-");
                  System.out.println("The Gannt Chart is :-");
                        System.out.println(ids);
                         System.out.println(value);
                           B.write(ids);
                             B.write(value);
            
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
            System.out.println("The Response Time is = "+ responstime);
            System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
             // System.out.println("The NO OF Context= "+ context+"\n");
            B.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            B.write("The Response Time is = "+ responstime+"\n");
            B.write("The Average Wating Time is = "+ avgwtime +"\n");
              //B.write("The NO OF Context= "+ context+"\n");
            B.close();
             System.out.println("The Results Wrote In the File Results.txt"); 
    }  // catch (IOException ex) {System.err.println("Error In RR Class");}
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    

