import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPool<T> {
	
	
	
	
	private ConcurrentLinkedQueue<T> pool;

	private ScheduledExecutorService executorservice;
	
	
	public ObjectPool(final int minObjects)
	{
		  initialize(minObjects);  
	}


	private void initialize(int minObjects) {
		// TODO Auto-generated method stub
		
		 pool = new ConcurrentLinkedQueue<T>();  
		 
		 for (int i = 0; i < minObjects; i++) {  
	            pool.add(createObject());  
	        }  
		
	}
	
	//
	
	public T borrowObject()
	{
		T object;
		
		if((object=pool.poll())==null)
		{
			object=createObject();
		}
		
		return object;
	}
	
	
	 public void returnObject(T object) {  
	        if (object == null) {  
	            return;  
	        }  
	        this.pool.offer(object);  
	    }  
	 
	 
	 
	  /* 
     Shutdown this pool. 
 */  
   public void shutdown(){  
     if (executorservice != null){  
         executorservice.shutdown();  
     }  
 }  
	
	
	 protected abstract T createObject();  
	
	public ObjectPool(final int minobj,final int maxobj,final long validationinterval )
	{
		//intializePool
		initialize(minobj);
		
		//check pool condition in separate thread 
		
		executorservice=Executors.newSingleThreadScheduledExecutor();
		
		executorservice.scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				int size=pool.size();
				
				if(size<minobj)
				{
					int sizetobeadded=minobj-size;
					for (int i = 0; i < sizetobeadded; i++) {  
                        pool.add(createObject());  
                    }  
				}
				else
				{
					if(size>maxobj)
					{
						int sizetoberemove=size-maxobj;
						for (int i = 0; i < sizetoberemove; i++) {  
	                        pool.poll();  
	                    }  
					}
				}
				
			}
			
		}, validationinterval, validationinterval, TimeUnit.SECONDS);
	}
}
