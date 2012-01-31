package org.wintrisstech;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This project is designed as a starting point for students learning about
 * arrays. <p> Images in this project are public domain from
 * http://openclipart.org
 *
 * @author aaron@wintrisstech.org (Aaron VonderHaar)
 * @author http://wintrisstech.org
 */
public class AppleTree extends JComponent implements MouseListener, ActionListener
{

    private Image tree;
    private Image background;
    private Image weather;
    private Image apple;
    private Image basket;
    private int[] applex = new int[10];
    private int[] appley = new int[10];
    private int applenumber = 0;
    private boolean[] applefalling = new boolean[10];
    
    private int weatherX = 530;

    public static void main(String[] args) throws IOException
    {
        JFrame window = new JFrame("Apple Tree");
        AppleTree game = new AppleTree();
        window.add(game);
        window.addMouseListener(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Timer t = new Timer(100, game);
        t.start();
    }

    public AppleTree() throws IOException
    {
        applex[0] = 150;
        appley[0] = 220;
        applex[1] = 220;
        appley[1] = 310;
        applex[2] = 410;
        appley[2] = 190;
        applex[3] = 200;
        appley[3] = 100;
        applex[4] = 300;
        appley[4] = 120;
        applex[5] = 400;
        appley[5] = 230;
        applex[6] = 100;
        appley[6] = 190;
        applex[7] = 450;
        appley[7] = 260;
        applex[8] = 400;
        appley[8] = 120;
        applex[9] = 300;
        appley[9] = 200;
        tree = ImageIO.read(getClass().getResource("PeterM_Tree.png"));
        background = ImageIO.read(getClass().getResource("ryanlerch_grassy_horizon_(gradient).png"));
        weather = ImageIO.read(getClass().getResource("Weather.png"));
        apple = ImageIO.read(getClass().getResource("johnny_automatic_apple.png"));
        basket = ImageIO.read(getClass().getResource("johnny_automatic_5_8_bushel_basket.png"));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        
        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawImage(weather, weatherX, -50, 350, 437 * 350 / 800, null);
        g.drawImage(tree, 40, 30, 712 * 550 / 800, 550, null);
        g.drawImage(apple, 300, 300, 20, 20, null);
        for (int i = 0; i < 10; i++)
        {
            g.drawImage(apple, applex[i], appley[i], 20, 20, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        applefalling[applenumber] = true;
        applenumber++;
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        weatherX -= 1;
        for(int apples = 0; apples < 10; apples++)
        {
            if(appley[apples] < 550 && applefalling[apples] == true)
            {
                appley[apples] = appley[apples] + 8;
            }
        }
        repaint();
    }
}
