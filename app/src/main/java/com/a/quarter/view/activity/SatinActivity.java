package com.a.quarter.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.SatinPresenter;

import java.io.File;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/26
 * 类用途：接口没有写，要在适配器中给每一个id赋予值。
 * 思路：
 */

public class SatinActivity extends BaseActivity<SatinPresenter> implements View.OnClickListener {

    private TextView over;
    private TextView paa;
    private TextView publish;
    private EditText editText;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    //打开相册需要的
    public static final int CHOOSE_PHOTO = 2;
    public static final int TAKE_PHOTO = 1;
    private PopupWindow popupWindow;
    private Uri imageUri;

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_satin;
    }

    @Override
    protected void initView() {

        over = (TextView) findViewById(R.id.over);
        paa = (TextView) findViewById(R.id.paa);
        publish = (TextView) findViewById(R.id.publish);

        editText = (EditText) findViewById(R.id.edit_edit);

        imageView1 = (ImageView) findViewById(R.id.add_pic1);
        imageView2 = (ImageView) findViewById(R.id.add_pic2);
        imageView3 = (ImageView) findViewById(R.id.add_pic3);

        over.setOnClickListener(this);
        publish.setOnClickListener(this);
        editText.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            //点击取消时，弹出一个pop询问是否保存，如果不是的话，就直接结束
            case R.id.over:
                createAlertDialog();
                break;

            //判断一下，如果发表成功，跳转到另一个页面，没有成功的话，吐司
            case R.id.publish:
//                if(){
//
//                }else {
//
//                }

                Intent intent = new Intent(context(),SuccessActivity.class);
                startActivity(intent);

                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                break;

            //添加图片
            case R.id.add_pic1:
                createPopUpWindow();
                Toast.makeText(this, "跳转到相册页面", Toast.LENGTH_SHORT).show();
                break;
            //添加图片
            case R.id.add_pic2:
                createPopUpWindow();
                Toast.makeText(this, "跳转到相册页面", Toast.LENGTH_SHORT).show();
                break;
            //添加图片
            case R.id.add_pic3:
                createPopUpWindow();
                Toast.makeText(this, "跳转到相册页面", Toast.LENGTH_SHORT).show();
                break;


        }


    }

    //点击下面的存放图片按钮，提示，是选择相册还是照相
    public void createPopUpWindow() {

        View view = View.inflate(SatinActivity.this, R.layout.pop_satin, null);
//这个layout，是整个页面的父layout
        View parent = View.inflate(SatinActivity.this, R.layout.activity_satin, null);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, false);

        //4......此时点击窗体外面的区域没有反应 点击返回键直接退出应用 --->进行以下设置
        popupWindow.setOutsideTouchable(true);//设置周围区域可以触摸
        //   popupWindow.setBackgroundDrawable(new BitmapDrawable());//设置背景
        popupWindow.setFocusable(true);//窗体默认没有焦点 设置成true


        //5...对窗体里面的控件进行操作
        TextView open_camera = (TextView) view.findViewById(R.id.open_camera);
        TextView open_album = (TextView) view.findViewById(R.id.open_album);
        TextView cancel = (TextView) view.findViewById(R.id.cancel);


        //打开相机的textview
        open_camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //创建file对象，用于存储拍照后的图片；
                File outputImage = new File(getExternalCacheDir(), "output_image.jpg");

                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(SatinActivity.this,
                            "com.gyq.cameraalbumtest.fileprovider", outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }

                //启动相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);

            }
        });

        /**
         * 貌似写好了
         */
        //打开相册的textview
        open_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(SatinActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SatinActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    openAlbum();
                }

            }
        });


        //取消的textview
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


        //半透明窗体 点击没有控件的部分 消失 需要设置点击事件
//        popupWindow.setAnimationStyle(R.style.anim_translate);
        popupWindow.showAtLocation(parent, Gravity.CENTER, 1, 1);


    }


    //打开相册
    private void openAlbum() {

        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_PHOTO);

    }


    // 点击取消 popupwindow询问是否保存
    public void createAlertDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context());

        builder.setTitle("提示");
        builder.setMessage("是否保存到草稿箱？");

        //点击取消，结束这个页面
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SatinActivity.this, "ddddddddddddddd", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, "you denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        imageView1.setImageBitmap(bm);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {  //4.4及以上的系统使用这个方法处理图片；
                        handleImageOnKitKat(data);
                    } else {
                        handleImageBeforeKitKat(data);  //4.4及以下的系统使用这个方法处理图片
                    }
                }
            default:
                break;
        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }


    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            imageView1.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 4.4及以上的系统使用这个方法处理图片
     *
     * @param data
     */
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果document类型的Uri,则通过document来处理
            String docID = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docID.split(":")[1];     //解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;

                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/piblic_downloads"), Long.valueOf(docID));

                imagePath = getImagePath(contentUri, null);

            }

        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的uri，则使用普通方式使用
            imagePath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是file类型的uri，直接获取路径即可
            imagePath = uri.getPath();

        }

        displayImage(imagePath);
    }



}
