/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input;

import applicationapi.input.InputEvent;
import applicationapi.input.keyboard.Key;
import applicationapi.input.keyboard.Keyboard;
import applicationapi.input.keyboard.KeyboardListener;
import applicationapi.input.mouse.Mouse;
import applicationapi.input.mouse.MouseButton;
import applicationapi.input.mouse.MouseListener;
import desktopplatform.input.keyboard.KeyMap;
import desktopplatform.input.keyboard.KeyPressedEventImpl;
import desktopplatform.input.keyboard.KeyReleasedEventImpl;
import desktopplatform.input.mouse.MouseButtonMap;
import desktopplatform.input.mouse.MouseMovedEventImpl;
import desktopplatform.input.mouse.MousePressedEventImpl;
import desktopplatform.input.mouse.MouseReleasedEventImpl;
import desktopplatform.input.mouse.MouseWheelEventImpl;
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tog
 */
public class EventHandlerImpl implements AWTEventListener, Keyboard, Mouse
{
    private final List<KeyboardListener> keyboardListeners;
    private final List<MouseListener> mouseListeners;
    private final List<InputEvent> inputEvents;
    private long startTime;
    private boolean quit;

    public EventHandlerImpl()
    {
        keyboardListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
        inputEvents = new ArrayList<>();
        this.startTime = 0;
        this.quit = false;
    }
    
    public long getMask()
    {
        return  AWTEvent.KEY_EVENT_MASK +
                AWTEvent.MOUSE_EVENT_MASK +
                AWTEvent.MOUSE_MOTION_EVENT_MASK +
                AWTEvent.MOUSE_WHEEL_EVENT_MASK;
    }
    
    public synchronized void start(long startTime)
    {
        this.startTime = startTime;
        inputEvents.clear();
    }
    
    public synchronized boolean dispatch()
    {
        for(InputEvent e : inputEvents)
        {
            switch(e.getType())
            {
                case KEY_PRESSED_EVENT:
                    for(KeyboardListener l : keyboardListeners)
                    {
                        l.onKeyPressed(e.asKeyPressedEvent());
                    }
                    break;
                case KEY_RELEASED_EVENT:
                    for(KeyboardListener l : keyboardListeners)
                    {
                        l.onKeyReleased(e.asKeyReleasedEvent());
                    }
                    break;
                case MOUSE_PRESSED_EVENT:
                    for(MouseListener l : mouseListeners)
                    {
                        l.onMousePressed(e.asMousePressedEvent());
                    }
                    break;
                case MOUSE_RELEASED_EVENT:
                    for(MouseListener l : mouseListeners)
                    {
                        l.onMouseReleased(e.asMouseReleasedEvent());
                    }
                    break;
                case MOUSE_MOVED_EVENT:
                    for(MouseListener l : mouseListeners)
                    {
                        l.onMouseMoved(e.asMouseMovedEvent());
                    }
                    break;
                case MOUSE_WHEEL_EVENT:
                    for(MouseListener l : mouseListeners)
                    {
                        l.onMouseWheel(e.asMouseWheelEvent());
                    }
                    break;
                default:
                    throw new RuntimeException("Unknown event type: " + e.getType().toString());
            }
        }
        inputEvents.clear();
        return quit;
    }
    
    @Override
    public synchronized void eventDispatched(AWTEvent event)
    {
        switch(event.getID())
        {
            case MouseEvent.MOUSE_PRESSED:
            {
                MouseEvent me = (MouseEvent) event;
                MouseButton b = MouseButtonMap.getMouseButton(me.getButton());
                MousePressedEventImpl e =
                    new MousePressedEventImpl(  me.getWhen()-startTime,
                                                me.getX(),
                                                me.getY(),
                                                b );
                inputEvents.add(e);
                break;
            }
            case MouseEvent.MOUSE_RELEASED:
            {
                MouseEvent me = (MouseEvent) event;
                MouseButton b = MouseButtonMap.getMouseButton(me.getButton());
                MouseReleasedEventImpl e =
                    new MouseReleasedEventImpl( me.getWhen()-startTime,
                                                me.getX(),
                                                me.getY(),
                                                b );
                inputEvents.add(e);
                break;
            }
            case MouseEvent.MOUSE_DRAGGED:
            case MouseEvent.MOUSE_MOVED:
            {
                MouseEvent me = (MouseEvent) event;
                MouseMovedEventImpl e =
                    new MouseMovedEventImpl( me.getWhen()-startTime,
                                                me.getX(),
                                                me.getY());
                inputEvents.add(e);
                break;
            }
            case MouseEvent.MOUSE_WHEEL:
            {
                MouseWheelEvent mwe = (MouseWheelEvent) event;
                MouseWheelEventImpl e = 
                        new MouseWheelEventImpl(mwe.getWhen()-startTime,
                                                mwe.getX(),
                                                mwe.getY(),
                                                mwe.getWheelRotation());
                inputEvents.add(e);
                break;
            }
            case KeyEvent.KEY_PRESSED:
            {
                KeyEvent ke = (KeyEvent) event;
                Key k = KeyMap.getKey(ke);
                if(k == Key.VK_ESC) quit = true;
                KeyPressedEventImpl e = new KeyPressedEventImpl(ke.getWhen()-startTime, k);
                inputEvents.add(e);
                break;
            }
            case KeyEvent.KEY_RELEASED:
            {
                KeyEvent ke = (KeyEvent) event;
                Key k = KeyMap.getKey(ke);
                KeyReleasedEventImpl e = new KeyReleasedEventImpl(ke.getWhen()-startTime, k);
                inputEvents.add(e);
                break;
            }
            default:
                //throw new RuntimeException("Unknown event type: " + event.getID());
        }
    }

    @Override
    public void addKeyboardListener(KeyboardListener keyListener)
    {
        keyboardListeners.add(keyListener);
    }

    @Override
    public void removeKeyboardListener(KeyboardListener keyListener)
    {
        keyboardListeners.remove(keyListener);
    }

    @Override
    public void addMouseListener(MouseListener listener)
    {
        mouseListeners.add(listener);
    }

    @Override
    public void removeMouseListener(MouseListener listener)
    {
       mouseListeners.remove(listener);
    }
    
}
