#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[])
{
	int numValues=0;
	int* p=0;
	int last=0;
	
	printf("Enter the number of values to allocate: ");
	scanf("%d",&numValues);
	
	for (int i=0; i<numValues; i++)
		p = (int*) malloc(sizeof(int));
		
	//Use task manager to check memory used by program	
	printf("Enter a last value (stalling): ");
	scanf("%d",&last);
	
	return 0;
}