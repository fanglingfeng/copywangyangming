package webhall.tyky.com.wangyangming.utils;

import android.content.Context;

import java.io.File;

import webhall.tyky.com.wangyangming.AppConfig;

public class FileCache {
    
    private File cacheDir;
    
    public FileCache(Context context){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir=new File(android.os.Environment.getExternalStorageDirectory(), AppConfig.CACHE_DIR);
        else
            cacheDir=context.getCacheDir();
        if(!cacheDir.exists())
            cacheDir.mkdirs();
    }
    
    public File getFile(String url){
        //I identify images by hashcode. Not a perfect solution, good for the demo.
        String filename= String.valueOf(url.hashCode());
        //Another possible solution (thanks to grantland)
        //String filename = URLEncoder.encode(url);
        File f = new File(cacheDir, filename);
        return f;
        
    }
    
    public void clear(){
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }
    
    /**
     * 根据文件名称获取文件
     * @param fileName 文件名称
     * @return 文件
     */
    public File getByFileName(String fileName){
        File f = new File(cacheDir, fileName);
        return f;
    }

}