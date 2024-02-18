#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
	char original[20]={};
	char cleaned[20]={};
	char reversed[20]={};

	printf("Enter string: ");
	scanf("%s", original);
	
	for(int i=0; i<20; i++)
    {
        if(!(original[i] >= 33 && original[i] <= 47))
        {
            if(original[i] >= 65 && original[i] <= 90)
                original[i] += 32;
            strncat(cleaned, &original[i],1);
        }
    }

	for(int i=strlen(cleaned); i>=0; i--)
            strncat(reversed, &cleaned[i],1);
    
    printf("%s ", original);
    if(strcmp(cleaned, reversed) == 0)
        printf("is a palindrome\n");
    else
        printf("is NOT a palindrome\n");

	return 0;
}