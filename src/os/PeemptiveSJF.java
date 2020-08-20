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

/**
 *
 * @author Mr
 */
public class PeemptiveSJF {
    public void preemptive() throws IOException
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
              String ids="",value="";
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
            
    //Sorting Arrival Items
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
      
            
      //start & end
            int rrbrst[]=new int[no];
                 for(int i=0;i<no;i++)
                {rrbrst[i]=brst[i];}
                 int endo=arrival[0];
                
                 int min=rrbrst[0];
                   int counter[]=new int[no];
                   int c=0;
                   int count=0;
                   int max=0;
                   for(int i=0;i<no;i++)
                   {if(arrival[i]>max)
                       
                       
                       max=arrival[i];}
     BR.write("\n"+"id  Arrival  Burst  start  end \n ");
         System.out.println("\n"+"id  Arrival  Burst  start  end");
     int w=0;
      
      {for(int i=0;i<no;i++)
      { totalbrst+=brst[i];
           
           if(endo<max&&counter[w]!=1)
           {
               start[i]=endo;
           end[i]=arrival[i+1];
           endo=end[i];
           rrbrst[i]=rrbrst[i]-(arrival[i+1]-arrival[i]);
               System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                   BR.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
                   
                          ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                           totalend+=endo;
                              totalturnaroundtime+=end[i]-arrival[i];
           if(rrbrst[i]<=0)
           {counter[i]=1;}
           
           
           }
             }
      
      
      for(int i=0;i<no;i++)
      {  if(endo>=max&&counter[i]==0)
           {
                   for(int j=0;j<no;j++)
            {
                for (int l=0;l<no-(j+1);l++)
                {if(rrbrst[l]>rrbrst[l+1])
                { tmp=rrbrst[l+1];
              rrbrst[l+1]=rrbrst[l];
                rrbrst[l]=tmp;
                
                tmp=arrival[l+1];
                arrival[l+1]=arrival[l];
                arrival[l]=tmp;
                
                tmp=id[l+1];
                id[l+1]=id[l];
                id[l]=tmp;
                
                 tmp=counter[l+1];
                counter[l+1]=counter[l];
                counter[l]=tmp;
                }
                }
            }
               
               
            
               
               if(counter[i]!=1)
               {
               start[i]=endo;
           end[i]=start[i]+rrbrst[i];
           endo=end[i];
           counter[i]=1;
               System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                   BR.write(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
                   
                          ids+="\t| P"+id[i];
                          value+="\t"+start[i];
                          totalend+=endo;
                            totalturnaroundtime+=end[i]-arrival[i];
                           
                          
               }
               
           }
        
      }
          
      }    int context=0;
        //  finding no of context switching
for (int i = 0; i < (ids.length()-5)/5; i++) {
  if (ids.charAt(i*5)!=ids.charAt((i*5)+5)){
      context++;     
}
  
}
context--;
ids+="\t|";
       value+="\t"+endo;
      
      
      
      
      

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
            //System.out.println("The Response Time is = "+ responstime);
            System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
              System.out.println("The NO OF Context= "+ context+"\n");
            BR.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
           // BR.write("The Response Time is = "+ responstime+"\n");
            BR.write("The Average Wating Time is = "+ avgwtime +"\n");
              BR.write("The NO OF Context= "+ context+"\n");
            BR.close();
             System.out.println("The Results Wrote In the File Results.txt"); 
                             
                             
        }

    }
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public void preemptiveMethod(String choic) throws FileNotFoundException, IOException
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
         double wtime=0;
         double avgwtime,responstime;
         int totalend=0;
         int totalturnaroundtime=0;
         int avgturnaroundtime=0;
         double totalbrst=0;
       int q=0;
       String ids="",value="";
       
       
        try (BufferedWriter B = new BufferedWriter(new FileWriter("results.txt",true))) {
            Scanner scan = new Scanner(new File(choic+".txt"));
            FileReader File=new FileReader(choic+".txt");
            try (BufferedReader BR = new BufferedReader(File)) {
                String ST;
                
                
                //Reading From Files And save to arrays
                
                while((ST=BR.readLine())!=null)
                {
                    
                    
                    a=scan.nextLine();
                    String[]v=a.split(" ");
                    
                    
                    id[q]=Integer.parseInt(v[0]);
                    arrival[q]=Integer.parseInt(v[1]);
                    brst[q]=Integer.parseInt(v[2]);
                    //System.out.println(id[i]);
                    q++;
                    
                    
                    
                }
            }
            //Sorting Arrival Items
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
            //start & end
            int rrbrst[]=new int[no];
            for(int i=0;i<no;i++)
            {rrbrst[i]=brst[i];}
            int endo=arrival[0];
            int min=rrbrst[0];
            int counter[]=new int[no];
            int c=0;
            int count=0;
            int max=0;
            
            
            
            
            for(int i=0;i<no;i++)
            {if(arrival[i]>max)
                
                
                max=arrival[i];}
            B.write("\n"+"id  Arrival  Burst  start  end \n ");
            System.out.println("\n"+"id  Arrival  Burst  start  end");
            int w=0;
            {for(int i=0;i<no;i++)
            { totalbrst+=brst[i];
            
            if(endo<max&&counter[w]!=1)
            {
                start[i]=endo;
                end[i]=arrival[i+1];
                endo=end[i];
                rrbrst[i]=rrbrst[i]-(arrival[i+1]-arrival[i]);
                System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                B.write("\n"+id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
                
                ids+="\t|P"+id[i];
                value+="\t"+start[i];
                totalend+=endo;
                    totalturnaroundtime+=end[i]-arrival[i];
                if(rrbrst[i]<=0)
                {counter[i]=1;}
                
                
                
            }
            }
            
            
            for(int i=0;i<no;i++)
            {  if(endo>=max&&counter[i]==0)
            {
                for(int j=0;j<no;j++)
                {
                    for (int l=0;l<no-(j+1);l++)
                    {if(rrbrst[l]>rrbrst[l+1])
                    { tmp=rrbrst[l+1];
                    rrbrst[l+1]=rrbrst[l];
                    rrbrst[l]=tmp;
                    
                    tmp=arrival[l+1];
                    arrival[l+1]=arrival[l];
                    arrival[l]=tmp;
                    
                    tmp=id[l+1];
                    id[l+1]=id[l];
                    id[l]=tmp;
                    
                    tmp=counter[l+1];
                    counter[l+1]=counter[l];
                    counter[l]=tmp;
                    }
                    }
                }
                
                
                
                
                if(counter[i]!=1)
                {
                    start[i]=endo;
                    end[i]=start[i]+rrbrst[i];
                    endo=end[i];
                    counter[i]=1;
                    System.out.println(id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]);
                    B.write("\n"+id[i]+"     "+arrival[i]+"       "+brst[i]+"      "+start[i]+"    "+end[i]+"\n");
                    
                    ids+="\t|P"+id[i];
                    value+="\t"+start[i];
                    totalend+=endo;
                 totalturnaroundtime+=end[i]-arrival[i];
                    
                    
                }
                
            }
            
            }
            
            }
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
          
            
            wtime+=totalturnaroundtime-totalbrst;
            responstime=(totalend)/no;
            avgwtime=  wtime/no;
            B.write("The Gannt Chart is :-");
            System.out.println("The Gannt Chart is :-");
            System.out.println(ids);
            System.out.println(value);
            B.write(ids);
            B.write(value);
            avgturnaroundtime=totalturnaroundtime/no;
            System.out.println("\n"+"The Average Wating Time is = "+ avgwtime);
          //  System.out.println("The Response Time is = "+ responstime);
            System.out.println("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
            System.out.println("The NO OF Context= "+ context+"\n");
            B.write("The avg Turn around Time is = "+ avgturnaroundtime+"\n");
           // B.write("The Response Time is = "+ responstime+"\n");
            B.write("The Average Wating Time is = "+ avgwtime +"\n");
            B.write("The NO OF Context= "+ context+"\n");
        }
             System.out.println("The Results Wrote In the File Results.txt"); 
            
            
            
            
            
        
        
        
        
        
        
        
        
        
        
        
   }
}
