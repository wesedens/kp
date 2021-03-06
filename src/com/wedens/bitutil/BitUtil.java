package com.wedens.bitutil;

public class BitUtil {

	private static void setBit(byte[] data, int pos, int val) {
		int  posByte  = pos / 8;
		int  posBit   = pos % 8;
		byte oldByte  = data[posByte];
		oldByte       = (byte) (((0xFF7F >> posBit) & oldByte) & 0x00FF);
		byte newByte  = (byte) ((val << (8 - (posBit + 1))) | oldByte);
		data[posByte] = newByte;
	}

	private static int getBit(byte[] data, int pos) {
		int  posByte = pos / 8;
		int  posBit  = pos % 8;
		byte valByte = data[posByte];
		int  valInt  = valByte >> (8 - (posBit + 1)) & 0x0001;
		return valInt;
	}

	private static byte[] rotateLeft(byte[] in, int len, int step) {
		int numOfBytes = (len - 1) / 8 + 1;
		byte[] out = new byte[numOfBytes];
		for (int i = 0; i < len; i++) {
			int val = getBit(in, (i + step) % len);
			setBit(out, i, val);
		}
		return out;
	}
}
