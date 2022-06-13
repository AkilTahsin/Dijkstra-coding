import java.util.*;
import java.io.*;

public class Lab06Task01{
  public static void main(String [] args) throws Exception{   
    File f = new File("Map.txt");
    FileReader fl = new FileReader(f);
    BufferedReader br = new BufferedReader(fl);
    
    String s = br.readLine();
    int c = Integer.parseInt(s);
    int [] [] map = new int [c][c];
    
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
      map[u][v] = w;
      map[v][u] = w;
    }
    int src = 12, dest = 13;
    
    System.out.println("M => Motijheel (Source) & N=> MOGHBAZAR (Destination)");
    System.out.print("  ");
    for(int k=0; k<map[0].length; k++)
      System.err.print((char)(k+65)+" ");
    System.out.println();
    for(int i=0; i<map.length; i++){
      System.err.print((char)(i+65)+" ");
      for(int j=0; j<map[0].length; j++){
        System.out.print(map[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
    
    Dijkstras(map, src, dest);
  }
  
  public static void Dijkstras(int [][] g, int src, int dest){
    int [] dist = new int [g.length];
    int [] parent = new int [g.length];
    int [] color = new int [g.length];
    for(int i=0; i<g.length; i++){
      parent[i] = 999;
    }
    
    dist [src] = 0;
    Queue<Integer> Q = new LinkedList<Integer>();
    for(int i=0; i<g.length; i++) Q.add(i);
    
    while(!Q.isEmpty()){
      int u = Q.remove();
      for(int v=0; v<g.length; v++){
        if(color[v] == 0 && g[u][v] != 0){
          if(dist[v] < dist[u] + g[u][v]){
            parent[v] = u;
            dist[v] = dist[u] + g[u][v];
          }
        }
        color[u]=1;
      }
    }
    
    Stack<String> Path = new Stack<String>();
    int p = parent[dest];
    while(p!=999){
      Path.push(""+(char)(p+65));
      p=parent[p];
    }
    System.out.print("Motijheel => ");
    while(!Path.isEmpty())
      System.out.print(Path.pop()+" => ");
    System.out.println("MOGHBAZAR");
  }
}