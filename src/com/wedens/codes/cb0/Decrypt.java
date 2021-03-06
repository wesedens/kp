package com.wedens.codes.cb0;

import com.wedens.bitutil.BitUtil;
import com.wedens.bitutil.Rotate;

public class Decrypt {
	
	public static String breakCode(String str)
	{
		//tryRotate(str,  8);
		//tryRotate(str, 16);
		
		tryInts(str,  5);
//		tryInts(str, 16);
		return null;
	}
	
	public static void tryInts(String str, int size)
	{
		String[] blocks = Decrypt.split(str, size);
		
		for(int i=0; i<=0; ++i){
			System.out.printf("Rotated Int[%d] %d\n\n",size,i);
			printi(blocks, i);
			System.out.printf("\n\n\n");
		}
	}
	
	public static void tryRotate(String str, int size)
	{
		String[] blocks = Decrypt.split(str, size);
		
		for(int i=-255; i<=255; ++i){
			System.out.printf("Rotated Char[%d] %d\n\n",size,i);
			prints(blocks, i);
			System.out.printf("\n\n\n");
		}
	}
	
	private static void prints(String[] blocks, int rotate)
	{
		for(String s : blocks){
			int ch = Integer.parseInt(s,2);
			char c = (char)ch;
			//char c = (char)Rotate.rotl(ch, rotate);
			System.out.printf("%c",(char)((c+rotate)%0xff));
		}
		System.out.println("");
	}
	
	private static void printc(String[] blocks, int rotate)
	{
		for(String s : blocks){
			int ch = Integer.parseInt(s,2);
			char c = (char)Rotate.rotl(ch, rotate);
			System.out.printf("%c",c);
		}
		System.out.println("");
	}
	
	private static void printi(String[] blocks, int rotate)
	{
		for(String s : blocks){
			System.out.printf("%s ", s);
			int ch = Integer.parseInt(s,2);
			System.out.printf("%d ",ch+rotate);
		}
		System.out.println("");
	}
	
	private static String[] split(String s, int size)
	{
		int      numBlocks = s.length()/size;
		String[] blocks    = new String[numBlocks];
		int      blockCnt  = 0;
		int      cnt       = 0;
		
		for(;blockCnt+size < s.length(); blockCnt+=size){
			blocks[cnt++] = s.substring(blockCnt, blockCnt+size);
		}
		return blocks;
	}
}
