package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FtpTest {

	@Test
	public void ftpTest() throws SocketException, IOException {
		
		FTPClient ftpClient = new FTPClient();
		
		ftpClient.connect("192.168.157.130", 21);
		
		ftpClient.login("ftpuser", "ftpuser");
		
		FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\limingchao\\Desktop\\新建文本文档.txt"));
		
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		
		ftpClient.storeFile("test.txt", fileInputStream);
		
		ftpClient.logout();
		
	}
	
}
