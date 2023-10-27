//This works for mytail function

#include"myheader.h"

int myTail(char f1name[], char f2name[])
{
	int fd,pos=0,rev,k;
	char ch;
	int i=0,len;
	int f2isdigit=1,count;	
	//Finding length of f2name
	len=strlen(f2name);
	//Removing "-" from the string
	while (i<len)
	{
		f2name[i]=f2name[i+1];
		i++;
	}
	//Finding new length
	len=strlen(f2name);
	for (i=0;i<len;i++)
	{
		//Checking if f2name is digit or not
		if (!isdigit(f2name[i]))
		{
			f2isdigit=0;
			break;
		}
	}
	//If f2name is digit, converting it to integer
	if (f2isdigit == 1)
		count=atoi(f2name);
	//If f2name is not a number, taking default value for tail.
	else
		count=10;
	
	//Opening the file for reading
	fd=open(f1name,O_RDONLY);
	//Checking if the file exists or not
	if (fd == -1)
		printf("No such file");

	else
	{
		//Sending the cursor to the end of the file
		rev=lseek(fd,0,SEEK_END);
		while (1)
		{
			//Sending the cursor to the line where print starts
			k=read(fd,&ch,1);
			lseek(fd,-2,SEEK_CUR);
			if (ch == '\n')
			{
				pos++;
				if (pos == count)
				{
					k=read(fd,&ch,1);
					break;
				}
			}
		}
	//Sending the cursor to the next line, where reading starts
	k=read(fd,&ch,1);
	//Reading the file
	while (1)
	{
		k=read(fd,&ch,1);
		if (k==0)
			break;
		
		printf("%c",ch);
	}
		
	//Closing the file after reading
	close(fd);
	}
}
