package niuke.alibaba;

import java.util.*;

/**
 * 小强去春游
 * https://www.nowcoder.com/questionTerminal/ee3013ca07264e62801cc976bba05d1a
 *
 * 剩余人数不少于4的时候，比较如下两种操作方案看哪一种用时更少：
 * 1.最轻的人由重到轻每次带过去一个人然后开船回来（为了和方案2对齐，每次也只运2个人）；
 * 2.最轻和次轻的过去，然后最轻的回来让最重的两个过去，次轻的在那边把船再开回来。一共运过去了2个人。
 * 这样一来，人数少于4的时候要么只有最轻的3个人，要么只有最轻的2个人。如果还剩3个人，就让最轻的每次带一个；
 * 如果还剩2个人，就直接两个人过河了。
 */
public class SpringOuting {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while(T-- > 0){
            int n = cin.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = cin.nextInt();
            }
            Arrays.sort(a);
            int res = 0;
            while(n > 3){
                int planA = 2 * a[0] + a[n - 1] + a[n - 2];
                int planB = a[0] + 2 * a[1] + a[n - 1];
                res += Math.min(planA, planB);
                n -= 2;
            }
            if(n == 3){
                res += a[0] + a[1] + a[2];
            }else if(n == 2){
                res += a[1];
            }
            System.out.println(res);
        }
    }
}
