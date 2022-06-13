import java.util.*;
import java.io.*;

public class Lab06Test{
  public static void main(String [] args) throws Exception{   
    File f = new File("Map.txt");
    FileReader fl = new FileReader(f);
    BufferedReader br = new BufferedReader(fl);
    
    String s = br.readLine();
    int c = Integer.parseInt(s);
    vertice [] map = new vertice [c];
    
    s = br.readLine();
    StringTokenizer st = new StringTokenizer(s," ");
    String source = st.nextToken();
    String destination = st.nextToken();
    
    while((s=br.readLine()) != null){
      st = new StringTokenizer(s, " ");
      String a = st.nextToken();
      String b = st.nextToken();
      int u, v;
      if(a.equals("Motijheel")) u = 12; 
      else if(a.equals("MOGHBAZAR")) u = 13;
      else u = ((int)a.charAt(0)) - 65;
      
      if(b.equals("Motijheel")) v = 12;
      else if(b.equals("MOGHBAZAR")) v = 13;
      else v = ((int)b.charAt(0)) - 65;
      
      int w = Integer.parseInt(st.nextToken());
//      map[u][v] = w;
//      map[v][u] = w;
    }
    int src = 12, dst = 13;
    
//    System.out.println("M => Motijheel (Source) & N=> MOGHBAZAR (Destination)");
//    System.out.print("  ");
//    for(int k=0; k<map[0].length; k++)
//      System.err.print((char)(k+65)+" ");
//    System.out.println();
//    for(int i=0; i<map.length; i++){
//      System.err.print((char)(i+65)+" ");
//      for(int j=0; j<map[0].length; j++){
//        System.out.print(map[i][j]+" ");
//      }
//      System.out.println();
//    }
  }
  
  public static void Dijkstras(int [][] graph, int s, int d){
  }
}