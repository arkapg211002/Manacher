import java.util.*;
import java.lang.*;
import java.io.*;
class m
{
    static void findlongestpalindrome(String txt)
    {
        int n=txt.length();
        if(n==0)
        {
            return;
        }
        n=2*n+1;
        int l[]=new int[n+1];
        l[0]=0;
        l[1]=1;
        int c=1;
        int r=2;
        int i=0;
        int imirror;
        int maxlpslength=0;
        int maxlpscenterposition=0;
        int start=-1;
        int end=-1;
        int diff=-1;

        for(i=2;i<n;i++)
        {
            imirror=2*c-i;
            l[i]=0;
            diff=r-i;

            if(diff>0)
            {
                l[i]=Math.min(l[imirror],diff);
            }

            while(((i + l[i]) + 1 < n && (i - l[i]) > 0) && (((i + l[i] + 1) % 2 == 0) || (txt.charAt((i + l[i] + 1) / 2) == txt.charAt((i - l[i] - 1) / 2))))
            {
                l[i]++;
            }
            if(l[i]>maxlpslength)
            {
                maxlpslength=l[i];
                maxlpscenterposition=i;
            }
            if(i+l[i]>r)
            {
                c=i;
                r=i+l[i];
            }
        }

        start=(maxlpscenterposition-maxlpslength)/2;
        end=start+maxlpslength-1;
        System.out.println("Longest palindrome substring is: "+txt.substring(start,end+1));
        for(i=start;i<=end;i++)
        {
            System.out.print(txt.charAt(i));
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        String txt="babcbabcbaccba";
        findlongestpalindrome(txt);
    }
}