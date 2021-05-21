
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

int chairs = 0;
void* myFunction() {
    for (int i = 0; i < 10000000; i++) {
    
        chairs++;
    
    }
}

int main(int argc, char* argv[]) {
    pthread_t thread1, thread2, thread3, thread4;
    if (pthread_create(&thread1, NULL, &myFunction, NULL) != 0) {
        return 1;
    }
    if (pthread_create(&thread2, NULL, &myFunction, NULL) != 0) {
        return 2;
    }
    if (pthread_create(&thread3, NULL, &myFunction, NULL) != 0) {
        return 2;
    }
    if (pthread_create(&thread4, NULL, &myFunction, NULL) != 0) {
        return 2;
    }
    if (pthread_join(thread1, NULL) != 0) {
        return 2;
    }
    if (pthread_join(thread2, NULL) != 0) {
        return 2;
    }
    if (pthread_join(thread3, NULL) != 0) {
        return 2;
    }
    if (pthread_join(thread4, NULL) != 0) {
        return 2;
    }
  
    printf("Number of chairs: %d\n", chairs);
    return 0;
}