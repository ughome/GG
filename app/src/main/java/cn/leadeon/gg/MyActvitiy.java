package cn.leadeon.gg;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/17.
 */
public class MyActvitiy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);//不想要默认的title，

        View view = LayoutInflater.from(this).inflate(R.layout.mydialog, null);
        dialog.setContentView(view);
        Button btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hahh", Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
        //一定是显示出来之后在调整,高度一般都是自适应
        Window window=dialog.getWindow();
        WindowManager.LayoutParams lp= dialog.getWindow().getAttributes();
        WindowManager m = ((Activity)this).getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        lp.width = (int) (d.getWidth() * 0.8); // 高度设置为屏幕的0.6
        window.setAttributes(lp);


    }
}
