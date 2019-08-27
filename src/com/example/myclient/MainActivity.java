package com.example.myclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.example.myclient.MainActivity;
import com.example.myclient.R;
import com.example.myclient.Utilies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button btnChange;
    private TextView lblPort;
    private TextView lblPd;
    private TextView lblMd;
    private TextView lblprotocol;
    private TextView lblprotocol_param;
    private TextView lblobfs;
    private TextView lblobfs_param;
    
	private static final String ipAdress="118.89.147.152";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        lblPort=(TextView)this.findViewById(R.id.lblPort);
        lblPd=(TextView)this.findViewById(R.id.lblPd);
        lblMd=(TextView)this.findViewById(R.id.lblMd);
        lblprotocol=(TextView)this.findViewById(R.id.lblprotocol);
        lblprotocol_param=(TextView)this.findViewById(R.id.lblprotocol_param);
        lblobfs=(TextView)this.findViewById(R.id.lblobfs);
        lblobfs_param=(TextView)this.findViewById(R.id.lblobfs_param);
        try{        	
        	Socket s1=new Socket(ipAdress,6666);
        	OutputStream os=s1.getOutputStream();
        	DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(Utilies.curUser.getUsername() + " "
					+ Utilies.curUser.getPwd()+" "+"Line");
        	InputStream is=s1.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			String []getStr = dis.readUTF().split(" ");;//用空格把账号和密码分开存储
			String a=getStr[0];
			String b=getStr[1];
			String c=getStr[2];
			String d=getStr[3];
			String e=getStr[4];
			String f=getStr[5];
			String g=getStr[6];
			lblPort.setText(a);
			lblPd.setText(b);
			lblMd.setText(c);
			lblprotocol.setText(d);
			lblobfs.setText(e);
			lblprotocol_param.setText(f);
			lblobfs_param.setText(g);
        	
        	UserVO o=new UserVO();
			o.setPort(a);
			o.setPwd(b);
			o.setMd(c);
			o.setProtocol(d);
			o.setObfs(e);
			o.setProtocol_param(f);
			o.setObfs_param(g);
			
			dis.close();
        	dos.close();

        }catch(Exception e){
        	e.printStackTrace();
        	Toast.makeText(getApplicationContext(), "客户端信息传送失败",
        		     Toast.LENGTH_SHORT).show();
        }    
        btnChange=(Button)findViewById(R.id.btnChange);  
        btnChange.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this,Change.class);
				startActivity(intent);					
			}
		});
    }

}