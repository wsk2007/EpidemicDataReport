package org.wsk.EpidemicDataReport;
import org.wsk.API.Timer.*;

/**
 * @author wsk
 * 主方法
 */
public class Main {
    public static void main(String[] args) {
        EpidemicData d = new EpidemicData();
        ReportTask t = new ReportTask();
        Executor<ReportTask , EpidemicData> e = new Executor<ReportTask , EpidemicData>(d , t , 5000 , 1000);
        Time tim = new Time(8 , 30 , 0);
        Time tie = new Time(20 , 30 , 0);
        e.addschedule(tim);
        e.addschedule(tie);
        e.execute();
    }
}