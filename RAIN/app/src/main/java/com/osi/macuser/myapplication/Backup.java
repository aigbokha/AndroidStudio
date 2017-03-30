package com.osi.macuser.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
//public class MainActivity extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_list_item);
//	}
//}

public class Backup extends Activity {

    EditText txtName, txtEmail, txtPhone, txtAddress;
    RadioButton radioWhatsapp;
    RadioButton radioGmail;
    RadioButton radioFacebook;
    RadioButton radioInstagram;
    CheckBox checkVIP;
    CheckBox checkContacts;
    String Name, Email, Phone, Address;

    /**
     * Called when the activity is first created.
     */
    @Override


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // find View-elements
        txtName = (EditText) findViewById(R.id.txtName);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        radioWhatsapp = (RadioButton) findViewById(R.id.radioWhatsapp);
        radioGmail = (RadioButton) findViewById(R.id.radioGmail);
        radioFacebook = (RadioButton) findViewById(R.id.radioFacebook);
        radioInstagram = (RadioButton) findViewById(R.id.radioInstagram);
        checkVIP = (CheckBox) findViewById(R.id.checkVIP);
        checkContacts = (CheckBox) findViewById(R.id.checkContacts);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);


        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("createinfo");
        tabSpec.setContent(R.id.tabCreateInfo);
        tabSpec.setIndicator("CreateInfo");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);



        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        final Button buttonSend = (Button) findViewById(R.id.buttonSend);
        final Button buttonNext = (Button) findViewById(R.id.buttonNext);
        Button buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                buttonSend.setEnabled(!txtName.getText().toString().trim().isEmpty());
                buttonNext.setEnabled(!txtName.getText().toString().trim().isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


     /*   OnClickListener oclbuttonSend = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txtName.setText("Button Send clicked");
                txtEmail.setText("Button Send clicked");
                txtPhone.setText("Button Send clicked");
                txtAddress.setText("Button Send clicked");

            }
        };

        OnClickListener oclbuttonMoreInfo = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txtName.setText("Button MoreInfo clicked");
                txtEmail.setText("Button MoreInfo clicked");
                txtPhone.setText("Button MoreInfo clicked");
                txtAddress.setText("Button MoreInfo clicked");

            }
        };

        OnClickListener oclbuttonNext = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txtName.setText("Button Next clicked");
                txtEmail.setText("Button Next clicked");
                txtPhone.setText("Button Next clicked");
                txtAddress.setText("Button Next clicked");

            }
        };

        OnClickListener oclbuttonBack = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txtName.setText("Button Back clicked");
                txtEmail.setText("Button Back clicked");
                txtPhone.setText("Button Back clicked");
                txtAddress.setText("Button Back clicked");

            }
        };


        // assign click listener to the OK button (btnOK)
        buttonSend.setOnClickListener(oclbuttonSend);

        // assign click listener to the OK button (btnOK)
        buttonNext.setOnClickListener(oclbuttonNext);

        // assign click listener to the OK button (btnOK)
        buttonMoreInfo.setOnClickListener(oclbuttonMoreInfo);

        // assign click listener to the OK button (btnOK)
        buttonBack.setOnClickListener(oclbuttonBack);


    }

    public void screenOne (View view) {

        Name = txtName.getText().toString();
        Email = txtEmail.getText().toString();
        Phone = txtPhone.getText().toString();
        Name = txtName.getText().toString();



        Intent intent = new Intent(this, InfoString.class);
        intent.putExtra("Name", Name);
        intent.putExtra("Email", Email);
        intent.putExtra("Phone", Phone);
        intent.putExtra("Address", Address);
        startActivity(intent);

    }*/


    }
}