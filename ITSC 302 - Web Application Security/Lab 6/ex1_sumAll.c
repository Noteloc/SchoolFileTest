#include <stdio.h>

int main()
{
    int input = 0;
    int sum = 0;

    while(input >= 0)
    {
        printf("Enter number (negative to end): ");
        scanf("%d", &input);
        if(input < 0)
            break;
        sum = sum + input;
    }
    printf("The sum of the numbers you entered is %d\n", sum);
    return 0;
}