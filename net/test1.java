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

    // 通过5432端口建立连接
    try
    {	s = new ServerSocket(5432);
    }
    catch(IOException e){ }

    // 循环运行监听程序，以监视连接请求
    while (true)
    {	try
    {	// 监听端口请求，等待连接
        s1 = s.accept();
        // 得到与socket相连接的数据流对象
        s1out = s1.getOutputStream();
        dos = new DataOutputStream(s1out);

        // 发送字符串
        dos.writeUTF(sendString);

        //  关闭数据流（但不是关闭socket连接）
        dos.close();
        s1out.close();
        s1.close();
    }
    catch(IOException e){ }
    }
}
}