package com.serverSocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class MyserverSocket {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(2345); //�˿�
			Socket socket =  serverSocket.accept();//����
			JOptionPane.showMessageDialog(null, "�пͷ������ӵ����ص�12345�˿�");
			//�������ֵ�˱�ʾ����������
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
