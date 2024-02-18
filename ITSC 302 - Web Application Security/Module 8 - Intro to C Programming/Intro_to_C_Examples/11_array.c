#include <stdio.h>

int main(int argc, char* argv[])
{
	int a[5]; //Uninitialized, junk values!
	
	printf("Address of a[0]: %d\n", &a[0]);
	
	for (int i=0; i<5; i++)
		printf("%d\n",a[i]);
		
	//Initialized
	int b[5] = { 1,2,3,4,5 };
	
	printf("Address of b[4]: %d\n", &b[4]);
	
	for (int i=0; i<5; i++)
		printf("%d\n",b[i]);
		
	//Stack
	int splat=9999;
	printf("Address of splat: %x\n", &splat);	
	
	//Assignment after declaration
	int c[5];
	c[0]=50;
	c[1]=40;
	c[2]=30;
	c[3]=20;
	c[4]=10;
	
	printf("Address of c[4]: %d\n", &c[4]);
	
	for (int i=0; i<5; i++)
		printf("%d\n",c[i]);
		
	//INVALID INDEXING
	for (int i=1; i<=5; i++)
		printf("Invalid before: %d\n",c[i]);
		
	//Change memory location not allocated to array!
	c[5]=999;
	
	for (int i=1; i<=5; i++)
		printf("Invalid after: %d\n",c[i]);
		
	printf("Value for splat: %d (ouch!)\n",splat);
	
	return 0;
}