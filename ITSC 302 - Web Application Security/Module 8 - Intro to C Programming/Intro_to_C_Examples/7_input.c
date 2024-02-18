#include <stdio.h>

int main(int argc, char* argv[])
{
	char myName[100];
	int age=0;
	
	char letter=0;
	//char letter[2];
	
	//C string buffer
	printf("Enter your name: ");
	scanf("%s",myName);
	
	//Integer
	printf("Enter your age: ");
	scanf("%d", &age);
	
	printf("Hello, %s, with an age of %d\n", myName, age);
	
	//char
	printf("Enter a letter: ");
	scanf(" %c", &letter);

	printf("You entered a letter of %c\n",letter);
	
	return 0;
}