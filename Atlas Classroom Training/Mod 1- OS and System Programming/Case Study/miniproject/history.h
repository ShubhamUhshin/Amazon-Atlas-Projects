#include"myheader.h"

int myHistory(char input[])
{
	int fd1,k;
	char file[]="CommandHistory.txt";
	
	//Creating file to store history command
	fd1=open(file,O_CREAT,0777);
	fd1=open(file,O_RDWR|O_APPEND);
	char ch;
	
	int count=1;
	//counting the number of lines
	while (1)
	{
		k=read(fd1,&ch,1);
		if (k==0)
			break;
		else
		{
			if (ch=='\n')
				count++;
		}
	}

	//If line is 50
	if (count == 51)
	{
		//Taking a temp file for storing last 49 commands		
		char Tf[]="TempFile.txt";
		int fd2;	

		//Sending the cursor back to the first line
		lseek(fd1,0,SEEK_SET);
		
		//Sending the cursor to second line
		while (1)
		{
			k=read(fd1,&ch,1);
			if (k==0)
				break;
			else
			{
				if (ch=='\n')
					break;
			}
		}
		
		//Creating a temporary file to store the data
		fd2=open(Tf,O_CREAT,0777);
		fd2=open(Tf,O_RDWR);
		
		//Writing the data into second file
		while (1)
		{
			k=read(fd1,&ch,1);
			if (k==0)
				break;
			else
				write(fd2,&ch,1);
		}
		//Deleting the first file
		remove(file);
		
		//Sending the cursor to 1st line of 2nd file to read	
		lseek(fd2,0,SEEK_SET);
		//Creating the first file again
		fd1=open(file,O_CREAT,0777);
		fd1=open(file,O_RDWR|O_APPEND);
		//Writing into the first file
		while (1)
		{
			k=read(fd2,&ch,1);
			if (k==0)
				break;
			else
				write(fd1,&ch,1);
		}
		//Removing second file
		remove(Tf);
	}
	
	//Sending the cursor to the last line
	lseek(fd1,0,SEEK_END);
	char nextLine[]="\n";
	write(fd1,input,strlen(input));
	//Sending the cursor to the next line for the next command
	write(fd1,nextLine,strlen(nextLine));
	//Closing the file after writing
	close(fd1);
}
