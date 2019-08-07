package CodeSnippets;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Gfg {
	public void x() {
		System.out.println("Jackychan Adventures");
	}
}

public class StrongWeakReferenceInJava {
	public static void main(String[] args) {
		Gfg g = new Gfg();
		g.x();

		WeakReference<Gfg> weakref = new WeakReference<Gfg>(g);
		g = null;
		System.gc();
		g = weakref.get();

		SoftReference<Gfg> softref = new SoftReference<Gfg>(g);
		g = null;
		System.gc();
		g = softref.get();

		ReferenceQueue<Gfg> refQueue = new ReferenceQueue<Gfg>();
		PhantomReference<Gfg> phantomRef = new PhantomReference<Gfg>(g, refQueue);
		g = null;
		g = phantomRef.get();


	}
}