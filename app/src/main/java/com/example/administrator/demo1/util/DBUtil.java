package com.example.administrator.demo1.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.DatabaseHelper;
import com.example.administrator.demo1.model.entity.Comment;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.model.entity.User;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/12/21.
 */

//可以用反射、泛型改进,大段的赋值操作晚点抽象封装下
public class DBUtil{

    public static DatabaseHelper dbHelper;

    public static final String TAG = "DBUtil";

    public static void initDBHelper(Context context){
        //创建数据库这一段可以用获取安装路径下，是否存在db文件来决定是否创建。
        dbHelper = new DatabaseHelper(context, "demo1.db", null, 1);
        //创建数据库
        dbHelper.getWritableDatabase();
        //如何保证我不会每次启动都插入新的数据呢？
//        initData();
//        batchInsertData();
        long startTime=System.currentTimeMillis();   //获取开始时间
        Log.d(TAG, "initDBHelper: " + countRecords());
        long endTime=System.currentTimeMillis();   //获取结束时间
        Log.d(TAG, "initDBHelper: time = " + (endTime - startTime));
    }

    public static int countRecords(){
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("select count(*) from Photo where isRead = 'false'", null);
        cursor.moveToFirst();
        int i = cursor.getInt(0);
        Log.d(TAG, "countRecords: " + i);
        return i;
    }


    public static boolean insert(Object object){
        try{
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            ContentValues values = initInsertUpdateValue(object);
            String tableName = object.getClass().getSimpleName();
            database.insert(tableName, null, values);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateById(Object object, int id){
        try{
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            ContentValues values = initInsertUpdateValue(object);
            String tableName = object.getClass().getSimpleName();
            database.update(tableName, values, "id = ?", new String[]{String.valueOf(id)});
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static ContentValues initInsertUpdateValue(Object object){
        ContentValues values = new ContentValues();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0; i < fields.length-2; i++){
            if(fields[i].getName().equals("id")){
                continue;
            }
            contentValuesPut(values, fields[i].getName(), object, fields[i].getType());
        }
        return values;
    }

    public static boolean deleteById(String tableName, int id){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(tableName, "id = ?", new String[]{String.valueOf(id)});
        return false;
    }

    //只传限制条件
    public static <T> List<T> queryT(Class<T> clazz, String whereClause, String... args){
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(clazz.getSimpleName(), null, whereClause, args,
                null, null, null);
        List<T> list = new ArrayList<>();
        //获取全部属性
        Field[] fields = clazz.getDeclaredFields();
        try{
            if(cursor.moveToFirst()){
                do{
                    T t  = clazz.newInstance();
                    for(int i = 0; i < fields.length-2; i++){
                        setter(t, upperFirstLetter(fields[i].getName()),
                                cursorGet(cursor, fields[i], fields[i].getType()),
                                fields[i].getType());
                    }
                    list.add(t);
                }while (cursor.moveToNext());
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
        return list;
    }


    public static void setter(Object object, String attr, Object value, Class type){
        try{
            Method method = object.getClass().getMethod("set" + attr, type);
            method.invoke(object, value);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String upperFirstLetter(String attr){
        return attr.substring(0,1).toUpperCase() + attr.substring(1);
    }


    //危险方法
    private static <T> T cursorGet(Cursor cursor, Field field, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if(clazz.equals(String.class)){
            return (T)cursor.getString(cursor.getColumnIndex(field.getName()));
        }else if(clazz.equals(Date.class)){
            return (T)DateFormatUtil.transFormat(cursor.getString(cursor.getColumnIndex(field.getName())));
        }else if(clazz.equals(Integer.class)){
            int temp = cursor.getInt(cursor.getColumnIndex(field.getName()));
            return (T)Integer.valueOf(temp);
        }else if(clazz.equals(Boolean.class)){
            String temp = cursor.getString(cursor.getColumnIndex(field.getName()));
            return (T)Boolean.valueOf(temp);
        }
        return clazz.newInstance();
    }

    //初始化数据
    public static void initData(){
        //photo
        List<Photo> photoList = createPhoto();
        for(Photo photo : photoList){
            insert(photo);
        }
        //user,先押后
        //comment，先押后
    }


    public static List<News> createNews(){
        List<News> newsList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            News news1 = new News("what is apple?", getRandomContent("what is apple"),
                    "apple", new Date(), 300, 30);
            newsList.add(news1);
            News news2 = new News("what is banana?", getRandomContent("what is banana"),
                    "banana", new Date(), 300, 30);
            newsList.add(news2);
            News news3 = new News("what is orange?", getRandomContent("what is orange"),
                    "orange", new Date(), 300, 30);
            newsList.add(news3);
            News news4 = new News("what is pear?", getRandomContent("what is pear"),
                    "pear", new Date(), 300, 30);
            newsList.add(news4);
            News news5 = new News("what is pineapple?", getRandomContent("what is pineapple"),
                    "pineapple", new Date(), 300, 30);
            newsList.add(news5);
            News news6 = new News("what is watermelon?", getRandomContent("what is watermelon"),
                    "watermelon", new Date(), 300, 30);
            newsList.add(news6);
        }
        return newsList;

    }

    public static List<Photo> createPhoto(){
        List<Photo> photoList = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            Photo photo1 = new Photo("apple", R.drawable.apple, false);
            Photo photo2 = new Photo("banana", R.drawable.banana, false);
            Photo photo3 = new Photo("orange", R.drawable.orange, false);
            Photo photo4 = new Photo("pear", R.drawable.pineapple, false);
            Photo photo5 = new Photo("pineapple", R.drawable.pear, false);
            Photo photo6 = new Photo("watermelon", R.drawable.watermelon, false);
            photoList.add(photo1);
            photoList.add(photo2);
            photoList.add(photo3);
            photoList.add(photo4);
            photoList.add(photo5);
            photoList.add(photo6);
        }
        return photoList;
    }


    public static String getRandomContent(String a){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int i = random.nextInt(100);
        for(int j = 0; j < i; j++){
            stringBuilder.append(a);
        }

        return stringBuilder.toString();
    }


    public static <T> void fastenLoadingPhoto(final PhotoFragment fragment, final List<Photo> photoList, final Class<T> clazz,
                                                  final String whereClause, final String... args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime=System.currentTimeMillis();   //获取开始时间
                SQLiteDatabase database = dbHelper.getReadableDatabase();
                Cursor cursor = database.query(clazz.getSimpleName(), null, whereClause, args,
                        null, null, null);
//                List<T> list = new ArrayList<>();
                //获取全部属性
                Field[] fields = clazz.getDeclaredFields();
                try{
                    if(cursor.moveToFirst()){
                        do{
                            T t  = clazz.newInstance();
                            for(int i = 0; i < fields.length-2; i++){
                                setter(t, upperFirstLetter(fields[i].getName()),
                                        cursorGet(cursor, fields[i], fields[i].getType()),
                                        fields[i].getType());
                            }
                            photoList.add((Photo) t);
                            if (photoList.size()% 1000 == 0){
                                fragment.showPartofResult(photoList.size());
                                break;
                            }
                        }while (cursor.moveToNext());
                    }
                    fragment.showPartofResult(photoList.size());
                    long endTime=System.currentTimeMillis();
                    Log.d(TAG, "run: time =" + (endTime - startTime));
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (InstantiationException e){
                    e.printStackTrace();
                }finally {
                    cursor.close();
                }
            }
        }).start();
    }

    public static void batchInsertData(){
        long startTime = System.currentTimeMillis();   //获取开始时间
        List<Photo> photoList = createPhoto();
        String sql = "insert into Photo(description, photoId, isRead) values(?,?,?)";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        for(Photo photo : photoList){
            statement.bindString(1, photo.getDescription());
            statement.bindLong(2, photo.getPhotoId());
            statement.bindString(3, photo.getIsRead().toString());
            statement.executeInsert();
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        long endTime=System.currentTimeMillis();   //获取结束时间
        Log.d(TAG, "batchInsertData: time = " + (endTime - startTime));
    }

    public static Object getter(Object object, String attr){
        try{
            Method method = object.getClass().getMethod("get" + attr);
            Object ans = method.invoke(object);
            return ans;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void contentValuesPut(ContentValues values, String key, Object object, Class clazz){
        if(clazz == int.class || clazz.equals(Integer.class)){
            values.put(key, (Integer) getter(object, upperFirstLetter(key)));
        }else if (clazz.equals(String.class)){
            values.put(key, (String)getter(object, upperFirstLetter(key)));
        }else if(clazz.equals(Boolean.class)){
            values.put(key, ((Boolean) getter(object, upperFirstLetter(key))).toString());
        }else if(clazz.equals(Date.class)){
            values.put(key, DateFormatUtil.dateFormat((Date)getter(object, upperFirstLetter(key))));
        }
    }
}
