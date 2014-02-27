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
import desktopplatform.input.EventHandlerImpl;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.MemoryImageSource;

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
            
            //Mac hack begin (to make keyboard input work)
            frame.setVisible(false);
            frame.setVisible(true);
            //Mac hack end
            
            
            //Make cursor invisible
            int[] pixels = new int[16 * 16];
            Image image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16, pixels, 0, 16));
            Cursor transparentCursor
                = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
            frame.setCursor(transparentCursor);
            
            //Create input event handler
            EventHandlerImpl eventHandler = new EventHandlerImpl();
            Toolkit.getDefaultToolkit().addAWTEventListener(eventHandler, eventHandler.getMask());
            
            
            Rectangle bounds = frame.getBounds();
            frame.createBufferStrategy(2);
            BufferStrategy strategy = frame.getBufferStrategy();
         
            Screen scr = new ScreenImpl(bounds.width, bounds.height, new SpriteFactoryImpl(gc));
            Device dev = new DeviceImpl(scr, eventHandler, eventHandler);
            if(!app.initialize(dev)) return;
            long startTimeMillis = System.currentTimeMillis();
            boolean running = app.update(0);
            eventHandler.start(startTimeMillis);
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
                    Toolkit.getDefaultToolkit().sync();
                    g.dispose();
                    Thread.sleep(2);
                    ++frameCount;  
                    
                    //Get time
                    long time = (System.currentTimeMillis() - startTimeMillis);
                    fps = ((float) frameCount*1000) / ((float) time);
                    
                    
                    
                    
                    //Dispatch input events
                    if(eventHandler.dispatch()) break;
                    
                    //Update application
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
            frame.setVisible(false);
            frame.dispose();
        }

    }
    
}