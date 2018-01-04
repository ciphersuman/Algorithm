
public class ExportingProcessTask  implements Runnable {
	private ObjectPool<ExportingProcess> pool;  
	
	  private int threadNo; 
	  
	  public ExportingProcessTask(ObjectPool<ExportingProcess> pool, int threadNo){  
          this.pool = pool;  
          this.threadNo = threadNo;  
      }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// get an object from the pool  
        ExportingProcess exportingProcess = pool.borrowObject();  
        
        System.out.println("Thread " + threadNo + ": Object with process no. "  
                + exportingProcess.getProcessNo() + " was borrowed");  
        
        /*
         * 
         * 
         * we can do some sort of operation there 
         * 
         * I guess this object you can consider as connection object 
         * 
         * 
         */
        pool.returnObject(exportingProcess);  
        System.out.println("Thread " + threadNo +": Object with process no. "  
                + exportingProcess.getProcessNo() + " was returned");  
        
        exportingProcess=null;
        
	}  
    

}
