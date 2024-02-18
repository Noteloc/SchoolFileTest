#include <stdio.h>

//void sayHello();
//int calcDouble(int number);

void sayHello()
{
	printf("Hello\n");
}

int calcDouble(int number)
{
	return number*2;
}

int main(int argc, char* argv[])
{
	int x=0;
	
	sayHello();
	
	printf("Enter a number: ");
	scanf("%d",&x);
	
	int y=calcDouble(x);
	
	printf("Twice %d is %d\n",x,y);
	
	return 0;
}