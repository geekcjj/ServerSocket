package com.serverSocket.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


//�������ڵȴ��ͷ�������
public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(23456); //�˿�
			while(true){
				//ÿ����һ���ͷ������Ӿ���һ��socket
				Socket socket =  serverSocket.accept();//����
//				JOptionPane.showMessageDialog(null, "�пͷ������ӵ����ص�23457�˿�");	
				ChatSocket cs = new ChatSocket(socket);
				cs.start();         
 	               			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
