// This works for myhead command. This displays 1st 10 lines

#include"myheader.h"

int myHead(char f1name[], char f2name[])
{
	int fd1,k;
	int ln=1;
	char ch;
	int count;
	int i,len;
	int f2isdigit=1;
	//Finding the length of f2name variable
	len=strlen(f2name);
	//Removing "-"
	while (i<len)
	{
		f2name[i]=f2name[i+1];
		i++;
	}
	//Finding the length of f2name without "-"
	len=strlen(f2name);
	for (i=0;i<len;i++)
	{
		//Checking if f2name is a digit or not.
		if (!isdigit(f2name[i]))
		{
			f2isdigit=0;
			break;
		}
	}
	//Converting the string to integer if f2name is a digit
	if (f2isdigit == 1)
		count=atoi(f2name);
	//If f2name is not a number, taking the default as 10
	else
		count=10;
	//Opening the file to read
	fd1=open(f1name,O_RDONLY);
	if(fd1==-1)
		printf("No such File\n");
	//Reading file
	else
	{
		while(1)
		{
			k=read(fd1,&ch,1);
			if(k==0)
			{
				break;
			}
			else
			{
				//counting lines
				if(ch=='\n')
				{
					ln++;
				}
				//Checking the given line number
				if(ln>count)
					break;
				else
					printf("%c",ch);
			}
		}
		//Closing the file after reading
		close(fd1);
	}	
}	

