package org.wsk.EpidemicDataReport;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

/**
 * @author wsk
 * 工具类
 */
public class Tool {
    public final static boolean DEBUG = true; // 调试用
    private static int BUFFER_SIZE = 10240; // 缓冲区大小(缓冲区越大下载的越快,但是要根据自己的服务器配置)
    private Vector vDownLoad = new Vector(); // URL列表
    private Vector vFileList = new Vector();


    public void saveToFile(String destUrl, String fileName) throws IOException {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;

        // 建立链接
        url = new URL(destUrl);
        httpUrl = (HttpURLConnection) url.openConnection();
        // 连接指定的资源

        httpUrl.connect();
        // 获取网络输入流
        bis = new BufferedInputStream(httpUrl.getInputStream());
        // 建立文件
        fos = new FileOutputStream(fileName);

        if (this.DEBUG) {
            System.out.println("正在获取链接[" + destUrl + "]的内容...\n将其保存为文件["
                    + fileName + "]");
        }

        // 保存文件
        while ((size = bis.read(buf)) != -1) {
            fos.write(buf, 0, size);
        }


        fos.close();
        bis.close();
        httpUrl.disconnect();
    }

    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));

            String s = null;



            while((s = reader.readLine()) != null){

                sb.append(s);

            }

        } catch (Exception e) {
            // TODO 自动生成的 catch 块



        }


        return sb.toString();
    }
}
