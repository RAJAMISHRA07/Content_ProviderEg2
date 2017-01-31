package com.example.admin.content_providereg2;

import android.net.Uri;

/**
 * Created by Admin on 2/1/2017.
 */
public class UriProvider {
    public static final String _ID="_id";//integer
    public static final String Name="sname";//string
    public static final String Sub="ssub";//string
    //prepare uri for student information table

    public static final Uri STUDENT_URI =
            Uri.parse("content://com.techpalle.android/studenttable");
}
