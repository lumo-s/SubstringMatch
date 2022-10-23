/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.leetcode1147;

/**
 *
 * @author 86139
 */
public class Leetcode1147 {
    
    private static int le9;
    private static final long MOD=(long)(le9+7);
    private static long[]pow26;
    
    public static int longestDecomposition(String text) {
        
        //pow26[i]=26^i
        pow26=new long[text.length()];
        pow26[0]=1;
        for(int i=1;i<text.length();i++)
            pow26[i]=pow26[i-1]*26%MOD;//求余避免溢出
        
        return solve(text,0,text.length()-1);

    }
    
    //s[left,right]
    private static int solve(String s,int left,int right){
        
        if(left>right) return 0;
        
        long prehash=0,posthash=0;
        
        for(int i=left,j=right;i<j;i++,j--){
            
            prehash=(prehash*26+(s.charAt(i)-'a'));
            posthash=((s.charAt(j)-'a')*pow26[right-j]+posthash)%MOD;
            //s[left,i]==s[j,right]
            if(prehash==posthash&&equal(s,left,i,j,right))//可能有哈希冲突
                return 2+solve(s,i+1,j-1);
        }
        return 1;
    }
    
    private static boolean equal(String s,int l1,int r1,int l2,int r2){
        
        for(int i=l1,j=l2;i<=r1&&j<=r2;i++,j++)
            if(s.charAt(i)!=s.charAt(j)) return false;
        return true;
    }

    public static void main(String[] args) {
        String s="ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(longestDecomposition(s));
    }
}
