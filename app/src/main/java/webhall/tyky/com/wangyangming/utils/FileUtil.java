
package webhall.tyky.com.wangyangming.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class FileUtil {

	public static void createFileWithByte(byte[] bytes,String filePath) {
		/**
		 * 创建File对象，其中包含文件所在的目录以及文件的命名
		 */
		File file = new File(filePath);
		// 创建FileOutputStream对象
		FileOutputStream outputStream = null;
		// 创建BufferedOutputStream对象
		BufferedOutputStream bufferedOutputStream = null;
		try {
			// 如果文件存在则删除
			if (file.exists()) {
				file.delete();
			}
			// 在文件系统中根据路径创建一个新的空文件
			file.createNewFile();
			// 获取FileOutputStream对象
			outputStream = new FileOutputStream(file);
			// 获取BufferedOutputStream对象
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			// 往文件所在的缓冲输出流中写byte数据
			bufferedOutputStream.write(bytes);
			// 刷出缓冲输出流，该步很关键，要是不执行flush()方法，那么文件的内容是空的。
			bufferedOutputStream.flush();
		} catch (Exception e) {
			// 打印异常信息
			e.printStackTrace();
		} finally {
			// 关闭创建的流对象
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedOutputStream != null) {
				try {
					bufferedOutputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public static void clearDir(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				if(f.exists()) {
					f.delete();
				}
			}
//			file.delete();//如要保留文件夹，只删除文件，请注释这行
		} else if (file.exists()) {
			file.delete();
		}
	}
	// private final static String TAG="FileHandler";
	// private final static String
	// PATH="/data/data/"+AppConfig.PACKAGE_NAME+"/files/";

	public static boolean DownloadImage(Context context, String Url,
										String FileName) {

		URL imageurl;
		int Read;

		try {
			File file = new File(context.getFilesDir().getAbsolutePath() + "/"
					+ FileName);
			if (!file.exists()) {
				imageurl = new URL(Url);

				HttpURLConnection conn = (HttpURLConnection) imageurl
						.openConnection();

				int len = conn.getContentLength();
				byte[] raster = new byte[len];

				InputStream is = conn.getInputStream();
				FileOutputStream fos = context.openFileOutput(FileName, 0);

				for (;;) {
					Read = is.read(raster);
					if (Read <= 0) {
						break;
					}
					fos.write(raster, 0, Read);
				}

				is.close();
				fos.close();
				conn.disconnect();
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public static void saveDownloadFile(InputStream inputStream, File file) {
		FileOutputStream fos = null;
		if (inputStream != null) {
			try {
				fos = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int slice;
				while ((slice = inputStream.read(buf)) != -1) {
					fos.write(buf, 0, slice);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
					if (fos != null) {
						fos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Bitmap getBitmap(Context context, String FileName) {

		Bitmap bitmap = null;

		try {
			bitmap = BitmapFactory.decodeFile(context.getFilesDir()
					.getAbsolutePath() + "/" + FileName);
		} catch (Exception e) {
		}

		return bitmap;
	}
	
	public static Bitmap getBitmapByPath(Context context, String PathName) {

		Bitmap bitmap = null;

		try {
			bitmap = BitmapFactory.decodeFile(PathName);
		} catch (Exception e) {
		}

		return bitmap;
	}

	public static int Write(Context context, String filename, String data) {
		try {
			FileOutputStream fos = context.openFileOutput(filename,
					Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
		} catch (Exception e) {
			return 0;
		}

		return 1;
	}

	public static String Load(Context context, String filename) {
		String szresult = "";

		try {
			FileInputStream fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			szresult = (String) ois.readObject();
			ois.close();
		} catch (Exception e) {
		}

		return szresult;
	}
	public static double LoadInt(Context context, String filename) {
		String szresult = "";

		try {
			FileInputStream fis = context.openFileInput(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			szresult = (String) ois.readObject();
			ois.close();
			if(null==szresult||szresult.equals("")){
				szresult = 0+"";
			}
		} catch (Exception e) {
			szresult = 0+"";
		}

		return Double.parseDouble(szresult.trim());
	}

	public static long getFileSize(Context context, String FileName) {

		File file = new File(context.getFilesDir().getAbsolutePath() + "/"
				+ FileName);

		try {
			if (file.exists()) {
				return file.length();
			}
		} catch (Exception e) {
		}

		return 0;

	}

	public static String getFromAssets(Context context, String fileName) throws IOException {

		InputStreamReader inputReader = new InputStreamReader(context
				.getResources().getAssets().open(fileName));
		BufferedReader bufReader = new BufferedReader(inputReader);
		String line = "";
		String Result = "";
		while ((line = bufReader.readLine()) != null) {
			Result += line;
		}
		return Result;

	}

	public static boolean FileDelete(Context context, String FileName) {
		File file = new File(context.getFilesDir().getAbsolutePath() + "/"
				+ FileName);

		try {
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public void saveToSDCard(String name, String content) {

		 FileOutputStream fos = null;
		 
		try{
			
			//Environment.getExternalStorageDirectory()。获取sd卡的路径
		File file = new File(Environment.getExternalStorageDirectory(),name);
	    fos = new FileOutputStream(file);
	    
	    fos.write(content.getBytes());
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Bitmap returnBitMap(String url) {
		URL myFileUrl = null;
		Bitmap bitmap = null;
		try {
			myFileUrl = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
			conn.setRequestProperty("Accept-Encoding", "identity");
//			conn.setRequestProperty(field, newValue);
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength();
			System.out.println("--------------length--------------" + length);
			InputStream is = conn.getInputStream();
			// bitmap = BitmapFactory.decodeStream(is);
			Options options = new Options();
			options.inDither = false; /* 不进行图片抖动处理 */
			options.inPreferredConfig = null; /* 设置让解码器以最佳方式解码 */
			options.inSampleSize = 4; /* 图片长宽方向缩小倍数 */
			bitmap = BitmapFactory.decodeStream(is, null, options);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}


	/**
	 * 打开文件
	 * @param filePath
	 * @return
	 */
	public static Intent openFile(String filePath){

		File file = new File(filePath);
		if(!file.exists()) return null;
		/* 取得扩展名 */
		String end=file.getName().substring(file.getName().lastIndexOf(".") + 1,file.getName().length()).toLowerCase();
		/* 依扩展名的类型决定MimeType */
		if(end.equals("m4a")||end.equals("mp3")||end.equals("mid")||
				end.equals("xmf")||end.equals("ogg")||end.equals("wav")){
			return getAudioFileIntent(filePath);
		}else if(end.equals("3gp")||end.equals("mp4")){
			return getAudioFileIntent(filePath);
		}else if(end.equals("jpg")||end.equals("gif")||end.equals("png")||
				end.equals("jpeg")||end.equals("bmp")){
			return getImageFileIntent(filePath);
		}else if(end.equals("apk")){
			return getApkFileIntent(filePath);
		}else if(end.equals("ppt")){
			return getPptFileIntent(filePath);
		}else if(end.equals("xls")){
			return getExcelFileIntent(filePath);
		}else if(end.equals("doc")){
			return getWordFileIntent(filePath);
		}else if(end.equals("pdf")){
			return getPdfFileIntent(filePath);
		}else if(end.equals("chm")){
			return getChmFileIntent(filePath);
		}else if(end.equals("txt")){
			return getTextFileIntent(filePath,false);
		}else{
			return getAllIntent(filePath);
		}
	}

	//Android获取一个用于打开APK文件的intent
	public static Intent getAllIntent(String param ) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri,"*/*");
		return intent;
	}
	//Android获取一个用于打开APK文件的intent
	public static Intent getApkFileIntent(String param ) {

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri,"application/vnd.android.package-archive"); 
		return intent;
	}

	//Android获取一个用于打开VIDEO文件的intent
	public static Intent getVideoFileIntent(String param ) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "video/*");
		return intent;
	}

	//Android获取一个用于打开AUDIO文件的intent
	public static Intent getAudioFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("oneshot", 0);
		intent.putExtra("configchange", 0);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "audio/*");
		return intent;
	}

	//Android获取一个用于打开Html文件的intent   
	public static Intent getHtmlFileIntent(String param ){

		Uri uri = Uri.parse(param ).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(param ).build();
		Intent intent = new Intent("android.intent.action.VIEW");
		intent.setDataAndType(uri, "text/html");
		return intent;
	}

	//Android获取一个用于打开图片文件的intent
	public static Intent getImageFileIntent(String param ) {

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "image/*");
		return intent;
	}

	//Android获取一个用于打开PPT文件的intent   
	public static Intent getPptFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "application/vnd.ms-powerpoint");   
		return intent;   
	}   

	//Android获取一个用于打开Excel文件的intent   
	public static Intent getExcelFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "application/vnd.ms-excel");   
		return intent;   
	}   

	//Android获取一个用于打开Word文件的intent   
	public static Intent getWordFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "application/msword");   
		return intent;   
	}   

	//Android获取一个用于打开CHM文件的intent   
	public static Intent getChmFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "application/x-chm");   
		return intent;   
	}   

	//Android获取一个用于打开文本文件的intent   
	public static Intent getTextFileIntent(String param, boolean paramBoolean){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (paramBoolean){   
			Uri uri1 = Uri.parse(param );
			intent.setDataAndType(uri1, "text/plain");   
		}else{   
			Uri uri2 = Uri.fromFile(new File(param ));
			intent.setDataAndType(uri2, "text/plain");   
		}   
		return intent;   
	}  
	//Android获取一个用于打开PDF文件的intent   
	public static Intent getPdfFileIntent(String param ){

		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");   
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(new File(param ));
		intent.setDataAndType(uri, "application/pdf");   
		return intent;   
	}

	/**
	 * 复制文件
	 *
	 * @param srcPath
	 *            源文件绝对路径
	 */
	public static boolean copyFile(String srcPath, String destDir)
	{
		boolean flag = false;
		File srcFile = new File(srcPath); // 源文件
		if (!srcFile.exists()) {
			return false;
		}
		try
		{
			FileInputStream fis = new FileInputStream(srcPath);
			FileOutputStream fos = new FileOutputStream(destDir);
			byte[] buf = new byte[1024];
			int c;
			while ((c = fis.read(buf)) != -1)
			{
				fos.write(buf, 0, c);
			}
			fis.close();
			fos.close();

			flag = true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return flag;
	}


}

