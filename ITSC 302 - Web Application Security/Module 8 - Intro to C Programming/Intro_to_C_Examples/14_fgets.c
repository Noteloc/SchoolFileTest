#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
	char firstName[10];
	char lastName[10];
	int age=999;
	char fullName[22];
	char ch=0;
	
	printf("Enter first name: ");
	//scanf("%s",firstName);
	fgets(firstName, sizeof(firstName), stdin);
	
	//Clear input buffer if necessary...
	if (strlen(firstName)==9)
		while((ch = fgetc(stdin))!= EOF && ch != '\n');
	
	printf("Enter last name: ");
	//scanf("%s",lastName);
	fgets(lastName, sizeof(lastName), stdin);

	//Fix end of firstName so it's null-terminated
	if (firstName[strlen(firstName)-1]=='\n')
		firstName[strlen(firstName)-1]='\0';
		

	strcpy(fullName, firstName);
	
	strcat(fullName, "*");
	
	strcat(fullName, lastName);
	
	printf("Full name: %s\n", fullName);
	printf("Age: %d\n", age);
	
	return 0;
}