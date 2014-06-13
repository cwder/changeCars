package com.example.cwd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BordCast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
Toast.makeText(context, "ok", Toast.LENGTH_LONG).show();

System.out.println("BordCast");
	}

}
