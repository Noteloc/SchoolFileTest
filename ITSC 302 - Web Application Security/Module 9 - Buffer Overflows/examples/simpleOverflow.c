#include <stdio.h>

int main(void)
{
	int age=21;
	char buffer[16] = {};
		
	*(buffer+16) = 99;
	
	printf("Age is %d\n", age);
	
}