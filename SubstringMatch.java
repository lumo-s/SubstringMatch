/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.substringmatch;

/**
 *
 * @author 86139
 */
public class SubstringMatch {
    
    private SubstringMatch(){}
    
    //在s中寻找t,并返回匹配的第一个索引i;如果没有找到，返回-1
    public static int bruteforce(String s,String t){
        
        if(s.length()<t.length()) return -1;
        
        //s[i,i+t.length-1]==t?
        for(int i=0;i+t.length()-1<s.length();i++){
            
            int j=0;
            
            for(;j<t.length();j++)
                if(s.charAt(i+j)!=t.charAt(j))
                    break;    
            
            if(j==t.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1="hello,quejiaoxiansheng.";
        String t1="xiansheng";
        System.out.println(SubstringMatch.bruteforce(s1, t1));
    }
}
