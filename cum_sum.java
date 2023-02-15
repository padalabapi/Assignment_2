import java.util.Scanner;
import java.util.ArrayList;
public class cum_sum {
    public static void main(String args[])
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        int x[],n;
        n = sc.nextInt();
        x = new int[n];
        for(int i=0;i<n;i++)
        {
            x[i] = sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+x[i];
            list.add(sum);
        }
        System.out.println(list);

    }
}
