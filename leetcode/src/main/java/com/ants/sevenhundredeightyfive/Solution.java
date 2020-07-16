package com.ants.sevenhundredeightyfive;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lyy
 * @Deprecated
 * @date 2020/7/16
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(isBipartite(new int[][] {{1,3}, {0,2}, {1,3}, {0,2}})) ;
    }
    private static  final  int UNCOLORED=0;
    private static final  int RED=1;
    private static final  int GREEN=2;
    private int[] color;
    public static boolean isBipartite(int[][] graph) {
       int n=graph.length;
         int[] color;
         color=new int[n];
         Arrays.fill(color,UNCOLORED);
         for (int i=0;i<n;i++){
             if (color[i]==UNCOLORED){
                 Queue<Integer> queue=new LinkedList<>();
                 queue.offer(i);
                 color[i]=RED;
                 while (!queue.isEmpty()){
                     int node=queue.poll();
                     int cNei=color[node]==RED?GREEN:RED;
                     for (int neighbor:graph[node]){
                         if (color[neighbor]==UNCOLORED){
                             queue.offer(neighbor);
                             color[neighbor]=cNei;
                         }
                         else if (color[neighbor]!=cNei){
                             return false;
                         }
                     }
                 }
             }
         }
         return true;
    }
}
