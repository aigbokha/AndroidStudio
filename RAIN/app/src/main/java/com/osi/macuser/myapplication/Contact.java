package com.osi.macuser.myapplication;

import android.net.Uri;

import java.net.URI;

/**
 * Created by macuser on 12/4/14.
 */
public class Contact {


    private String _name, _email, _phone, _address;
    private Uri _imageURI;


    public Contact (String name, String email, String phone, String address, Uri imageURI) {

        _name = name;
        _email = email;
        _phone = phone;
        _address = address;
        _imageURI = imageURI;
    }


    public String getName(){

        return _name;
    }

    public String getEmail(){

        return _email;
    }

    public String getPhone(){

        return _phone;
    }

    public String getAddress(){

        return _address;
    }

    public Uri get_imaggeURI(){
        return _imageURI;
    }

}
