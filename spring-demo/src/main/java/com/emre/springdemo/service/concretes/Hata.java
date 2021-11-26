package com.emre.springdemo.service.concretes;

public class Hata {
	public static void HataVer() {
		throw new RuntimeException("Transaction hatasi");
	}
}
