/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopplatform.keyboard;

import applicationapi.input.keyboard.Keyboard;
import applicationapi.input.keyboard.KeyboardListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tog
 */
public class KeyboardImpl implements KeyListener, Keyboard
{

    private final List<KeyboardListener> listeners;
    private final List<KeyEventImpl> eventlist;
    private long startTime;

    public KeyboardImpl()
    {
        this.startTime = 0;
        this.eventlist = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //Do nothing for now...
    }

    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        eventlist.add(new KeyEventImpl(e.getWhen() - startTime, e, true));
    }

    @Override
    public synchronized void keyReleased(KeyEvent e)
    {
        eventlist.add(new KeyEventImpl(e.getWhen() - startTime, e, false));
    }

    public synchronized void playback()
    {
        for (KeyboardListener kl : listeners)
        {
            for (KeyEventImpl event : eventlist)
            {
                if (event.pressed())
                {

                    kl.onKeyPress(event);

                } else
                {

                    kl.onKeyRelease(event);

                }
            }

        }
        eventlist.clear();
    }
    
    public synchronized void start(long startTime)
    {
        this.startTime = startTime;
        eventlist.clear();
    }

    @Override
    public void addKeyboardListener(KeyboardListener keyListener)
    {
        listeners.add(keyListener);
    }

    @Override
    public void removeKeyboardListener(KeyboardListener keyListener)
    {
        listeners.remove(keyListener);
    }

}
