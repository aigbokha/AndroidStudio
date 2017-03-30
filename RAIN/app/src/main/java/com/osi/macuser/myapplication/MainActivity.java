package com.osi.macuser.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;
import java.util.ArrayList;
import android.view.Menu;
import java.util.List;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import java.net.URI;
import android.view.View.OnClickListener;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//public class MainActivity extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_list_item);
//	}
//}

public class MainActivity extends Activity {

    EditText txtName, txtEmail, txtPhone, txtAddress;
    ImageView contactImageImgView;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;
    Uri imageUri = null;


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
        Button buttonNext = (Button) findViewById(R.id.buttonNext);
        Button buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        contactListView = (ListView) findViewById(R.id.listView);
        contactImageImgView = (ImageView) findViewById(R.id.imgViewContactImage);


        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("createinfo");
        tabSpec.setContent(R.id.tabCreateInfo);
        tabSpec.setIndicator("CreateInfo");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);


        final Button buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacts.add(new Contact(txtName.getText().toString(), txtEmail.getText().toString(), txtPhone.getText().toString(), txtAddress.getText().toString(), imageUri));
                populateList();
                Toast.makeText(getApplicationContext(), txtName.getText().toString() + "has been added to your contacts!", Toast.LENGTH_SHORT).show();
            }

        });


        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                buttonSend.setEnabled(!txtName.getText().toString().trim().isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        contactImageImgView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent.createChooser(intent, "Select Contact Image"), 1);
            }
        });


    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
            if (reqCode == 1){
                imageUri  = (Uri) data.getData();
                contactImageImgView.setImageURI(data.getData());
             }
        }
    }

    private void populateList(){
        ArrayAdapter<Contact> adapter = new ContactListAdapter();
        contactListView.setAdapter(adapter);
    }

    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter(){
            super (MainActivity.this, R.layout.listview_item, Contacts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContacts = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.contactName);
            name.setText(currentContacts.getName());
            TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
            name.setText(currentContacts.getName());
            TextView address = (TextView) view.findViewById(R.id.cAddress);
            name.setText(currentContacts.getName());
            TextView email = (TextView) view.findViewById(R.id.emailAddress);
            name.setText(currentContacts.getName());
            ImageView ivContactImage = (ImageView) view.findViewById(R.id.ivContactImage);
            ivContactImage.setImageURI(currentContacts.get_imaggeURI());

            return view;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

/*

    EditText txtName;
    EditText txtEmail;
    EditText txtPhone;
    EditText txtAddress;
    RadioButton radioWhatsapp;
    RadioButton radioGmail;
    RadioButton radioFacebook;
    RadioButton radioInstagram;
    CheckBox checkVIP;
    CheckBox checkContacts;
    Button buttonBack;
    Button buttonSend;
    Button buttonNext;
    Button buttonMoreInfo;
    String Name, Email, Phone, Address;

    */
/**
 * Called when the activity is first created.
 *//*

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
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);


        OnClickListener oclbuttonSend = new OnClickListener() {
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

    }
*/

}