#include <stdio.h>
#include <string.h>

void calcMult(int* x, int* y, int* z)
{
	*x = *x * 2;
	*y = *y * 3;
	*z = *z * 3;
}

int main(int argc, char* argv[])
{
	int x=2, y=3, z=4;
	
	
	printf("values before: %d %d %d\n", x, y, z);
	
	calcMult(&x, &y, &z);
	
	printf("values after: %d %d %d\n", x, y, z);
	
	return 0;
}