package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FtpTest {

	@Test
	public void ftpTest() throws SocketException, IOException {
		
		FTPClient ftpClient = new FTPClient();
		
		ftpClient.connect("192.168.157.130", 21);
		
		ftpClient.login("ftpuser", "ftpuser");
		
		FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\limingchao\\Desktop\\6.jpg"));
		
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		
		ftpClient.storeFile("6.jpg", fileInputStream);
		
		ftpClient.logout();
		
	}
	
	@Test
	public void ftpUtilsTest() throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\limingchao\\Desktop\\6.jpg"));
		FtpUtil.uploadFile("192.168.157.130", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/2017", "marry.jpg", fileInputStream);
		
	}
	
}
