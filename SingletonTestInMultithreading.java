package com.prg.multithreading;

public class SingletonTestInMultithreading {
	  private static volatile SingletonTestInMultithreading singleton = null;
	  private static boolean firstThread = true;
	  protected SingletonTestInMultithreading() {
	    // Exists only to defeat instantiation.
	  }
	  public static SingletonTestInMultithreading getInstance() {
	     if(singleton == null) {
	    	 synchronized(SingletonTestInMultithreading.class){
	    		 if(singleton==null){
	    			 singleton = new SingletonTestInMultithreading();
	    		 }
	    	 }
	      //  simulateRandomActivity();
	        
	     }
	     return singleton;
	  }
	  private static void simulateRandomActivity() {
	     try {
	        if(firstThread) {
	           firstThread = false;
	           // This nap should give the second thread enough time
	           // to get by the first thread.
	             Thread.currentThread().sleep(50);
	       }
	     }
	     catch(InterruptedException ex) {
	     }
	  }
	}
