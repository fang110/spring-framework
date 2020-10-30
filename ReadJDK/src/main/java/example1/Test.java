package example1;

import java.util.concurrent.locks.StampedLock;

public class Test {

	private final static  StampedLock lock = new StampedLock();


	public static void main(String[] args) {
		doRead();
	}

	public static void doRead() {
		long stamp = lock.tryOptimisticRead();
		if(lock.validate(stamp)) {

			try{
				stamp = lock.readLock();
				System.out.println("aaa");
			}finally {
				lock.unlockRead(stamp);
			}
		}
	}


}
