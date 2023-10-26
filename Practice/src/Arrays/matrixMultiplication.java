package Arrays;

public class matrixMultiplication { 
	public static void main(String args[]){  
		//creating two matrices    
		int a[][]={{1,2},{4,5}};    
		int b[][]={{1,2},{4,5}};    
			    
			//creating another matrix to store the multiplication of two matrices    
		int c[][]=new int[2][2];  //3 rows and 3 columns  
			    
			//multiplying and printing multiplication of 2 matrices    
		for(int i=0;i<2;i++){    
			for(int j=0;j<2;j++){    
					c[i][j]=0;      
					for(int k=0;k<2;k++)      
					{      
						c[i][j]+=a[i][k]*b[k][j];      
					}//end of k loop  
					System.out.print(c[i][j]+" ");  //printing matrix element  
			}//end of j loop  
			System.out.println();//new line    
		}    
	}
}  

