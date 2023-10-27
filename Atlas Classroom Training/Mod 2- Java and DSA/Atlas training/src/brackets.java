import java.util.Stack;
import java.util.*;
public class brackets {
	 public void isValid(String s) 
	 {
		 	int b=0,p=0,sb=0,bc=0,pc=0,sbc=0,bcl=0,bclc=0,pc0,pclc=0,sbcl=0,sbclc=0;
	        for (int i=0;i<s.length();i++)
	        {
	        	c=s.charAt(i);
	        
	        	if (c=='(')
	        	{
	        		b=i;
	        		bc++;
	        	}
	        	if (c=='{')
	        	{
	        		p=i;
	        		pc++;
	        	}
	        	if (c=='[')
	        	{
	        		sb=i;
	        		sbc++;
	        	}
	        	if (c==')')
	        	{
	        		b=i;
	        		bc++;
	        	}
	        	if (c=='}')
	        	{
	        		b=i;
	        		bc++;
	        	}
	        	if (c==']')
	        	{
	        		b=i;
	        		bc++;
	        	}
	        }
	        
	           
	        
	 }
/*
	  public boolean isValid(String s) {
	        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
	            s = s.replaceAll("\\(\\)", "")
	              .replaceAll("\\[\\]", "")
	              .replaceAll("\\{\\}", "");
	        }
	        return (s.length() == 0);
	    }
*/
	 public static void main(String args[])
	 {
		 brackets br = new brackets();
		 String s = "()(([]))";
		 boolean a;
		 a=br.isValid(s);
		 System.out.println(a);
	 }
}
