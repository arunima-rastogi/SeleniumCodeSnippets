package CodeSnippets;

class Pen {
}

class Paper {
}

public class Deadlock {

	public static void main(String[] args) {
		final Pen pn = new Pen();
		final Paper pr = new Paper();

		Thread t1 = new Thread() {
			public void run() {
				synchronized (pn) {
					System.out.println("Thread1 is holding Pen");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					synchronized (pr) {
						System.out.println("Requesting for Paper");
					}

				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (pr) {
					System.out.println("Thread2 is holding Paper");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					synchronized (pn) {
						System.out.println("requesting for Pen");
					}

				}
			}
		};

		t1.start();
		t2.start();
	}

}