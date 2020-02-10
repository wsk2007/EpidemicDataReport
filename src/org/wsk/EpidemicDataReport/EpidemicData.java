package org.wsk.EpidemicDataReport;

import org.wsk.API.Timer.Data;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author wsk
 * Data接口实现类
 */
public class EpidemicData implements Data {
    @Override
    public Object getData() {
        Tool t = new Tool();
        StringBuilder sb = new StringBuilder();
        sb.append("大家好");
        sb.append("\r\n");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        sb.append("现在时间：" + c.getTime().toString());
        sb.append("\r\n");
        sb.append("疫情信息播报：");
        sb.append("\r\n");
        try {
            t.saveToFile("http://tianqiapi.com/api?version=epidemic&appid=87438614&appsecret=X8z2Mx1N" , "data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder pr = new StringBuilder();
        String str = t.readFile("data.json");

        pr.append(str);
        int difi = pr.indexOf("\"diagnosed\":") + 12;
        int dili = difi + 6;
        int sufi = pr.indexOf("\"suspect\":") + 10;
        int suli = sufi + 6;
        int dafi = pr.indexOf("\"date\":") + 8;
        int dali = dafi + 19;
        int cufi = pr.indexOf("\"cured\":") + 8;
        int culi = cufi + 5;
        int defi = pr.indexOf("\"death\":") + 8;
        int deli = defi + 4;
        char[] di = {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' '};
        pr.getChars(difi, dili, di, 1);
        char[] su = {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' '};
        pr.getChars(sufi, suli, su, 1);
        char[] da = {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' '};
        pr.getChars(dafi, dali, da, 1);
        char[] cu = {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' '};
        pr.getChars(cufi, culi, cu, 1);
        char[] de = {' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ' , ' ', ' ' , ' ', ' ' , ' ' , ' ', ' ' , ' '};
        pr.getChars(defi, deli, de, 1);
        sb.append("更新时间：");
        sb.append(da);
        sb.append("\r\n");

        sb.append("确诊人数：" );
        sb.append(di);
        sb.append("\r\n");

        sb.append("疑似人数：");
        sb.append( su);
        sb.append("\r\n");

        sb.append("死亡人数：");
        sb.append(de);
        sb.append("\r\n");

        sb.append("治愈人数：" );
        sb.append(cu);
        sb.append("\r\n");

        sb.append("温馨提示：");
        sb.append("\r\n");
        sb.append("少出门 戴口罩 勤洗手 不揉眼 多喝水 常通风 合理膳食 适度运动 保持良好心态");


        return sb.toString();


    }

    @Override
    public Object getStartData() {
        StringBuilder sb = new StringBuilder();
        sb.append("HOTFIX SUCCESS");
        sb.append("\r\n");
        sb.append("热修复成功！");
        sb.append("\r\n");
        sb.append("修复内容");
        sb.append("\r\n");
        sb.append("对数字类型添加一位缓冲来防止数量增长过快");
        sb.append("\r\n");
        sb.append("本服务采用WSKTimerAPI 作者：王晟凯");
        sb.append("\r\n");
        sb.append("本服务作者：王晟凯");
        return sb.toString();
    }
}
