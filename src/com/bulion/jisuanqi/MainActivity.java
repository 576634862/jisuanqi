package com.bulion.jisuanqi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button bt_0,bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_point,bt_clear,bt_del,bt_divide,
	bt_multipy,bt_minus,bt_plus,bt_equle;
	EditText et_input;
	boolean clear_flag;//清空
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt_0 = (Button) findViewById(R.id.bt_0);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_4 = (Button) findViewById(R.id.bt_4);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_6 = (Button) findViewById(R.id.bt_6);
		bt_7 = (Button) findViewById(R.id.bt_7);
		bt_8 = (Button) findViewById(R.id.bt_8);
		bt_9 = (Button) findViewById(R.id.bt_9);
		bt_point = (Button) findViewById(R.id.bt_point);
		bt_clear = (Button) findViewById(R.id.bt_clear);
		bt_del = (Button) findViewById(R.id.bt_del);
		bt_divide = (Button) findViewById(R.id.bt_divide);
		bt_multipy = (Button) findViewById(R.id.bt_multipy);
		bt_minus = (Button) findViewById(R.id.bt_minus);
		bt_plus = (Button) findViewById(R.id.bt_plus);
		bt_equle = (Button) findViewById(R.id.bt_equle);
		et_input=(EditText) findViewById(R.id.et_input);


		bt_0.setOnClickListener(this);
		bt_1.setOnClickListener(this);
		bt_2.setOnClickListener(this);
		bt_3.setOnClickListener(this);
		bt_4.setOnClickListener(this);
		bt_5.setOnClickListener(this);
		bt_6.setOnClickListener(this);
		bt_7.setOnClickListener(this);
		bt_8.setOnClickListener(this);
		bt_9.setOnClickListener(this);
		bt_point.setOnClickListener(this);
		bt_clear.setOnClickListener(this);
		bt_del.setOnClickListener(this);
		bt_divide.setOnClickListener(this);
		bt_multipy.setOnClickListener(this);
		bt_minus.setOnClickListener(this);
		bt_plus.setOnClickListener(this);
		bt_equle.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		String str = et_input.getText().toString();
//		if(str ==null && str.equals(" ")){
//			Toast.makeText(MainActivity.this,"weikong", 1).show();
//		}
		switch (v.getId()) {
		case R.id.bt_0:
		case R.id.bt_1:
		case R.id.bt_2:
		case R.id.bt_3:
		case R.id.bt_4:
		case R.id.bt_5:
		case R.id.bt_6:
		case R.id.bt_7:
		case R.id.bt_8:
		case R.id.bt_9:
		case R.id.bt_point:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+((Button)v).getText());
			break;
		case R.id.bt_plus:
		case R.id.bt_minus:
		case R.id.bt_multipy:
		case R.id.bt_divide:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			}
		et_input.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.bt_del:
			if(clear_flag){
				clear_flag=false;
				str="";
				et_input.setText("");
			}else if(str!=null && !str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.bt_clear:
			clear_flag=false;
			str="";
			et_input.setText("");
			break;
		case R.id.bt_equle:
			getResult();
			break;
		}
	}
	
	private void getResult(){
		String exp = et_input.getText().toString();
		if(exp==null || exp.equals("")){
			return;
		}
		if(!exp.contains("")){
			return;
		}
		if(clear_flag){
			clear_flag=false;
			return;
		}
		clear_flag=true;
		double result=0;
		String s1=exp.substring(0,exp.indexOf(" "));//运算符前面的字符
		String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//+1为运算符的位置，+2位运算符下面的位置
		String s2=exp.substring(exp.indexOf(" ")+3);//运算符后面的字符
		if(!s1.equals("")&& !s2.equals("")){
			//转换double类型
			double d1=Double.parseDouble(s1);
			double d2=Double.parseDouble(s2);
			if(op.equals("+")){
				result = d1+d2;
			}else if(op.equals("-")){
				result = d1-d2;
			}else if(op.equals("×")){
				result = d1*d2;
			}else if(op.equals("÷")){
				if(d1==0){
					result=0;
				}else{
				result = d1/d2;
			}
		}
		if(!s1.contains(".") && !s2.contains(".") && !op.equals("÷")){
			int r =(int) result;
			et_input.setText(r+"");//如果d1和d2不带点那么就是int类型
		}else{
			et_input.setText(result+"");
		}
	    }else if(!s1.equals("") && s2.equals("")){
//	    	double d2=Double.parseDouble(s2);
//	    	String dd = et_input.getText().toString();
//	    	double d1 =Double.parseDouble(dd);
//			if(op.equals("+")){
//				result = d1+d2;
//			}else if(op.equals("-")){
//				result = d1-d2;
//			}else if(op.equals("×")){
//				result = d1*d2;
//			}else if(op.equals("÷")){
//				if(d1==0){
//					result=0;
//				}else{
//				result = d1/d2;
//			}
//		}
//		if(!s1.contains(".") && !s2.contains(".") && !op.equals("÷")){
//			int r =(int) result;
//			et_input.setText(r+"");//如果d1和d2不带点那么就是int类型
//		}else{
//			et_input.setText(result+"");
//		}
		et_input.setText(exp);
		}else if(s1.equals(" ") && !s2.equals("")){
			et_input.setText(exp);
			double d2=Double.parseDouble(s2);
			if(op.equals("+")){
				result = 0+d2;
			}else if(op.equals("-")){
				result = 0-d2;
			}else if(op.equals("×")){
				result = 0;
			}else if(op.equals("÷")){
					result=0;
		}
		if(!s2.contains(".")){
			int r =(int) result;
			et_input.setText(r+" ");//如果d1和d2不带点那么就是int类型
		}else{
			et_input.setText(result+" ");
		}
	}else{
		et_input.setText(" ");
		}
  }
}
