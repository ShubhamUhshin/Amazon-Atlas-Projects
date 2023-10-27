#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<fcntl.h>


int process_str(char *str, char arglist[100][100],int *nargs)
{
	int i=0,j=0,k=0;
	while(str[i]!='\0')
	{
		if(str[i]=='\n')
		{
			i++;
			continue;
		}
		else if(str[i]!=' ')
		         arglist[j][k++] = str[i++];
		else
		{
		        (*nargs)++; 
			arglist[j][k]='\0';
			j++;
			k=0;
                        i++;	
		}
	}
	return 0;
}



int main(int argc, char **argv)
{
	int n,argno=0,i=0,fd1,fd2;
	char str[100], arglist[100][100];
	char path[100],buff[100];
	
	while(1)
	{
		strcpy(path,"./");
		argno=0; 
		fflush(stdin);	
		n = read(0,str,100);
		str[n]='\0';
		process_str(str,arglist,&argno);
		for(i=0;i<=argno;i++)
		{
		  printf("arguments passed = %s \n",arglist[i]);
  		}
               if(strcmp(arglist[0],"mycp")==0)
		{
				printf("This is my version of cp command\n");
			strcat(path,arglist[1]);

	               	fd1 = open(path,O_RDONLY);
                        if(fd1<0)
			{
				printf("Open Error\n");
				exit(1);
			}
			strcpy(path,"./");
			strcat(path,arglist[2]);
		        printf(" dest path = %s \n",path);	
			fd2 = open(arglist[2],O_RDWR|O_CREAT, 0666);
			if(fd2<0)
			{
				printf("Open Error\n");
				exit(1);
			}
			while((n=read(fd1,buff,100))>0)
			{
			    write(fd2,buff,n);
		    	}
	    		close(fd1);
			close(fd2);		

		}
		else if(strcmp(arglist[0],"mycat")==0)
		{
				printf("This is my version of cat command\n");
		}			
	
	}
}	
