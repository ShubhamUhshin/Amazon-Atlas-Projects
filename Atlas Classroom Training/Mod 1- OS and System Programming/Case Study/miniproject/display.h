// mycat function calls this

#include"myheader.h"
int myDisplay(char f1name[])
{
	int fd1;
	int k;
	char ch;
	//opening the file to fisplay 
	fd1=open(f1name,O_RDONLY);
	//Checking if the file exists or not
	if (fd1 == -1)
		printf("No such file");
	else
	{
		//Reading the file
		while (1)
		{
			k=read(fd1,&ch,1);
			if (k==0)
				break;
			else
				printf("%c",ch);
		}
		//Closing the file after reading
		close(fd1);
	}
}	
