/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.summativesums;

/**
 *
 * @author Olayinka
 */
public class summativeSums {
    public static void main(String[] args){
        
        int[] a = { 10, 20, 5, 25, 15};
        int[] b = { 18, 30, 55, 2 , 23};
        int[] c = { -30, -24, -10, -26, -7};
           sumOfArrays(a);
           sumOfArrays(b);
           sumOfArrays(c );
        
    }
    public static void sumOfArrays(int[] num){
            int sum = 0;
            
            for (int i = 0; i < num.length; i++){
                
                sum = sum + num[i];
                
                
            }
            
                
            System.out.println(sum);
            
        }
}
