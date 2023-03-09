package org.learn;//Modify the given program to output "foobar" n times without deadlock

// if n = 10, the result is "foobarfoobarfoobarfoobarfoobar"

import java.util.function.Consumer;

public class FooBar {

	int n;

	volatile int counter = 0;

	public FooBar(int n) {
		this.n = n;
	}

	private void foo(Consumer<String> printer) throws InterruptedException {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 != 0) {
			         wait();
				}
				if (counter >= n) {
					break;
				}
				printer.accept("foo");
				counter++;
				notify();
			}
		}
	}

	private void bar(Consumer<String> printer) throws InterruptedException {
		synchronized (this) {
			while (counter < n) {
				while (counter % 2 == 0) {
					wait();
				}
				if (counter >= n) {
					break;
				}
				printer.accept("bar");
				counter++;
				notify();
			}
		}
	}

	public static void main(String... args) throws InterruptedException {
		FooBar f = new FooBar(10);
		Consumer<String> printer = new Consumer<String>() {
			String previous = "";
			void validate(String curr) {
				if (previous.equals(curr)) {
					throw new RuntimeException("ERROR!");
				}
				previous = curr;
			}
			@Override
			public void accept(String s) {
				System.out.print(s);
				validate(s);
			}
		};
		Thread t1 = new Thread(() -> {
			try {
				f.foo(printer);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				f.bar(printer);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
