package com.tjbenator;

public class Calculate {
	//Input IP Address and Subnet Mask
	//IP Address
	private int a = 10;
	private int b = 13;
	private int c = 37;
	private int d = 0;

	//Subnet Mask
	private int sa = 255;
	private int sb = 255;
	private int sc = 255;
	private int sd = 128;
	
	/*******************************************/
	
	private int na, nb, nc, nd;
	private int fa, fb, fc, fd;
	private int la, lb, lc, ld;
	private int wa, wb, wc, wd;
	private int ba, bb, bc, bd;
	
	public void init() {
		//Calculate Network Address
		na = sa & a;
		nb = sb & b;
		nc = sc & c;
		nd = sd & d;

		//Calculate First Address
		fa = na;
		fb = nb;
		fc = nc;
		fd = nd + 1; 
		
		//Wildcard Netmask
		wa = ~sa & 0xff;
		wb = ~sb & 0xff;
		wc = ~sc & 0xff;
		wd = ~sd & 0xff;

		//Calculate Broadcast Address
		ba = a | wa;
		bb = b | wb;
		bc = c | wc;
		bd = d | wd;

		//Calculate Last Address
		la = ba;
		lb = bb;
		lc = bc;
		ld = bd - 1;
	}
	// "192.168.0.1"
	public void setIP(String ip) {
		String[] oct = new String[5];
		oct = ip.split("\\.");
		a = (int) Double.parseDouble(oct[0]);
		b = (int) Double.parseDouble(oct[1]);
		c = (int) Double.parseDouble(oct[2]);
		d = (int) Double.parseDouble(oct[3]);
	}
	
	public void setSubnet(String subnet) {
		String[] oct = subnet.split("\\.");
		sa = (int) Double.parseDouble(oct[0]);
		sb = (int) Double.parseDouble(oct[1]);
		sc = (int) Double.parseDouble(oct[2]);
		sd = (int) Double.parseDouble(oct[3]);
	}
	
	public String getFirstadd() {
		return fa + "." + fb + "." + fc + "." + fd;
	}
	
	public String getLastadd() {
		return la + "." + lb + "." + lc + "." + ld;
	}
	
	public String getBroadcast() {
		return ba + "." + bb + "." + bc + "." + bd;
	}
	
	public String getWildcard() {
		return wa + "." + wb + "." + wc + "." + wd;
	}
}
