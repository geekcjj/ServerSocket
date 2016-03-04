package com.serverSocket.main;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Vector;

//�������ڶ��socket֮��ͨ�Ź���
public class ChatManager {
	
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	//Ϊ�������һ���µ�socket����
	public void add(ChatSocket cs) {
		vector.add(cs);
	}
	
	public void remove(ChatSocket cs) {
		vector.remove(cs);
	}
	
	//���Ƚ��Լ����ݽ������ڴ���һ�����͵���Ϣ
	public void publish(ChatSocket cs,String out) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket csChatSocket = vector.get(i); //��ȡѭ���е�I������
			if (!cs.equals(csChatSocket)) { //������ǵ�ǰ
				csChatSocket.print(out);
			}
		}
	}
}
