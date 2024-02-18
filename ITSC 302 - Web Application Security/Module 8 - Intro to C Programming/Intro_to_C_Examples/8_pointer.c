#include <stdio.h>

int main(int argc, char* argv[])
{
	int age=20;
	int* p=&age;
	
	printf("Address of age: %d   Value of p: %d\n", &age, p);
	
	printf("Value of age: %d   Value of *p: %d\n", age, *p);
	
	//Increment via identifier
	age++;
	printf("Value of age: %d\n",age);
	
	//Increment via pointer
	(*p)++;
	//*p++;  //switch printf's below!
	printf("Value of age: %d\n", *p); 
	//printf("Value of age: %d\n", age);
	
	return 0;
}