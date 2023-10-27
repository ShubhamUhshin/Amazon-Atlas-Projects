#include"myheader.h"
#include"display.h"
#include"headlines.h"
#include"taillines.h"
#include"copyfile.h"
#include"removefile.h"
#include"history.h"
#include"manual.h"

char input[50],cmd[20],f1name[20],f2name[20],checkfile[5];
int fd1,fd2;
int child;

int userInput()
{
	//Freeing the variables for the next input.	
	cmd[0]='\0';
	f1name[0]='\0';
	f2name[0]='\0';
	input[0]='\0';
	checkfile[0]='\0';

	//Taking the command input
	printf("\033[1;36m");
	printf("\n MyShell:$ ");
	printf("\033[1;37m");
	scanf("%s",cmd);
	//Checking if we need file name
	if (strcmp(cmd,"exit")==0 || strcmp(cmd,"clear")==0 || strcmp(cmd,"myhistory")==0)
	{	
		myHistory(cmd);
	}
	//Taking files input
	else
	{
		strcat(input,cmd);
		strcat(input," ");
		//Checking if we need two inputs
		if (strcmp(cmd,"mycp")==0||strcmp(cmd,"mymv")==0)
		{
			scanf("%s",f1name);
			scanf("%s",f2name);
			strcat(input,f1name);
			strcat(input," ");
			strcat(input,f2name);
			myHistory(input);	
		}
		//Checking if we have 1st input as number
		else if (strcmp(cmd,"myhead")==0||strcmp(cmd,"mytail")==0)
		{	
			scanf("%s",f2name);
			checkfile[0]=f2name[0];
			//Checking for the correct input format
			if (strcmp(checkfile,"-")==0)
			{
				scanf("%s",f1name);
				strcat(input,f2name);
				strcat(input," ");
				strcat(input,f1name);
				myHistory(input);
			}
			else
			//Taking 1 input
			{
				strcat(input,f2name);
				myHistory(input);
				strcpy(f1name,f2name);
			}
		}
		else
		{	
			scanf("%s",f1name);
			strcat(input,f1name);
			myHistory(input);	
		}
	}
	
}

//Calling functions as per the user command
int funcExec()
{
	if (strcmp(cmd,"mycat") == 0)
		myDisplay(f1name);

	else if (strcmp(cmd,"myhead") == 0)
		myHead(f1name,f2name);
	
	else if (strcmp(cmd,"mytail") == 0)
		myTail(f1name,f2name);
	
	else if (strcmp(cmd,"mycp") == 0)
	{

		myCopy(f1name,f2name);
	}

	else if (strcmp(cmd,"myrm") == 0)
		myRemove(f1name);			

	else if(strcmp(cmd,"mymv") == 0)
	{
		myCopy(f1name,f2name);
		myRemove(f1name);			
	}
	
	else if (strcmp(cmd,"myhistory") == 0)
	{
		strcpy(f1name,"CommandHistory.txt");
		myDisplay(f1name);
	}

	else if(strcmp(cmd,"myman")==0)
	{
		showCommands(f1name);
	}		
	else
	{
		printf("No Such Command");
	}
}

int main()
{
	do
	{
		userInput();
		//Checking if the user wants to exit
		if (strcmp(cmd,"exit") == 0)
		{
			printf("\nBYE\n");
		}
		else
		{
			//Forking
			child=fork();
			if (child==0)
			{
				//If the user clears screen
				if (strcmp(cmd,"clear")==0)
				{	
					system("clear");
				}
				else
				{
					funcExec();
				}
				
				exit(0);
			}
			else
			{
				wait(0);
			}
			sleep(1);
		}
	}
	while (strcmp(cmd,"exit")!=0);
}
