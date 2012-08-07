package com.tjbenator;

public class SubnetCalculator {
	
	// 192.168.0.1/25
	private static Calculate Cal = new Calculate();
	public static void main(String[] args) {
		Cal.setIP("192.168.0.1");
		Cal.setSubnet("255.255.255.0");
		Cal.init();
		System.out.println(Cal.getBroadcast());
		System.out.println(Cal.getFirstadd());
		System.out.println(Cal.getLastadd());
		System.out.println(Cal.getWildcard());
	}

	@SuppressWarnings("unused")
	private static void createOctalPrint(String label, int a, int b, int c, int d) {
		System.out.println(label + ": " + a + "." + b + "." + c + "." + d);
		
	}

	@SuppressWarnings("unused")
	private static void createOctalBinaryPrint(String label, int a, int b, int c, int d) {
		System.out.println(label + ": " + Integer.toBinaryString(a) + "."
				+ Integer.toBinaryString(b) + "." + Integer.toBinaryString(c)
				+ "." + Integer.toBinaryString(d));
	}


}
