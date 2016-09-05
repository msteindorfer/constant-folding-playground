package com.github.msteindorfer;

public class Util {
	public static final Class[] initializeSpecializationsByContentAndNodes() {
		Class[] next = new Class[33 * 65];

		try {
			for (int m = 0; m <= 32; m++) {
				for (int n = 0; n <= 64; n++) {
					int mNext = m;
					int nNext = n;

					if (mNext < 0 || mNext > 32 || nNext < 0 || nNext > 64
									|| Math.ceil(nNext / 2.0) + mNext > 32) {
						next[65 * m + n] = null;
					} else {
						next[65 * m + n] = Class.forName(
										String.format("com.github.msteindorfer.Specializations$SetMultimap%dTo%dNode",
														new Integer[] { Integer.valueOf(mNext),
																		Integer.valueOf(nNext) }));
					}
				}
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return next;
	}
}