package com.mei.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ClassA {
	
	public static void main(String[] args){
//		
//		ExecutorService pool = Executors.newCachedThreadPool();
//		
//		for(int i =0;i<10000;i++){
//			pool.submit(new Runnable() {
//				
//				@Override
//				public void run() {
//					ClassB instance = ClassB.getInstance();
//					instance.num.set(instance.num.get()+1);;;
//				}
//			});
//		}
//		try{
//			Thread.sleep(2000);
//		}catch(InterruptedException i){
//			
//		}
//		System.out.print(ClassB.getInstance().num);
		
		Lock lock = new ReentrantLock();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try{
					lock.lock();
					System.out.println(77777);
				}catch(Exception e){
					
				}finally{
					lock.unlock();
				}
			}
		});
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		
		if(lock.tryLock()){
			System.out.println(11111);
			lock.unlock();
		}else{
			System.out.println(22222);
			
		}
 		
	}
	
}
