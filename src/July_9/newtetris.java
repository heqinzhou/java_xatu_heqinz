package July_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: newtetris
 * @date: 2020/7/9 10:47 周四
 * @author: heqinz
 */
public class newtetris extends JFrame implements ActionListener//游戏界面类
{
    TheGame game;//定义一个游戏对象
    public static JPanel menu;//定义静态菜单面板
    Label prompt1, prompt2, prompt3;
    public static TextField score;//计分文本框
    TextArea methon;//玩法介绍文本区
    JButton start, replay;//开始，暂停按钮


    newtetris() {
        game = new TheGame();
        menu = new JPanel();

        Font se = new Font("宋体", Font.BOLD, 25);
        prompt1 = new Label("             NEXT:");
        prompt2 = new Label("               Score:");
        prompt3 = new Label("               Help:");
        prompt1.setFont(se);
        prompt2.setFont(se);
        prompt3.setFont(se);

        score = new TextField(3);
        methon = new TextArea("" + 10, 8, TextArea.SCROLLBARS_NONE);
        start = new JButton("开始");
        replay = new JButton("暂停");

        menu.setLayout(new GridLayout(0, 2, 10, 30));//菜单面板使用网格布局

        Font sc = new Font("宋体", Font.BOLD, 15);
        Font sp = new Font("宋体", Font.BOLD, 100);
        methon.setFont(sc);
        methon.setText("↑:顺时针旋转90度\n↓:快速下移\n←:向左移动\n→:向右移动");
        methon.setEditable(false);
        methon.setFocusable(false);
        score.setFont(sp);
        score.setText("0");
        score.setEditable(false);
        score.setFocusable(false);

        menu.setPreferredSize(new Dimension(400, 600));
        menu.add(prompt1);
        menu.add(new Nextb());
        menu.add(prompt2);
        menu.add(score);
        menu.add(prompt3);
        menu.add(methon);
        menu.add(start);
        menu.add(replay);

        this.add(menu, BorderLayout.EAST);
        this.add(game, BorderLayout.CENTER);

        start.addActionListener(this);
        replay.addActionListener(this);

        this.setVisible(true);
        this.setSize(750, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("俄罗斯方块");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            game.Start();//开始游戏
            game.requestFocusInWindow();//聚焦到游戏面板
        } else if (e.getSource() == replay) {
            if (e.getActionCommand().equals("暂停")) {
                game.setcontinue(false);//设置游戏暂停
                replay.setText("继续");//按钮变成继续
                game.requestFocusInWindow();//聚焦到面板
            } else if (e.getActionCommand().equals("继续")) {
                game.setcontinue(true);//设置游戏继续
                replay.setText("暂停");//按钮变成暂停
                game.requestFocusInWindow();//聚焦到面板
            }
        }

    }

}
