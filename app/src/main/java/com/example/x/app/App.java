package com.example.x.app;

import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qy.channel.app.ChannelApplication;

import java.io.File;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:36:58
 * @Description:
 */
public class App  extends ChannelApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        String path = Environment.getExternalStorageDirectory().getPath() + "/RiKao14";
        File file = new File(path);
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(200,200)
                .memoryCacheSize(2*1024*1024)
                .threadPoolSize(3)
                .threadPriority(1000)
                .diskCache(new UnlimitedDiskCache(file))
                .diskCacheFileCount(50)
                .diskCacheSize(50*1024*1024)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
               .build();
        ImageLoader.getInstance().init(configuration);

    }
}
