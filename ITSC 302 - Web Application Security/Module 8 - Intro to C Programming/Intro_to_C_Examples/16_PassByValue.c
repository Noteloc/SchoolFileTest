#include <stdio.h>
#include <string.h>

void calcDoubleByValue(int number)
{
	number = number * 2;
	printf("Double the number is %d\n",number);
}

int main(int argc, char* argv[])
{
	int x=2;
	
	printf("x before: %d\n", x);
	
	calcDoubleByValue(x);
	
	printf("x after: %d\n", x);
	
	return 0;
}