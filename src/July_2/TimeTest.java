package July_2;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * @PACKAGE_NAME: July_2
 * @NAME: TimeTest
 * @date: 2020/7/2 14:45 周四
 * @author: heqinz
 */

/*
核心教程6.2.1  接口与回调
 */
public class TimeTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit progarm");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
