package net;
import java.net.*;
import java.io.*;

class SimpleClient
{	public static void main(String args[]) throws IOException
{	int c;
    Socket s1;
    InputStream s1In;
    DataInputStream dis;

    // 	�ڶ˿�5432������
    s1 = new Socket("10.236.58.174",5432);
    // ���socket�˿ڵ��������������ж�ȡ����
    s1In = s1.getInputStream();
    dis = new DataInputStream(s1In);

    String st = new String(dis.readUTF());
    System.out.println(st);

    //	�����������ر���������socket����
    dis.close();
    s1In.close();
    s1.close();
}
}