package com.example.cwd;

public class Asl {
	private Asl() {
	}

	private Asl asl;

	public Asl getAsl() {

		if (asl == null) {
			synchronized (Asl.class) {
				if (asl == null) {
					asl = new Asl();
				}
			}
		}

		return asl;
	}

}
