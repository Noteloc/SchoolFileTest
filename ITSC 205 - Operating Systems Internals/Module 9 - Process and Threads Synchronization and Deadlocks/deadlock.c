#include <pthread.h> 
#include <stdio.h> 
//#include "errors.h" 

/* Initialize 2 mutexes. */ 
pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER; 
pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER; 

void * locking_thread_a( void *arg ) 
{ 
	int status; printf( "t1 waiting for lock(mutex)\n" ); 
	status = pthread_mutex_lock( &mutex1 ); 
//	if ( status != 0 ) 
//		err_abort( status, "lock 1" ); 
	printf( "t1 has lock 1\n" ); 
	sched_yield(); 
	printf( "t1 now trying to get lock 2\n" ); 
	status = pthread_mutex_lock( &mutex2 ); 
	printf( "t1 has lock 2\n" ); 
//	if ( status != 0 ) 	
//		err_abort( status, "lock 2" ); 
	pthread_mutex_unlock( &mutex1 ); 
	pthread_mutex_unlock( &mutex2 ); 
	printf( "t1 finishing\n" ); 
	pthread_exit( NULL ); 
} 

void * locking_thread_b( void *arg ) 
{ 
	int status; printf( "t2 waiting for mutex(lock)\n" );
	status = pthread_mutex_lock( &mutex2 ); 
//	if ( status != 0 ) 
//		err_abort( status, "lock 2" ); 
	printf( "t2 has lock 2\n" ); 
	sched_yield(); 
	printf( "t2 now trying to get lock 1\n" ); 
	status = pthread_mutex_lock( &mutex1 ); 
//	if ( status != 0 ) 
//		err_abort( status, "lock 1" ); 
	printf( "t2 has lock 1\n" ); 
	pthread_mutex_unlock( &mutex2 ); 
	pthread_mutex_unlock( &mutex1 ); 
	printf( "t2 finishing\n" ); 
	pthread_exit( NULL ); 
}

int main( int argc, char *argv[] ) 
{
	pthread_t thread1, thread2; 
	int status; 
	printf( "Creating t1\n" ); 
	status = pthread_create( &thread1, NULL, locking_thread_a, NULL ); 
//	if ( status ) 
//		err_abort( status, "locking_thread_a" ); 
	printf( "Creating t2\n" ); 
	status = pthread_create( &thread2, NULL, locking_thread_b, NULL ); 
//	if ( status ) 
//		err_abort( status, "locking_thread_b" ); 
	pthread_exit( NULL );
}
