import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectPoolDemo {
	
	private ObjectPool<ExportingProcess> pool;  
	private AtomicLong processNo=new AtomicLong(0);  
	
	
	 public void setUp() {  
		 
		 pool = new ObjectPool<ExportingProcess>(4, 10, 5)
				 {

					@Override
					protected ExportingProcess createObject() {
						// TODO Auto-generated method stub
						return new ExportingProcess(processNo.getAndIncrement());
					}
			 
				 };
		 
	 }
	 
	 
	 public void tearDown() {  
	        pool.shutdown();  
	    }  

	 
	 public void testObjectPool() {
		 ExecutorService executor = Executors.newFixedThreadPool(8);  
		 
		 executor.execute(new ExportingProcessTask(pool, 1));  
	        executor.execute(new ExportingProcessTask(pool, 2));  
	        executor.execute(new ExportingProcessTask(pool, 3));  
	        executor.execute(new ExportingProcessTask(pool, 4));  
	        executor.execute(new ExportingProcessTask(pool, 5));  
	        executor.execute(new ExportingProcessTask(pool, 6));  
	        executor.execute(new ExportingProcessTask(pool, 7));  
	        executor.execute(new ExportingProcessTask(pool, 8));  
	        
	        
	        try {  
	            executor.awaitTermination(30, TimeUnit.SECONDS);  
	            } catch (InterruptedException e)  
	              
	              {  
	               e.printStackTrace();  
	              }
	 }
	 
	 public static void main(String args[])  {   
	        ObjectPoolDemo op=new ObjectPoolDemo();  
	        op.setUp();  
	        op.tearDown();  
	        op.testObjectPool();  
	   }   
}
