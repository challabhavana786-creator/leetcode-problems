import java.util.*;
class LongestCommonPrefix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        if(n==0){
            System.out.println("");
            return;
        }
        String prefix = sc.nextLine();
        if(prefix == null || prefix.isEmpty()){
            System.out.println("");
            return;
        }
        for(int i=1;i<n;i++){
            String strs = sc.nextLine();
            while(!strs.startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    System.out.println("");
                    return;
                }
            }
        }
        System.out.println(prefix);
        sc.close();
    }
}