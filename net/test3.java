package net;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

class TelnetApp extends Applet implements Runnable
{
    //声明成员变量

    Thread client;
    TextArea log;

    TextField hostname;
    TextField userid;
    TextField password;
    Label hname;
    Label uid;
    Label psd;

    Button connect;
    Button bye;
    int wantTime;
    boolean logged;

    Socket socket = null;
    PrintStream os;
    DataInputStream is;

    public TelnetApp(){}

    public void init()
    {	resize(400, 300);

        setLayout(new BorderLayout());

        Panel p1 = new Panel();
        log = new TextArea(10, 80);
        log.setEditable(false);
        p1.add(log);
        add("North", p1);

        Panel p2 = new Panel();
        p2.add(hname = new Label("Hostname:"));
        p2.add(hostname = new TextField(20));
        p2.add(uid = new Label("Userid:"));
        p2.add(userid = new TextField(10));
        p2.add(psd = new Label("Password:"));
        p2.add(password = new TextField(10));
        password.setEchoCharacter('*');

        add("Center", p2);

        Panel p3 = new Panel();
        p3.add(connect = new Button("Connect"));
        p3.add(bye = new Button("Bye"));
        bye.disable();
        add("South", p3);
        logged = false;
    }

    public void run()
    {	String fromServer = null;
        byte b[] = new byte[3];
        b[0] = (byte)'n';
        while(true)
        {	if((fromServer = getData())!=null)
            log.appendText(fromServer+"\n");
            if(wantTime <0)
            {	bye();
                break;
            }
            if(logged)
            {	delay(60*1000);
                log.setText("");
                wantTime-=1;
                sendData(b, 1);
            }
        }
    }
    // 建立主机连接
    private boolean connectHost(String hostName)
    {	try
    {	socket = new Socket(hostName, 23);
        os = new PrintStream(socket.getOutputStream());
        is = new DataInputStream(socket.getInputStream());
    }catch(UnknownHostException e)
    {	log.setText("Trying to connect to unknown host:" + e);
        return false;
    }catch(Exception e)
    {	log.setText("Exception: "+e);
        return false;
    }
        return true;
    }

    // 接收信息
    String getData()
    {	String fromServer;
        int len;
        byte b[] = new byte[1000];
        try
        {	fromServer = "";
            len = is.read(b);

            fromServer += new String(b, 0);
        }catch(Exception e)
        {	log.setText("Exception: "+e);
            return null;
        }
        return fromServer;
    }

    // 发送信息
    boolean sendData(byte b[], int len)
    {	try
    {	os.write(b, 0, len);
        os.flush();
    }catch(Exception e)
    {	log.setText("Exception: "+e);
        return false;
    }
        return true;
    }

    //关闭连接

    void closeSocket()
    {	try
    {	os.close();
        is.close();
        socket.close();
        socket = null;
    }catch(Exception e)
    {	log.setText("Exception: "+e);
    }
    }

    void toByte(byte[] b, String s)
    {	int i;

        for(i=0;i<s.length();i++)
            b[i]=(byte)s.charAt(i);
        b[i] = 13;
        b[i+1] = 10;
    }

    void negotiate()
    {	byte b[] = new byte[20];
        b[0]=-1;b[1]=-5;b[2]=24;
        sendData(b, 3);
        delay(400);

        b[0]=-1;b[1]=-6;b[2]=24;
        b[3]=0;b[4]=(byte)'D';b[5]=(byte)'E';
        b[6]=(byte)'C';b[7]=(byte)'-';b[8]=(byte)'V';
        b[9]=(byte)'T';b[10]=(byte)'1';b[11]=(byte)'0';
        b[12]=(byte)'0';b[13]=-1;b[14]=-16;
        sendData(b, 15);
        delay(400);

        b[0]=-1;b[1]=-3;b[2]=1;
        b[3]=-1;b[4]=-3;b[5]=3;
        b[6]=-1;b[7]=-5;b[8]=31;
        b[9]=-1;b[10]=-4;b[11]=-56;
        b[12]=-1;b[13]=-5;b[14]=1;
        sendData(b, 15);
        delay(400);

        // 在bbs上注册
        toByte(b, "bbs");
        sendData(b, 5);
        delay(400);
    }

    void login(String userid, String password)
    {	byte b[] = new byte[20];
        toByte(b, userid);
        sendData(b, userid.length()+2);
        delay(400);

        toByte(b, password);
        sendData(b, password.length()+2);
        delay(400);
    }

    boolean enter()
    {	if(connectHost(hostname.getText().trim()))
    {	log.setText("connected\n");


        negotiate();
        delay(400);

        login(userid.getText().trim(), password.getText().trim());
        delay(400);
        return true;
    }else return false;
    }


    void toMainmenu()
    {	byte b[] = new byte[20];

        for(int i=0;i<6;i++)
        {	toByte(b, "");
            sendData(b, 2);
        }

        for(int i=0;i<1;i++)
        {	b[0] = (byte)'q';
            sendData(b, 1);
            delay(200);
        }
    }

    void bye()
    {	byte b[] = new byte[20];

        for(int i=0;i<10;i++)
        {	b[0] = (byte)'q';
            sendData(b, 1);
            delay(300);
        }

        b[0]=(byte)'g';
        sendData(b, 1);
        delay(300);
        for(int i=0;i<6;i++)
        {	toByte(b, "");
            sendData(b, 2);
            delay(300);
        }
        client.stop();
        client=null;
        closeSocket();
        connect.enable();
        bye.disable();
    }

    void delay(int millisecond)
    {	try
    {	Thread.sleep(millisecond);
    }catch(InterruptedException e){	}
    }

    public boolean action(Event e, Object arg)
    {	switch(e.id){
        case Event.ACTION_EVENT:
            if(e.target == connect)
            {	wantTime = 20;
                connect.disable();
                bye.enable();
                client = new Thread(this);
                client.start();
                if(enter())
                    toMainmenu();
                logged = true;
            }else if(e.target == bye)
                bye();
    }
        return true;
    }

    public void destroy(){}

    public void paint(Graphics g){}

    public void start(){}

    public void stop(){}
}