//export MALLOC_CHECK_=0 to stop error at runtime

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 10

int main(void)
{
	char* buffer1=(char*)malloc(SIZE);
	char* buffer2=(char*)malloc(SIZE);
	
	memset(buffer2,'*',SIZE-1);
	buffer2[SIZE-1]='\0';
	
	int dif = buffer2-buffer1;
	
	printf("Buffer1: %lu\nBuffer2: %lu\nDifference: %d\n",buffer1, buffer2,dif);
	
	printf("BEFORE: %s\n",buffer2);
	
	memset(buffer1, '!', dif+3); //Overflow into mem allocated to buffer2 by 3 characters
	
	printf("AFTER: %s",buffer2);
	
	free(buffer1);
	free(buffer2);

	return 0;
}