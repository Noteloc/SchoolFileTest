#include <stdio.h>

int main(int argc, char* argv[])
{
	int i=1;
	
	while (i<=10)
	{
		printf("%d\n", i);
		i++;
	}
	
	i=1;
	do
	{
		printf("%d\n",i);
		i++;
	} while (i<=10);
	
	for (i=1; i<=10; i++)
		printf("%d\n",i);
	
	return 0;
}