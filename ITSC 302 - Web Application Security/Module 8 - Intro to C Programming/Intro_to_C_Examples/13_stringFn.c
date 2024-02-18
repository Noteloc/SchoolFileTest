#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
	char firstName[10];
	char lastName[10];
	int age=999;
	char fullName[20];
	
	printf("Enter first name: ");
	scanf("%s",firstName);
	
	printf("Enter last name: ");
	scanf("%s",lastName);
	
	strcpy(fullName, firstName);
	
	strcat(fullName, "*");
	
	strcat(fullName, lastName);
	
	printf("Full name: %s\n", fullName);
	printf("Age: %d\n", age);
	
	return 0;
}