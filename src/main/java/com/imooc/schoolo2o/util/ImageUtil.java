package com.imooc.schoolo2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static String basePath;

    static {
        try {
            basePath = URLDecoder.decode(basePath1,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //private static String basePath = "C:/Users/clx/IdeaProjects/schoolo2o/target/classes/";
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
        /*用户上传的图片命名可能相同，所以用随机命名出不相同的名字*/
        String realFileName = getRandomFileName();
        /*获取拓展名*/
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        /*新的文件*/
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /*
    * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
    */
    public static String getRandomFileName() {
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /*获取输入文件流的扩展名*/
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /*创建目标路径所涉及到的目录，即/home/work/clx/xxx.jpg
    * 那么home work clx 这三个文件夹都需要自动创建
    */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        //String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("aaaa:" + Thread.currentThread().getContextClassLoader().getResource("").getPath());

        System.out.println("aaaa:" + basePath1);
        System.out.println("aaaa:" + basePath);
        System.out.println(basePath1.equals(Thread.currentThread().getContextClassLoader().getResource("").getPath()));;
        /*Thumbnails.of(new File("C:\\Users\\clx\\Desktop\\car.png")).size(200, 200)
                .watermark(Positions.BOTTOM_LEFT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f)
                .outputQuality(0.8f).toFile("C:\\Users\\clx\\Desktop\\carnew.png");*/
    }

    /*
    * storePath是文件路径还是目录路径,
    * 如果是文件路径则删除文件，
    * 如果是目录路径则删除该目录下所有文件
    */
    public static void deleteFileOrPath (String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

}
