/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopplatform;

import applicationapi.Application;
import applicationapi.Device;
import applicationapi.Platform;
import applicationapi.graphics.Screen;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 *
 * @author tog
 */
public class DesktopPlatformImpl implements Platform, KeyListener
{

    @Override
    public void runApplication(Application app)
    {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        GraphicsConfiguration gc = device.getDefaultConfiguration();
        Frame frame = new Frame(gc);    
        try
        {
            frame.addKeyListener(this);
            frame.setUndecorated(true);
            frame.setIgnoreRepaint(true);
            device.setFullScreenWindow(frame);
            Rectangle bounds = frame.getBounds();
            frame.createBufferStrategy(2);
            BufferStrategy strategy = frame.getBufferStrategy();
            Screen scr = new ScreenImpl(bounds.width, bounds.height, new SpriteFactoryImpl(gc));
            Device dev = new DeviceImpl(scr, null);
            app.initialize(dev);
            long startTime = System.nanoTime();
            boolean running = app.update(0);
            float fps = 0;
            int frameCount = 0;
            //Render loop
            while (running)
            {
                Graphics g = strategy.getDrawGraphics();
                if (!strategy.contentsLost())
                {
                    //Clear
                    g.setColor(java.awt.Color.WHITE);
                    g.fillRect(0, 0, bounds.width, bounds.height);
                    //Draw app
                    CanvasImpl canvas = new CanvasImpl(g);
                    app.draw(canvas);
                    //Draw statistics
                    g.setColor(java.awt.Color.BLACK);
                    g.drawString("FPS: " + fps, 10, bounds.height-10);
                    //Show
                    strategy.show();
                    g.dispose();
                    ++frameCount;
                    long time = (System.nanoTime() - startTime) / 1000000;
                    fps = ((float) frameCount*1000) / ((float) time);
                    running = app.update(time);
                }
            }

            app.destroy();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            device.setFullScreenWindow(null);
            frame.dispose();
        }

    }


    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("Key pressed: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("Key released: " + e.getKeyCode());
    }
}
