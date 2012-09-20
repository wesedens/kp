package com.wedens.bitutil;

public final class Rotate {

	public static final int ROTATE_LEFT = 1;
	public static final int ROTATE_RIGHT = 2;

	/***
	 * Calculate the mask to use to mask off the bits which will be rotated out
	 * of the variable. For example, if we are going to rotr 4 bits, the right
	 * most 4 bits will be rotated out of the variable, so the mask should be:
	 * 0x0000000F. Or, if we rotl 8 bits, then the mask should be 0xFF000000.
	 * 
	 * @param bitstorotate
	 *            number of bits to rotate
	 * @param direction
	 *            which direction to rotate ROTATE_LEFT or ROTATE_RIGHT
	 * @return the mask for masking out the bits which will be displaced in the
	 *         rotate
	 */
	private static int calcmask(int bitstorotate, int direction) {
		int mask = 0;
		int c;

		if (bitstorotate == 0)
			return 0;

		c = 0x80000000;
		mask = (c >> bitstorotate);
		if (direction == ROTATE_RIGHT) {
			mask = (c >> (32 - bitstorotate));
			mask = ~mask;
		} else
			mask = (c >> bitstorotate);

		return mask;
	}

	/**
	 * Perform the actual rotate operation. Since all Java arithmetic occurs on
	 * int's, I decided to have a single rotr method for all types byte, short,
	 * and int. This way a single cast is used and then the result is cast back
	 * to the necessary size when completed.
	 * 
	 * @param value
	 *            the value to be rotated right
	 * @param bitstorotate
	 *            the number of bits to rotate right
	 * @param sizet
	 *            the size of the resultant value (8, 16 or 32)
	 * 
	 * @return the value rotated right "bitstorotate" bits
	 */
	private static int rotr(int value, int bitstorotate, int sizet) {
		int tmprslt = 0;
		int mask = 0;
		;
		int target = 0;

		bitstorotate %= sizet;
		target = value;

		// determine which bits will be impacted by the rotate
		mask = calcmask(bitstorotate, ROTATE_RIGHT);

		// save off the bits which will be impacted
		tmprslt = value & mask;

		// perform the actual rotate right
		target = (value >>> bitstorotate);

		// now rotate the saved off bits so they are in the proper place
		tmprslt <<= (sizet - bitstorotate);

		// now add the saved off bits
		target |= tmprslt;

		// and return the result
		return target;
	}

	private static int rotl(int value, int bitstorotate, int sizet) {
		int tmprslt = 0;
		int mask = 0;
		;
		int target = 0;

		bitstorotate %= sizet;

		// determine which bits will be impacted by the rotate
		mask = calcmask(bitstorotate, ROTATE_LEFT);
		// shift the mask into the correct place (i.e. if we are delaying with a
		// byte rotate, we
		// need to ensure we have the mask setup for a byte or 8 bits)
		mask >>>= (32 - sizet);

		// save off the affected bits
		tmprslt = value & mask;

		// perform the actual rotate
		target = (value << bitstorotate);

		// now shift the saved off bits
		tmprslt >>>= (sizet - bitstorotate);

		// add the rotated bits back in (in the proper location)
		target |= tmprslt;

		// now return the result
		return target;
	}

	public static int rotr(int value, int bitstorotate) {
		return (rotr(value, bitstorotate, 32));
	}

	public static short rotr(short value, int bitstorotate) {
		short result;

		result = (short) rotr((0x0000ffff & value), bitstorotate, 16);

		return result;
	}

	public static byte rotr(byte value, int bitstorotate) {
		byte result;

		result = (byte) rotr((0x000000ff & value), bitstorotate, 8);

		return result;

	}

	public static int rotl(int value, int bitstorotate) {
		return (rotl(value, bitstorotate, 32));
	}

	public static short rotl(short value, int bitstorotate) {
		short result;

		result = (short) rotl((0x0000ffff & value), bitstorotate, 16);

		return result;

	}

	public static byte rotl(byte value, int bitstorotate) {
		byte result;

		result = (byte) rotl((0x000000ff & value), bitstorotate, 8);

		return result;

	}

	public static void main(String args[]) {

		System.out.println("rotl32 22, 17 result: " + Rotate.rotl(22, 17));
		System.out.println("rotl16 22, 17 result: "
				+ Rotate.rotl((short) 22, 17));
		System.out
				.println("rotl8 22, 17 result: " + Rotate.rotl((byte) 22, 17));

		System.out.println("rotr32 22, 4 result: " + Rotate.rotr(22, 4));
		System.out
				.println("rotr16 22, 4 result: " + Rotate.rotr((short) 22, 4));
		System.out.println("rotr8 22, 4 result: " + Rotate.rotr((byte) 22, 4));

		System.out.println("rotr8 -128, 7 result: "
				+ Rotate.rotr((byte) -128, 7));
		System.out.println("rotr8 -1, 8 result: " + Rotate.rotr((byte) -1, 8));

	}

}