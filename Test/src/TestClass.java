
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread newThread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for(int i = 0; i<100; i++){
					System.out.println("New Thread");
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		});
		newThread.start();
		
		
		
		for(int i = 0; i<100; i++){
			System.out.println("Main Thread");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
	
}
