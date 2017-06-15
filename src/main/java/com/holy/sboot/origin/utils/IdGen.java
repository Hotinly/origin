package com.holy.sboot.origin.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Holy
 * @date 2017年6月15日 下午3:46:53
 * @ref https://github.com/zzzhan/js-shortid/blob/master/lib/js-shortid.js
 */
public class IdGen {

	public static String gen() {
		long initime = 1463305445000L;
		long elapsed = new Date().getTime() - initime;

		String base = new IdGen().getBase(elapsed);
		String salts = new IdGen().getSalts();

		return base + salts;
	}

	private String getBase(long elapsed) {
		String[] base62 = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z"
				.split(",");
		int group = base62.length;
		String str = "";
		while (elapsed >= 1) {
			str = base62[(int) (elapsed - (group * (elapsed / group)))] + str;
			elapsed = elapsed / group;
		}
		return str;
	}

	private String getSalts() {
		int len = 2;
		String str = "";
		for (int i = 0; i < len; i++) {
			long random = (long) (Math.random() * 3384);
			str += getBase(random);
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(IdGen.gen().length());
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			String id = IdGen.gen();
			if (lst.contains(id)) {
				System.out.println("==============" + i + "==============");
				break;
			}
			lst.add(id);
		}
		System.out.println(lst.size());
	}
}
