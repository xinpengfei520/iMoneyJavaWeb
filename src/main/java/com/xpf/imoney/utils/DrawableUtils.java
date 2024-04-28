package com.xpf.imoney.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Vance on 2019/9/29 :)
 * Function:
 */
public class DrawableUtils {

    /**
     * 图片清晰比率
     */
    private static final float JPEG_COMPRESSION_RATE = 0.75f;

    private static final String IMG_UPLOAD_PATH = "DrawableUtils";

    /**
     * @return : java.lang.String
     * @Description : 将二维码图片和文字生成到一张图片上
     * @Param : originalImg 原图
     * @Param : qrCodeImg 二维码地址
     * @Param : shareDesc 图片文字
     */
    public static String generateImg(String originalImg, String qrCodeImg, String shareDesc) throws Exception {
        // 加载原图图片
        BufferedImage imageLocal = ImageIO.read(new URL(originalImg));
        // 加载用户的二维码
        BufferedImage imageCode = ImageIO.read(new URL(qrCodeImg));
        // 以原图片为模板
        Graphics2D graphics = imageLocal.createGraphics();
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        graphics.setComposite(ac);
        graphics.setBackground(Color.WHITE);
        // 在模板上添加用户二维码(地址,左边距,上边距,图片宽度,图片高度,未知)
        graphics.drawImage(imageCode, 100, imageLocal.getHeight() - 190, 160, 158, null);
        // 设置文本样式
        graphics.setFont(new Font("微软雅黑", Font.PLAIN, 40));
        graphics.setColor(Color.red);
        // 计算文字长度，计算居中的x点坐标
        graphics.drawString(shareDesc, imageLocal.getWidth() - 330, imageLocal.getHeight() - 530);
        // 设置文本样式
        graphics.setFont(new Font("微软雅黑", Font.PLAIN + Font.BOLD, 16));
        graphics.setColor(Color.WHITE);
        // 计算文字长度，计算居中的x点坐标
        String tips = "长按二维码";
        graphics.drawString(tips, 105, imageLocal.getHeight() - 10);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        saveAsJPEG(imageLocal, out);
        out.close();
        //return urlImgDownInputStream(FileUtils.parse(out));
        return null;
    }

    /**
     * 以JPEG编码保存图片
     *
     * @param imageToSave 要处理的图像图片
     * @param fos         文件输出流
     * @throws IOException
     */
    private static void saveAsJPEG(BufferedImage imageToSave, ByteArrayOutputStream fos) throws IOException {
        ImageWriter imageWriter = ImageIO.getImageWritersBySuffix("jpg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
        imageWriter.setOutput(ios);
        if (JPEG_COMPRESSION_RATE >= 0 && JPEG_COMPRESSION_RATE <= 1f) {
            // new Compression
            JPEGImageWriteParam jpegParams = (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
            jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(JPEG_COMPRESSION_RATE);
        }
        // new Write and clean up
        ImageIO.setUseCache(false);
        imageWriter.write(new IIOImage(imageToSave, null, null));
        ios.close();
        imageWriter.dispose();
    }

    /**
     * 图片流远程上传
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    private static String urlImgDownInputStream(InputStream inStream) throws Exception {
        String md5 = MD5Utils.MD5(TimeUtils.getTimestamp());
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            ContentBody contentBody = new InputStreamBody(inStream, md5 + ".png");
            HttpEntity httpEntity = MultipartEntityBuilder.create()
                    .addPart("FileData", contentBody)
                    .build();

            // 文件服务器上传图片地址
            HttpPost post = new HttpPost(IMG_UPLOAD_PATH);
            post.setEntity(httpEntity);
            HttpResponse httpResponse = httpclient.execute(post);
            HttpEntity entity = httpResponse.getEntity();
            String jsonStr = EntityUtils.toString(entity);
            JSONObject ob = JSONObject.parseObject(jsonStr);
            if (!ob.isEmpty() && ob.containsKey("pic_id")) {
                return ob.getString("pic_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * test
     *
     * @param args
     * @throws
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始：" + startTime);
        try {
            String originalImg = "https://img.diyijuzi.com/uploadfile/2018/0821/1534855569614.jpg";
            String qrCodeImg = "https://img-blog.csdn.net/20180626144909992?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3hpbnBlbmdmZWk1MjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70";
            String shareDesc = "长按扫描二维码";
            String img = generateImg(originalImg, qrCodeImg, shareDesc);
            System.out.println("生成完毕,url=" + img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束：" + (System.currentTimeMillis() - startTime) / 1000);
    }
}
