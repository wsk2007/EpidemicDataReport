package org.wsk.EpidemicDataReport;

import org.wsk.API.Timer.Task;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/**
 * @suthor wsk
 * Task接口实现类
 */
public class ReportTask implements Task {
    @Override
    public void doTask(Object s) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = null;
        Toolkit tolkit = Toolkit.getDefaultToolkit();
        String msg = (String)s;
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        tText = new StringSelection(msg);
        clip.setContents(tText, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
