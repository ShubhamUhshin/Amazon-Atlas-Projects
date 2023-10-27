// This works for mycp command.

#include"myheader.h"

int myCopy(char f1name[], char f2name[])
{
	int fd1,fd2;
	char ch;
	int k;
	fd1=open(f1name,O_RDONLY);
	//Checking if the file exists in the directory or not
	if (fd1==-1)
		printf("No such file");
	
	else
	{
		//Creating the second file to copy
		fd2=open(f2name,O_CREAT,0744);
		fd2=open(f2name,O_WRONLY);
		//Writing into the second file
		while (read(fd1,&ch,1))
		{
			write(fd2,&ch,1);
		}
		//Closing both the files since writing is done
		close(fd1);
		close(fd2);
	}
}
