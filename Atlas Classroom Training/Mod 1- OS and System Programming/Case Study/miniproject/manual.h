//This shows the list of commands available in this project

#include"myheader.h"

int showCommands(char f1name[])
{
	if (strcmp(f1name,"mycat")==0)
	{
		printf("\n \t MYCAT \n");
		printf("\n SYNTAX: mycat {filename} \n");
		printf("\t Displays the contents of the file.");
	}

	else if (strcmp(f1name,"myhead")==0)
	{
		printf("\n \t MYHEAD \n");
		printf("\n SYNTAX: myhead {filename} \n");
		printf("\t Displays 1st 10 lines of the file. \n");
		printf("\n SYNTAX: myhead -{value} {filename} \n");
		printf("\t Displays first {value} lines of the file \n");
	}
	
	else if (strcmp(f1name,"mytail")==0)
	{
		printf("\n \t MYTAIL \n");
		printf("\n SYNTAX: mytail {filename} \n");
		printf("\t Displays last 10 lines of the file. \n");
		printf("\n SYNTAX: mytail -{value} {filename} \n");
		printf("\t Displays last {value} lines of the file \n");
	}

	else if (strcmp(f1name,"mycp")==0)
	{
		printf("\n \t MYCOPY \n");
		printf("\n SYNTAX: mycp {file1} {file2} \n");
		printf("\t Copies the contents of file1 into file2 \n");
	}
	else if(strcmp(f1name,"myrm")==0)
	{
		printf("\n \t MYREMOVE \n");
		printf("\n SYNTAX: myrm {file} \n");
		printf("\t Removes file \n");
	}

	else if (strcmp(f1name,"mymv"))
	{
		printf("\n \t MYMOVE \n");
		printf("\n SYNTAX: mymv {file1} {file2} \n");
		printf("\t Moves the contents of file1 into file2 \n");
	}
	else if(strcmp(f1name,"myhistory")==0)
	{
		printf("\n \t MYHISTORY \n");
		printf("\n SYNTAX: myhistory \n");
		printf("\t Shows the last 50 commands used \n");
	}
}
