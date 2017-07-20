package com.a.quarter.model.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 作者：李亚雷
 * 时间：2017/7/3
 * 类用途：
 * 思路：
 */

public class DownAPKUtils {


    public static void downFile(final boolean force, final Context context, final String url, final String filename) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("提醒");
        builder.setMessage("有新版本，请更新");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            ProgressDialog progressDialog;

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (force) {
                    progressDialog = ProgressDialog.show(context, "", "正在更新，请稍候", false, false);
                } else {
                    progressDialog = new ProgressDialog(context);
                }

                progressDialog.setMessage("正在更新，请稍等");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(false);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                startAsyntask(context, progressDialog, url, filename);

            }


        });

        if (!force) {

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    builder.create().dismiss();
                }
            });
        }
        builder.setCancelable(false);
        builder.show();

    }


    //启动Asyntask的方法
    private static void startAsyntask(final Context context, final ProgressDialog progressDialog, String url, final String filename) {

        new AsyncTask<String, Integer, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                Integer value = values[0];
                Log.e("onProgressUpdate: ", value + "--dd");
                progressDialog.setMax(100);
                progressDialog.setProgress(values[0]);
                if (values[0] == 100) {
                    Toast.makeText(context, "下载完成", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();


                    if (Build.VERSION.SDK_INT < 23) {
                        Intent intents = new Intent();
                        intents.setAction("android.intent.action.VIEW");
                        intents.addCategory("android.intent.category.DEFAULT");
                        intents.setType("application/vnd.android.package-archive");
                        intents.setData(Uri.fromFile(new File("/sdcard/" + filename)));
                        intents.setDataAndType(Uri.fromFile(new File("/sdcard/" + filename)), "application/vnd.android.package-archive");
                        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intents);
                    } else {
                        File file = new File("/sdcard/" + filename);
                        if (file.exists()) {
                            openFile(file, context);
                        }
                    }


//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setDataAndType(Uri.fromFile(new File("/sdcard/" + filename)), "application/vnd.android.package-archive");
//                    context.startActivity(intent);
                }
            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);

                System.out.println(string);

            }

            @Override
            protected String doInBackground(String... params) {

                String param = params[0];

                try {
                    URL url = new URL(param);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();


                    if (connection.getResponseCode() != 200) {

                        return "链接错误";
                    }


                    //获得内容长度
                    int contentLength = connection.getContentLength();

                    InputStream inputStream = connection.getInputStream();

                    File file = new File("/sdcard/" + filename);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }


                    FileOutputStream fileOutputStream = new FileOutputStream(file);

                    Log.e("doInBackground: ", "qqqqq");

                    byte[] buffer = new byte[1024];
                    int len = 0;
                    int total = 0;


                    while ((len = inputStream.read(buffer)) != -1) {

                        if (isCancelled()) {

                            inputStream.close();
                            Log.e("doInBackground: ", "ooooooo");
                        } else {

                            total += len;
                            publishProgress((total * 100 / contentLength));
                            fileOutputStream.write(buffer, 0, len);
                            Log.e("doInBackground: ", "wwwwwww");
                        }

                    }


                    return null;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

        }.execute(url);




    }


    public static void openFile(File file, Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        String type = getMIMEType(file);
        intent.setDataAndType(Uri.fromFile(file), type);
        try {
            context.startActivity(intent);
        } catch (Exception var5) {
            var5.printStackTrace();
            Toast.makeText(context, "没有找到打开此类文件的程序", Toast.LENGTH_SHORT).show();
        }

    }


    public static String getMIMEType(File var0) {
        String var1 = "";
        String var2 = var0.getName();
        String var3 = var2.substring(var2.lastIndexOf(".") + 1, var2.length()).toLowerCase();
        var1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
        return var1;
    }
}
