#include <stdio.h> 
#include <time.h>
#include <pthread.h>

#define N 100000
pthread_t thread1;
pthread_t thread2;
void swap(int *xp, int *yp) { 
	int temp = *xp;
	*xp = *yp;
	*yp = temp;
}
void bubbleSort(void *arrthread) {
	int *arr = (int *) arrthread;
	for(int i = 0; i < N/2-1; i++)
		for(int j=0;j < N/2-i-1; j++) 
			if (&arr[j] < &arr[j+1])
				swap(&arr[j], &arr[j+1]);
}
void printArray(int arr[], int size) {
	int i;
	for (i=0; i < size; i++)
		printf("%d ", arr[i]); printf("\n");
}

void merge(int* A, int* B, int* mergeResult) {
  int i;
  for(i = 0; i < N; i++){
  	if( i < N/2){
  		mergeResult[i] = A[i];
  	}	
  	else{
  		mergeResult[i] = B[i - N/2];
  	}
  }
}

int main() {
	int i, n;
	int* A; 
	int* B;
	clock_t start, end; 
	double elapsed_time;
	int NPthread = N/2;
	A = (int *)malloc(sizeof(int)* NPthread); 
	B = (int *)malloc(sizeof(int)* NPthread);
	if(A==NULL){
		printf("Fail to malloc\n");
		exit(0); 
	}
	if(B==NULL){
		printf("Fail to malloc\n");
		exit(0); 
	}
	// add number in A, B
	for (i=N/2-1; i>=0; i--){ 
		A[N/2-1-i] = i;	
		B[N/2-1-i] = i+N/2;	
	}
	start = clock();
	pthread_create(&thread1, NULL, bubbleSort, (void*)A);
	pthread_create(&thread2, NULL, bubbleSort, (void*)B);
	pthread_join(thread1, NULL);
	pthread_join(thread2, NULL);
	end = clock();
	printf("print the last ten elements of thread A : ");
	printArray(&A[0], 10);
	printf("print the last ten elements of thread B : ");
	printArray(&B[0], 10);
	int* mergeResult;
	mergeResult = (int *)malloc(sizeof(int)* N);
	if(mergeResult == NULL){
		printf("Fail to malloc\n");
		exit(0); 
	}
	merge(A,B,mergeResult);
	printf("The first of merge result is %d\n",mergeResult[0]);
	printf("The last of merge result is %d\n", mergeResult[N-1]);
	elapsed_time = (end-start)/(double)CLOCKS_PER_SEC; printf("elapsed time = %lf\n", elapsed_time);
	return 0;
}
