#include <stdio.h>
#include <string.h>

void calcDoubleByRef(int* number)
{
	*number = *number * 2;
	printf("Double the number is %d\n",*number);
}

int main(int argc, char* argv[])
{
	int x=2;
	int* p=&x;
	
	printf("x before: %d\n", x);
	
	calcDoubleByRef(p);
	
	printf("x after: %d\n", x);
	
	return 0;
}