package com.serverSocket.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

//�������ڵȴ��ͷ�������
public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(23457); //�˿�
			while(true){
				//ÿ����һ���ͷ������Ӿ���һ��socket
				Socket socket =  serverSocket.accept();//����
				JOptionPane.showMessageDialog(null, "�пͷ������ӵ����ص�23457�˿�");	

				 // ��Socket���еõ�InputStream����
		        InputStream inputStream = socket.getInputStream();  
		        byte buffer[] = new byte[1024 * 4];  
		        int temp = 0;  
		        // ��InputStream���ж�ȡ�ͻ��������͵�����  
		        while ((temp = inputStream.read(buffer)) != -1) {  
		            System.out.println(new String(buffer, 0, temp));  
		        }  
		        serverSocket.close();  
		        
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
