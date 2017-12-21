package top.chengzhen1971.dialogsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 内容一、
 * 注释方法一、在行前面加"//"
 * 注释方法二、在行首输入"/**",然后回车
 *
 * 内容二、对组件的操作步骤
 * 1、取个名
 *      Button btn_xxx
 * 2、去xml文件找到id
 *      Button btn_xxx = findViewById(R.id.【xml文件里的id】)
 *
 * 3、组件名称的后面加个点".",他就会弹出这个组件有哪些功能(方法名)，按需求选择即可
 *
 * 内容三、
 * 获取文本用 xxxx.getText().toString()
 * 设置文本用 xxxx.setText(【字符串变量（容器）】)
 *
 * 内容四、
 * 如何设置点击事件（点击后的响应）
 * 输入xxx.setOnClick ，在弹出列表里选择setOnclickListener,然后回车，
 * 在括号中写 "new V",即会弹出列表，选onClick(View view)，AS就会自动生成代码
 *
 * 内容五、代码的执行是按顺序一句一句执行的，暂时这样记！！！
 *
 * 内容六、全局变量：在所有方法外面产生(声明)的，
 *         局部变量：在别人方法内产生(声明)的，
 *         一般把界面上的View（组件）都做全局变量来声明
 *
 */


public class MainActivity extends AppCompatActivity {

    //全局变量
    TextView tv_answer;
    EditText et_question;
    Button btn_send;

    //方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化基本的数据
        initData();

        //初始化界面View
        initView();//initialize

        //需要某些启动的语句

    }

    void initData(){

    }


    void initView(){
        //1、拿到所有组件
        et_question = findViewById(R.id.et_question);
        tv_answer = findViewById(R.id.tv_answer);
        btn_send = findViewById(R.id.btn_send);

        //2、设置按钮响应
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBtnSend();
            }
        });
    }

    void clickBtnSend(){
        //局部变量
        String str_question = et_question.getText().toString();

        if(str_question.equals("")) {
            Toast.makeText(this,"请输入文字",Toast.LENGTH_LONG).show();
            return;
        }

        String strAnswer=getAnswer(str_question);

        answerInfo(str_question,strAnswer);
    }

    /**
     * answerInfo是方法名
     * str就是“传递参数”
     */
    void answerInfo(String str_quest,String str_answer){
        tv_answer.append ("主人："+str_quest+"\n");
        tv_answer.append("AI："+str_answer+"\n");
        et_question.setText("");
    }

    String getAnswer(String str_quest){
        String str_return = "";

        if(str_quest.equals("你好")) {
            str_return = "早上好";

        }else if(str_quest.equals("天气好吗")){
            str_return = "天气不错";

        }else if(str_quest.equals("心情如何")){
            str_return = "心情也不错";

        }else{
            str_return = "您说什么我听不懂";
        }

        return str_return;
    }

}
