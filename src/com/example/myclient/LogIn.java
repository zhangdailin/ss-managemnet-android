package com.example.myclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import com.example.myclient.R;
import com.example.myclient.Utilies;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends Activity{

	private EditText etxtUserName;
	private EditText etxtPassword;
	private Button btnLogin;
	private Button btnRegister;
	
	private static final String ipAdress="118.89.147.152";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        etxtUserName=(EditText) findViewById(R.id.etxtUserName);
        etxtPassword=(EditText) findViewById(R.id.etxtPassword);

        btnLogin=(Button) findViewById(R.id.cmdLogin);
        btnRegister=(Button) findViewById(R.id.btnRegister);
        
        btnLogin.setOnClickListener(new MyButtonOnClickListener());
        btnRegister.setOnClickListener(new MyButtonOnClickListener());
        
    }
   
    
    class MyButtonOnClickListener implements OnClickListener {

		public void onClick(View arg0) {
			Intent intent = new Intent();
			switch (arg0.getId()) {
			case R.id.cmdLogin:
				try{       
					if (etxtUserName.getText().toString().equals("admin")
							&& etxtPassword.getText().toString()
									.equals("admin")) {
						intent.setClass(LogIn.this,
								MainActivity.class);
						LogIn.this.startActivity(intent);
						finish();
					}
					else{
					StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
									.detectDiskReads().detectDiskWrites()
									.detectNetwork().penaltyLog().build());
					StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
							.detectLeakedSqlLiteObjects().penaltyLog()
							.penaltyDeath().build());
		        	Socket s1=new Socket(ipAdress,6666);
		        	OutputStream os=s1.getOutputStream();
		        	DataOutputStream dos=new DataOutputStream(os);
					dos.writeUTF(etxtUserName.getText().toString() + " "
							+ etxtPassword.getText().toString()+" "+"Login");
					String username=etxtUserName.getText().toString();
					String passwd=etxtPassword.getText().toString();
					UserVO o=new UserVO();
					o.setUsername(username);
					o.setPwd(passwd);
					Utilies.curUser=o;
					 new Handler().postDelayed(new Runnable(){  
					     public void run() {  
					     //execute the task  
					     }  
					  }, 1000); 
					InputStream is=s1.getInputStream();
					DataInputStream dis=new DataInputStream(is);
					String getStr=dis.readUTF();//YES»òÕßNO
					if(getStr.equals("YES")){
						intent.setClass(LogIn.this,
								MainActivity.class);
						LogIn.this.startActivity(intent);
						finish();
					}
					else if(getStr.equals("NO")){
						Toast.makeText(getApplicationContext(), "µÇÂ¼Ê§°Ü",
			        		     Toast.LENGTH_SHORT).show();
					}
					dis.close();
		        	dos.close();
		        	s1.close();
					}
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
				break;
			case R.id.btnRegister:
				try{
					StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
									.detectDiskReads().detectDiskWrites()
									.detectNetwork().penaltyLog().build());
					StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
							.detectLeakedSqlLiteObjects().penaltyLog()
							.penaltyDeath().build());
		        	Socket s1=new Socket(ipAdress,6666);
		        	OutputStream os=s1.getOutputStream();
		        	DataOutputStream dos=new DataOutputStream(os);
		        	dos.writeUTF("# # Register");//Ïò·þÎñÆ÷´«ËÍ# # Register×Ö·û
		        	dos.close();
		        	s1.close();
		        	
		        }catch(Exception e){
		        	e.printStackTrace();
		        	Toast.makeText(getApplicationContext(), "×¢²áÊ§°Ü IOException"+e.toString(),
		        		     Toast.LENGTH_SHORT).show();
		        }
				intent.setClass(LogIn.this,
						Register.class);
				LogIn.this.startActivity(intent);
				finish();
				break;
			}
		}
	}
}
