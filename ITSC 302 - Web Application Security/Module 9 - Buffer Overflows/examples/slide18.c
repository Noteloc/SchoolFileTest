#include <stdio.h>

void showWords(int* p) {
	for (int i=0; i<30; i++) {
		printf("%d: %x=%x\n",i,p+i,*(p+i));
	}
}

void function(){
    int buffer[4]={1,2,3,4};
    int* r;

    //showWords(buffer);

    r = buffer + 8;
    printf("1:%x\n",*r);
    (*r) += 8;
    printf("2:%x\n",*r);
}

int main(){
    int x = 0;
    function();
    x = 1;
    printf("X=%d\n", x);
    return 0;
}
