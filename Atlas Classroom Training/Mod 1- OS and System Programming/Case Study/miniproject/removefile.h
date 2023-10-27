// This code works for removing a file

#include"myheader.h"

int myRemove(char f1name[])
{
	//remove is a C library function to delete a file.
	remove(f1name);
}
