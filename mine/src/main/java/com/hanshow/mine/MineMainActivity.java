package com.hanshow.mine;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hanshow.commonlib.base.BaseActivity;
import com.hanshow.commonlib.constants.Page;
import com.hanshow.commonlib.utils.SpUtils;

@Route(path = Page.MINE)
public class MineMainActivity extends BaseActivity<MinePresenter> implements MineContact.IMineView, View.OnClickListener {


    private EditText mEtName;
    private EditText mEtPassword;
    private Button mBtLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_main;
    }

    @Override
    protected void init() {
        mEtName = findViewById(R.id.et_login_name);
        mEtPassword = findViewById(R.id.et_login_password);
        mBtLogin = findViewById(R.id.bt_login);

        String cookie = SpUtils.getString(getApplicationContext(), "cookie", "");
        if (!TextUtils.isEmpty(cookie)) {
            ARouter.getInstance().build(Page.HOME).navigation();
            finish();
        }

        mBtLogin.setOnClickListener(this);
    }

    @Override
    protected MinePresenter getPresenter() {
        return new MinePresenter();
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(MineBean.DataBean data) {
        SpUtils.putString(getApplicationContext(), "cookie", "1");

        SpUtils.putString(getApplicationContext(), "nickName", data.getNickname());
        ARouter.getInstance().build(Page.HOME).navigation();
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_login) {
            String userName = mEtName.getText().toString().trim();
            String password = mEtPassword.getText().toString().trim();

            mPresenter.login(userName, password);
        }
    }
}
