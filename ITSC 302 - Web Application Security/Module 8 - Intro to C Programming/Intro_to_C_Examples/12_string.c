#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
	char name[10];
	int age=9999;
	
	printf("Age before: %d\n",age);
	
	printf("Enter your name: ");
	scanf("%s",name); //Note: no & needed
	
	printf("You entered %s\n",name);
	
	printf("Size of string: %d\n", sizeof(name));
	printf("Length of your name: %d\n",strlen(name));
	
	for (int i=0; i<=strlen(name); i++)
		printf("%d\n", name[i]);
		
	printf("Age after: %d\n",age);
	
	return 0;
}