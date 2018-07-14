package com.titouan.next.movilenext_class1_room;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.titouan.next.movilenext_class1_room.MainActivity.EXTRA_WORD;

public class NewWordActivity extends AppCompatActivity {

    @BindView(R.id.word)
    protected EditText mWord;

    @BindView(R.id.ok)
    protected Button mOkButton;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, NewWordActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ok)
    public void addWord() {
        if (!TextUtils.isEmpty(mWord.getText().toString())) {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_WORD, mWord.getText().toString());
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
