package com.lxy.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileControlInputStream extends FilterInputStream {

	private long timestamp;
	private int maxbps;
	private int currentbps;
	private int bytesread;

	// ----------------------------------------------------------
	// constructor
	public FileControlInputStream(InputStream in, int maxbps) {
		super(in);
		this.maxbps = maxbps;
		this.currentbps = 0;
		this.bytesread = 0;
		this.timestamp = System.currentTimeMillis();
	}

	// ----------------------------------------------------------
	// decorated methods

	public int read() throws IOException {
		synchronized (in) {
			int avaliable = check();
			if (avaliable == 0) {
				waitForAvailable();
				avaliable = check();
			}
			int value = in.read();
			update(1);
			return value;
		}
	}

	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);

	}

	public int read(byte[] b, int off, int len) throws IOException {
		synchronized (in) {
			int avaliable = check();
			if (avaliable == 0) {
				waitForAvailable();
				avaliable = check();
			}
			int n = in.read(b, off, Math.min(len, avaliable));
			update(n);
			return n;
		}
	}

	public int check() {
		long now = System.currentTimeMillis();
		if (now - timestamp >= 1000) {
			timestamp = now;
			currentbps = bytesread;
			bytesread = 0;
			return maxbps;
		} else {
			return maxbps - bytesread;
		}
	}

	private void waitForAvailable() {
		long time = System.currentTimeMillis() - timestamp;
		boolean isInterrupted = false;
		while (time < 1000) {
			try {
				Thread.sleep(1000 - time);
			} catch (InterruptedException e) {
				isInterrupted = true;
			}
			time = System.currentTimeMillis() - timestamp;
		}
		if (isInterrupted)
			Thread.currentThread().interrupt();
		return;

	}

	private void update(int n) {
		bytesread += n;
	}

	public int getCurrentbps() {
		return currentbps;
	}
}
