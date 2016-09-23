package com.example.lzd.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.util.Arrays;

import java.math.BigDecimal;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    初始化1
    */
    private Button button_ac;
    private Button button_del;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_0;
    private Button button_plus;
    private Button button_subtract;
    private Button button_multiply;
    private Button button_div;
    private Button button_point;
    private Button button_left;
    private Button button_right;
    private Button button_equal;
    private TextView tv_input;
    private boolean flag = false;
    private boolean fflag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        /*
        初始化2
         */
        button_ac = (Button) findViewById(R.id.button_ac);
        button_del = (Button) findViewById(R.id.button_del);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_0 = (Button) findViewById(R.id.button_0);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_subtract = (Button) findViewById(R.id.button_subtract);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_div = (Button) findViewById(R.id.button_div);
        button_point = (Button) findViewById(R.id.button_point);
        button_left = (Button) findViewById(R.id.button_left);
        button_right = (Button) findViewById(R.id.button_right);
        button_equal = (Button) findViewById(R.id.button_equal);
        tv_input = (TextView) findViewById(R.id.tv_input);

        /*
        设置按钮的点击事件
         */
        button_ac.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = (String) tv_input.getText();
        if(str == null || "".equals(str)) {
            str = "0";
            tv_input.setText("0");
        }
        switch (v.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                //显示
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }
                if(flag == true && fflag == true) {
                    str = "0";
                    fflag = false;
                    tv_input.setText("0");
                }
                if(tv_input.getText().toString().equals("0")) {
                    tv_input.setText(((Button)v).getText().toString());
                }else if(str.charAt(str.length()-1) == '0') {
                    boolean judge = true;
                    for(int i = str.length() - 2;i >= 0;i--) {
                        if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                            break;
                        }
                        if(str.charAt(i) != 0) {
                            judge = false;
                            break;
                        }
                    }
                    if(judge == false) {
                        tv_input.setText(str.concat(((Button) v).getText().toString()));
                    }else {
                        Toast.makeText(MainActivity.this,"把前面这个0去掉再输入~",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    tv_input.setText(str.concat(((Button) v).getText().toString()));
                }
                break;

            case R.id.button_point:
                //显示
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }
                if(flag == true && fflag == true) {
                    str = "0";
                    fflag = false;
                    tv_input.setText("0");
                }
                if(tv_input.getText().toString().equals("0")) {
                    tv_input.setText("0.");
                }else if(!(str.charAt(str.length()-1) == '+') && !(str.charAt(str.length()-1) == '-') && !(str.charAt(str.length()-1) == '*') && !(str.charAt(str.length()-1) == '/') && !(str.charAt(str.length()-1) == '(') && !(str.charAt(str.length()-1) == ')') && !(str.charAt(str.length()-1) == '.')){
                    boolean judge = true;
                    for(int i = str.length() - 2; i >= 0;i--) {
                        if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                            break;
                        }
                        if(str.charAt(i) == '.') {
                            Toast.makeText(MainActivity.this,"不要再输.了=_=",Toast.LENGTH_SHORT).show();
                            judge = false;
                            break;
                        }
                    }
                    if(judge) {
                        tv_input.setText(str.concat(((Button) v).getText().toString()));
                    }
                } else {
                    Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_left:
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }else if(fflag == true) {
                    str = "0";
                    fflag = false;
                    tv_input.setText("0");
                }
                if(str == null || tv_input.getText() == "0") {
                    tv_input.setText(((Button) v).getText().toString());
                }else if(!(str.charAt(str.length()-1) == '+') && !(str.charAt(str.length()-1) == '-') && !(str.charAt(str.length()-1) == '*') && !(str.charAt(str.length()-1) == '/') && !(str.charAt(str.length()-1) == '(')) {
                    Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                }else {
                    tv_input.setText(str.concat(((Button) v).getText().toString()));
                }
                break;

            case R.id.button_right:
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }
                if(str == null || tv_input.getText() == "0") {
                    break;
                }
                int m = 0;
                int n = 0;
                for(int i = 0; i < str.length() - 1;i++) {
                if(str.charAt(i) == '(') {
                    m++;
                    }
                }
                for(int i = 0; i < str.length() - 1;i++) {
                    if(str.charAt(i) == ')') {
                        n++;
                    }
                }
                if(str.charAt(str.length() - 1) == '(' || str.charAt(str.length() - 1) == '.' || str.charAt(str.length()-1) == '+' || str.charAt(str.length()-1) == '-' || str.charAt(str.length()-1) == '*' || str.charAt(str.length()-1) == '/') {
                    Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                }else if (n < m){
                    tv_input.setText(str.concat(((Button) v).getText().toString()));
                }else {
                    Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_plus:
            case R.id.button_multiply:
            case R.id.button_div:
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }
                if(flag == true && fflag == true) {
                    str = "0";
                    fflag = false;
                    tv_input.setText("0");
                }
                if((str != null) && (str.matches("[0-9]"))) {
                    tv_input.setText(str.concat(((Button)v).getText().toString()));
                }else if(!(str == null) && (str.length() > 1)) {
                    if(str.charAt(str.length()-1) == '+' || str.charAt(str.length()-1) == '-' || str.charAt(str.length()-1) == '*' || str.charAt(str.length()-1) == '/') {
                        if(str.charAt(str.length()-2) == '.' || str.charAt(str.length()-2) == '(') {
                            Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                        }else {
                            str = str.substring(0,str.length()-1);
                            tv_input.setText(str.concat(((Button) v).getText().toString()));
                        }
                    }else if(str.charAt(str.length()-1) == '.' || str.charAt(str.length()-1) == '(') {
                        Toast.makeText(MainActivity.this,"输入有误，请重新输入",Toast.LENGTH_SHORT).show();
                    }else {
                        tv_input.setText(str.concat(((Button)v).getText().toString()));
                    }
                }else if(str == null) {
                    str = "0";
                    tv_input.setText(str.concat(((Button)v).getText().toString()));
                }else if(flag == true && tv_input.getText().equals("错误")){
                    Toast.makeText(MainActivity.this,"错误数据不能再进行计算，请先按AC清除~",Toast.LENGTH_SHORT).show();
                }else {}
                break;

            case R.id.button_subtract:
                if(flag == true) {
                    str = "";
                    flag = false;
                    tv_input.setText("0");
                }
                if(flag == true && fflag == true) {
                    str = "0";
                    fflag = false;
                    tv_input.setText("0");
                }
                if(str == null || "".equals(str)) {
                    tv_input.setText(str.concat(((Button)v).getText().toString()));
                }else if("0".equals(str)) {
                    str = ((Button)v).getText().toString();
                    tv_input.setText(str);
                }else if (str.charAt(str.length()-1) == '.') {
                    Toast.makeText(MainActivity.this,"把数字输完再输符号哟~",Toast.LENGTH_SHORT).show();
                }else if(str.charAt(str.length()-1) == '+' || str.charAt(str.length()-1) == '-' || str.charAt(str.length()-1) == '*' || str.charAt(str.length()-1) == '/') {
                    str = str.substring(0,str.length()-1);
                    tv_input.setText(str.concat(((Button)v).getText().toString()));
                }else if(flag == true && tv_input.getText().equals("错误")){
                    Toast.makeText(MainActivity.this,"错误数据不能再进行计算，请先按AC清除~",Toast.LENGTH_SHORT).show();
                }else {
                    tv_input.setText(str.concat(((Button)v).getText().toString()));
                }
                break;

            case R.id.button_ac:
                tv_input.setText("0");
                str = "";
                flag = false;
                break;

            case R.id.button_del:
                if ("".equals(str) || str == null || fflag == true) {
                    tv_input.setText("0");
                }else {
                    str = str.substring(0, str.length() - 1);
                    tv_input.setText(str);
                }
                flag = false;
                break;

            case R.id.button_equal:
                if(flag == true || fflag == true) {
                }else {
                    if (tv_input.getText().equals("0") || str == null) {
                        tv_input.setText("0");
                    } else {
                        int cntleft = 0;
                        int cntright = 0;
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == '(') {
                                cntleft++;
                            } else if (str.charAt(i) == ')') {
                                cntright++;
                            }
                        }
                        if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '*' || str.charAt(str.length() - 1) == '/' || str.charAt(str.length() - 1) == '.') {
                            Toast.makeText(MainActivity.this, "输入有误，请重新输入", Toast.LENGTH_SHORT).show();
                        } else if (!(cntleft == cntright)) {
                            Toast.makeText(MainActivity.this, "左右括号要一样多才可以计算呀>_<", Toast.LENGTH_SHORT).show();
                        } else if (str.matches("[0-9]+") || str.matches("-[0-9]+") || str.matches("[0-9]+\\.[0-9]+") || str.matches("-[0-9]+\\.[0-9]+")) {
                            tv_input.setText(str);
                        } else {
                            String result = getResult(str);
                            tv_input.setText(result);
                            str = "";
                        }
                    }
                }
                if(tv_input.getText().toString().equals("错误")){
                    fflag = true;
                }
                flag = true;
                break;

            default:
                break;
        }
    }

    /*
    计算
     */
    private String getResult(String str) {
        //分割
        String[] Str = segment(str);
        //中缀转后缀
        String newStr = infToSuf(Str);
        //后缀计算
        String result = sufToRes(newStr);
        return sufToRes(result);
    }


    /*
    	1.手动分割字符串
		*/
    private static String[] segment(String str) {

        String[] exp = new String[str.length()+1];
        //找最近的索引并截取字符串
        int l = str.length();
        for(int i = 0;i < l+1;i++) {
            int index;
            int[] ind = new int[6];
            ind[0] = str.indexOf('+');
            ind[1] = str.indexOf('-');
            ind[2] = str.indexOf('*');
            ind[3] = str.indexOf('/');
            ind[4] = str.indexOf('(');
            ind[5] = str.indexOf(')');
            if(ind[1] == 0) {
                Arrays.sort(ind);
                int t;
                for(t = 0;t <6;t++) {
                    if(ind[t] >= 0)
                        break;
                }
                int r = ind[t+1];
                exp[i] = str.substring(0,r);
                i++;
                exp[i] = str.substring(r,r+1);
                str = str.substring(r+1);
            }else if(((ind[1]-ind[4]) == 1) && (ind[4]==0)) {
                Arrays.sort(ind);
                int t ;
                for(t = 0;t <6;t++) {
                    if(ind[t] >= 0)
                        break;
                }
                int r = ind[t+1];
                exp[i] = str.substring(0,1);
                i++;
                exp[i] = str.substring(1,r+2);
                i++;
                exp[i] = str.substring(r+2,r+3);
                str = str.substring(r+3);
            }else {
                Arrays.sort(ind);
                int t;
                for(t = 0;t <6;t++) {
                    if(ind[t] >= 0)
                        break;
                }
                if(t==6)
                    break;
                index = ind[t];
                if(index!=0) {
                    exp[i] = str.substring(0,index);
                    i++;
                }
                exp[i] = str.substring(index,index+1);
                str = str.substring(index+1);
            }
        }
        int j = 0;
        int k = 0;
        for(; exp[j]!=null ;j++){}
        if(!exp[j-1].equals(")")) {
            exp[j]=str;
            str = "";
            k = j;
        }else {
            k = j-1;
        }
        String[] expp = new String[k+1];
        for(int t = 0; t < k+1;t++) {
            expp[t] = exp[t];
        }
        return expp;
        //System.out.println("分割的字符串:");
    }


    /*
    2.中缀转后缀
     */
    private static String infToSuf(String[] exp) {

        String newStrs = "";
        //初始化栈
        Stack<String> stack = new Stack<>();
	        /*
	                     判断并放入后缀表达式中：
	            for循环遍历整个str进行判断
	                     循环结束若栈不为空全部出栈
	        */
        int l = exp.length;
        for(int i = 0; i < l; i++) {
            if ((stack.empty()) && (exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/"))) {
                stack.push(exp[i]);
            } else if (exp[i].equals("(")) {
                stack.push(exp[i]);
            } else if (exp[i].equals("*") || exp[i].equals("/")) {
                while (stack.peek().equals("*") || stack.peek().equals("/")) {
                    newStrs = newStrs.concat(stack.pop()+" ");
                    if(stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(exp[i]);
            } else if (exp[i].equals("+") || exp[i].equals("-")) {
                while (!(stack.isEmpty())&&((stack.peek()).equals("*") || (stack.peek()).equals("/") || (stack.peek()).equals("+") || (stack.peek()).equals("-"))) {
                    newStrs = newStrs.concat(stack.pop()+" ");
                    if(stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(exp[i]);
            } else if (exp[i].equals(")")) {
                int t = stack.search("(");
                for (int k = 1; k < t; k++) {
                    newStrs = newStrs.concat(stack.pop()+" ");
                }
                String tstr = stack.pop();
            } else {
                newStrs = newStrs.concat(exp[i]+ " ");
            }
        }
        while (!stack.empty()) {
            if (!stack.peek().equals("(") || !stack.peek().equals(")")) {
                newStrs = newStrs.concat(stack.pop()+" ");
            } else if (stack.peek().equals("(") || stack.peek().equals(")")) {
                String tstr = stack.pop();
            }
        }
//      System.out.println("后缀:"+newStrs);
        return newStrs;
    }

    /*
    3.后缀计算结果
     */
    private static String sufToRes(String sufStr) {
        String[] exp = sufStr.split(" ");
        Stack<String> stack = new Stack<>();
        String Res = "";
        for(int i = 0;i < exp.length; i++) {
            if(!exp[i].equals("+") && !exp[i].equals("-") && !exp[i].equals("*") && !exp[i].equals("/")){
                stack.push(exp[i]);
            }else if(exp[i].equals("+")) {
                BigDecimal b2 = new BigDecimal(stack.pop());
                BigDecimal b1 = new BigDecimal(stack.pop());
                BigDecimal b3 = b1.add(b2);
                stack.push(b3.toString());
            }else if(exp[i].equals("-")) {
                BigDecimal b2 = new BigDecimal(stack.pop());
                BigDecimal b1 = new BigDecimal(stack.pop());
                BigDecimal b3 = b1.subtract(b2);
                stack.push(b3.toString());
            }else if(exp[i].equals("*")) {
                BigDecimal b2 = new BigDecimal(stack.pop());
                BigDecimal b1 = new BigDecimal(stack.pop());
                BigDecimal b3 = new BigDecimal(0);
                if(b1.compareTo(BigDecimal.ZERO)== 0|| b2.compareTo(BigDecimal.ZERO) == 0) {
                    b3 = BigDecimal.ZERO;
                }else {
                    b3 = b1.multiply(b2);
                }
                stack.push(b3.toString());
            }else if(exp[i].equals("/")){
                BigDecimal b2 = new BigDecimal(stack.pop());
                BigDecimal b1 = new BigDecimal(stack.pop());
                BigDecimal b3 = new BigDecimal(0);
                double d1 = b1.doubleValue();
                double d2 = b2.doubleValue();
                if(d2 == 0) {
                    Res = "错误";
                    return Res;
                }
                if(d1%d2 == 0){
                    b3 = (b1.divide(b2));
                    stack.push(b3.toString());
                }else {
                    b3 = b1.divide(b2,10, RoundingMode.HALF_UP);
                    stack.push(b3.toString());
                }
            }
        }
        Res = stack.pop();
        boolean flag = false;
        for (int m = 0; m < Res.length() - 1;m++) {
            if(Res.charAt(m) == '.'){
                flag = true;
            }
        }
        if(flag) {
            for(int m = Res.length()-1;m >= 0;m--) {
                if(Res.charAt(m) == '0'){
                }else {
                    Res = Res.substring(0,m+1);
                    break;
                }
            }
            if(Res.charAt(Res.length()-1) == '.') {
                Res = Res.substring(0,Res.length()-1);
            }
        }
        return Res;
    }
}