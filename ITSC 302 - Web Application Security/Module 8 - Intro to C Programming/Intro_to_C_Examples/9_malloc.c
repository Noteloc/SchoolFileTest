#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	char* name = (char*) malloc(100);
	int* age = (int*) malloc(sizeof(int));
	
	printf("Enter your name: ");
	scanf("%s",name);
	
	printf("Enter your age: ");
	scanf("%d",age);
	
	printf("Your name is %s and your age is %d\n", name, *age);
	
	free(age);
	free(name);
	
	return 0;
}