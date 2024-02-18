#include <stdio.h>

int main(int argc, char* argv[])
{
	int x=-9;
	int y=9;
	unsigned int z=-9;
	float f = 1.0f;
	
	printf("x=%d y=%d z=%u\n",x,y,z);
	
	printf("%d %d %d %d %d %d %d\n", sizeof(int), sizeof(unsigned int), sizeof(long), sizeof(long long)
			, sizeof(float), sizeof(double), sizeof(char));
	
	return 0;
}