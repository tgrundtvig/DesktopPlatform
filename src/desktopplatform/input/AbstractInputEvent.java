/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input;

import applicationapi.input.InputEvent;
import applicationapi.input.keyboard.KeyPressedEvent;
import applicationapi.input.keyboard.KeyReleasedEvent;
import applicationapi.input.mouse.MouseMovedEvent;
import applicationapi.input.mouse.MousePressedEvent;
import applicationapi.input.mouse.MouseReleasedEvent;
import applicationapi.input.mouse.MouseWheelEvent;

/**
 *
 * @author tog
 */
public abstract class AbstractInputEvent implements InputEvent
{
    private final long when;

    public AbstractInputEvent(long when)
    {
        this.when = when;
    }
    
    @Override
    public final int compareTo(InputEvent other)
    {
        long time = other.getWhen();
        if(when < time) return -1;
        if(when > time) return 1;
        return 0;
    }

    @Override
    public final long getWhen()
    {
        return when;
    }

    @Override
    public KeyPressedEvent asKeyPressedEvent()
    {
        throw new UnsupportedOperationException("This is not a KeyPressedEvent, this is a " + getType().toString());
    }

    @Override
    public KeyReleasedEvent asKeyReleasedEvent()
    {
        throw new UnsupportedOperationException("This is not a KeyReleasedEvent, this is a " + getType().toString());
    }

    @Override
    public MousePressedEvent asMousePressedEvent()
    {
        throw new UnsupportedOperationException("This is not a MousePressedEvent, this is a " + getType().toString());
    }

    @Override
    public MouseReleasedEvent asMouseReleasedEvent()
    {
        throw new UnsupportedOperationException("This is not a MouseReleasedEvent, this is a " + getType().toString());
    }

    @Override
    public MouseMovedEvent asMouseMovedEvent()
    {
        throw new UnsupportedOperationException("This is not a MouseMovedEvent, this is a " + getType().toString());
    }

    @Override
    public MouseWheelEvent asMouseWheelEvent()
    {
        throw new UnsupportedOperationException("This is not a MouseWheelEvent, this is a " + getType().toString());
    }    
}
