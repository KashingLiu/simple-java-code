package net;
import java.net.*;
import java.io.*;

class SimpleClient
{	public static void main(String args[]) throws IOException
{	int c;
    Socket s1;
    InputStream s1In;
    DataInputStream dis;

    // 	在端口5432打开连接
    s1 = new Socket("10.236.58.174",5432);
    // 获得socket端口的输入句柄，并从中读取数据
    s1In = s1.getInputStream();
    dis = new DataInputStream(s1In);

    String st = new String(dis.readUTF());
    System.out.println(st);

    //	操作结束，关闭数据流及socket连接
    dis.close();
    s1In.close();
    s1.close();
}
}