#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	int numNames=0;
	char* names[10];
	char name[10];

	printf("Enter number of names to store: ");
	scanf("%d", &numNames);
	
    for(int i=0; i<numNames; i++)
    {
        names[i] = (char *) malloc(10);
        printf("Enter name #%d: ", i+1);
        scanf("%s", name);
        strcpy(names[i], name);
    }

    for(int i=0; i<numNames; i++)
    {
        printf("Name #%d: %s\n", i+1, names[i]);
        names[i] = (char *) realloc(names[i], 0);
    }
	
	return 0;
}