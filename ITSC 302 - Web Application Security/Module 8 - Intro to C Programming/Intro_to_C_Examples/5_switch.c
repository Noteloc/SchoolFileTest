#include <stdio.h>

int main(int argc, char* argv[])
{
	int x=2;
	//float x=2.0f;
	
	switch(x)
	{
		case 1: printf("One\n");
			break;
		case 2: printf("Two\n");
			break;
		case 3: printf("Three\n");
			break;
		default: printf("Some other number");
	}
	
	return 0;
}