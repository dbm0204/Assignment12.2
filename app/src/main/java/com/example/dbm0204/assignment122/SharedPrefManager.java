package com.example.dbm0204.assignment122;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dbm0204 on 6/24/17.
 */

public class SharedPrefManager  {

    public static final String MY_EMP_PREFS="MySharedPref";
    private static Context mContext;
    private static String nName= "";
    private static String nPhone="";
    private static int    nAge= 0;
    public static void Init(Context context){
        mContext=context;
    }
    public static void LoadFromPref(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_EMP_PREFS,0);
        //The second parameter is the default parameter for private access
        nName =sharedPreferences.getString("Name","");
        nPhone=sharedPreferences.getString("Phone","");
        nAge=sharedPreferences.getInt("Age",0);
    }

    public static void StoreToPrefs() {
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(MY_EMP_PREFS,0);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("Name",nName);
        editor.putString("Phone",nPhone);
        editor.putInt   ("Age",nAge);
        editor.commit();
    }

    public static  void DeleteSingleEntryFromPref(String KeyName){
        SharedPreferences settings= mContext.getSharedPreferences(MY_EMP_PREFS,0);
        SharedPreferences.Editor editor =settings.edit();
        editor.clear();
        editor.commit();
    }
    public static void setnName(String name){
        nName=name;
    }
    public static void setnPhone(String Phone){
        nPhone=Phone;
    }
    public static void setnAge(int age){
        nAge=age;
    }
    public static String getnName()
    {
        return nName;
    }
    public static String getnPhone(){
        return nPhone;
    }
    public static int getnAge(){
        return nAge;
    }

}
