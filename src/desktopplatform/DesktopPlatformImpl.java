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
import desktopplatform.keyboard.KeyboardImpl;
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
public class DesktopPlatformImpl implements Platform
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
           
            frame.setUndecorated(true);
            frame.setIgnoreRepaint(true);
            device.setFullScreenWindow(frame);
            Rectangle bounds = frame.getBounds();
            frame.createBufferStrategy(2);
            BufferStrategy strategy = frame.getBufferStrategy();
            KeyboardImpl kb = new KeyboardImpl();
            frame.addKeyListener(kb);
            Screen scr = new ScreenImpl(bounds.width, bounds.height, new SpriteFactoryImpl(gc));
            Device dev = new DeviceImpl(scr, kb);
            app.initialize(dev);
            long startTimeMillis = System.currentTimeMillis();
            boolean running = app.update(0);
            kb.start(startTimeMillis);
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
                    
                    //Update
                    long time = (System.currentTimeMillis() - startTimeMillis);
                    fps = ((float) frameCount*1000) / ((float) time);
                    
                    //Input
                    kb.playback();
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
    
}