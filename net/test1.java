package net;

import java.net.*;
import java.io.*;

class SimpleServer
{	public static void main(String args[])
{	ServerSocket s = null;
    Socket s1;
    String sendString = "Hello Mr.Wang";
//    sendString = sendString.
    int slength = sendString.length();
    OutputStream s1out;
    DataOutputStream dos;

    // ͨ��5432�˿ڽ�������
    try
    {	s = new ServerSocket(5432);
    }
    catch(IOException e){ }

    // ѭ�����м��������Լ�����������
    while (true)
    {	try
    {	// �����˿����󣬵ȴ�����
        s1 = s.accept();
        // �õ���socket�����ӵ�����������
        s1out = s1.getOutputStream();
        dos = new DataOutputStream(s1out);

        // �����ַ���
        dos.writeUTF(sendString);

        //  �ر��������������ǹر�socket���ӣ�
        dos.close();
        s1out.close();
        s1.close();
    }
    catch(IOException e){ }
    }
}
}