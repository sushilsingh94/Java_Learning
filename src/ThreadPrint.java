
public class ThreadPrint {

	public static void main(String[] args) {
		ThreadPrint t1 = new ThreadPrint();
		
		PrintNumber p1 = t1.new PrintNumber();
		PrintNumber p2 = t1.new PrintNumber();
		p1.setName("p1");
		p1.start();
		p2.setName("p2");
		p2.start();
	}



	class PrintNumber extends Thread{

		@Override
		public void run() {
			for(int i=0;i<7;i++){
				print(i);
			}
		}

		private void print(int i){
			if(Thread.currentThread().getName().equals("p1")){
				System.out.println(Thread.currentThread().getName()+"- 0");
			}else{
				System.out.println(Thread.currentThread().getName()+"- "+i);
			}
		}
	}

}
