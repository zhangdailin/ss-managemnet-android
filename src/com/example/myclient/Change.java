 package com.example.myclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.myclient.R;

public class Change extends Activity{
	
	private static final String ipAdress="118.89.147.152";
	
    private EditText lblPort;
    private EditText lblPd;
    private EditText lblMd;
    private EditText lblprotocol;
    private EditText lblprotocol_param;
    private EditText lblobfs;
    private EditText lblobfs_param;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        
        lblPort=(EditText)this.findViewById(R.id.txtPort);
        lblPd=(EditText)this.findViewById(R.id.txtPd);
        lblMd=(EditText)this.findViewById(R.id.txtMd);
        lblprotocol=(EditText)this.findViewById(R.id.txtprotocol);
        lblprotocol_param=(EditText)this.findViewById(R.id.txtprotocol_param);
        lblobfs=(EditText)this.findViewById(R.id.txtobfs);
        lblobfs_param=(EditText)this.findViewById(R.id.txtobfs_param);
        
        UserVO o=new UserVO();
        String port=o.getPort();
        String pd=o.getPwd();
        String md=o.getMd();
		String protocol=o.getProtocol();
		String obfs=o.getObfs();
		String protocol_param=o.getProtocol_param();
		String obfs_param=o.getObfs_param();
		lblPort.setText(port);
		lblPd.setText(pd);
		lblMd.setText(md);
		lblprotocol.setText(protocol);
		lblobfs.setText(obfs);
		lblprotocol_param.setText(protocol_param);
		lblobfs_param.setText(obfs_param);
    }
}
