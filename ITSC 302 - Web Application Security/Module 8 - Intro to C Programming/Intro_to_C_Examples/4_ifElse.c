#include <stdio.h>

int main(int argc, char* argv[])
{
	int age=20;
	
	if (age<0 || age>122)
		printf("Invalid age entered!\n");
	else if (age<13)
		printf("You are a child\n");
	else if (age>12 && age<20)
		printf("You are a teenager\n");
	else
		printf("You are an adult\n");
		
	return 0;
}