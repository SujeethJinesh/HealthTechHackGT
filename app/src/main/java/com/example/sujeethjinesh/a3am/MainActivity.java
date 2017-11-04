package com.example.sujeethjinesh.a3am;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Somehow get our edit text, buttons in code
        emailEditText = (EditText) findViewById(R.id.email_text);
        Button emailButton = (Button) findViewById(R.id.email_button);
        Button facebookButton = (Button) findViewById(R.id.facebook_button);

        //email button should open the email, take the text that we have, and then put in the email body
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openEmail = new Intent();
                openEmail.setData(Uri.parse("mailto:"));
                openEmail.putExtra(Intent.EXTRA_TEXT, emailEditText.getText());
                openEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"sujeethjinesh@gmail.com", "aosdhaosdh@gmail.com"});

                if(openEmail.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(openEmail, 0);
                }
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/sujeeth.jinesh");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
