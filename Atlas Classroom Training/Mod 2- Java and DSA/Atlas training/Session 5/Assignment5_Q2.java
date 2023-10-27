
public class Assignment5_Q2 
{
	public static void main(String args[])
	{
		HashFunction hash1 = new HashFunction();
		hash1.hashing("abcdef");
		hash1.hashing("xyz");
		hash1.hashing("abcxyz");
		hash1.display();
	}

}
