package com.miaotu;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Test {
	public static int num=1;
public static void main(String[] args)throws Exception{
	 CountDownLatch cdl = new CountDownLatch(1000);
	for(int i=1;i<10;i++) {
	TestPort a = new TestPort(num);
	
	Thread thread = new Thread(a);
	thread.start();
}
}
	static class TestPort implements Runnable{
		int i;
       TestPort(int a){
    	   this.i=a;
       }
		@Override
		public   void run() {
			
			  Socket socket = new Socket();
		        try {
		            socket.connect(new InetSocketAddress("123.57.58.117", i));
		            num++;
		            System.out.println("port open:"+i);
		        } catch (IOException e) {
		          //  e.printStackTrace();
		           System.out.println(i);
		           
		        } finally {
		            try {
		            	
		                socket.close();
		            } catch (IOException e) {
		              //  e.printStackTrace();
		            }
		        }
		      
		    
		}
		}
		
	
	public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
          //  e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
              //  e.printStackTrace();
            }
        }
        return true;
    }
}
