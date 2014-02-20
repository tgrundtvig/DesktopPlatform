/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input.keyboard;

import applicationapi.input.InputEventType;
import applicationapi.input.keyboard.Key;
import applicationapi.input.keyboard.KeyReleasedEvent;

/**
 *
 * @author tog
 */
public class KeyReleasedEventImpl extends AbstractKeyEvent implements KeyReleasedEvent
{
    public KeyReleasedEventImpl(long when, Key key)
    {
        super(when, key);
    }

    @Override
    public InputEventType getType()
    {
        return InputEventType.KEY_RELEASED_EVENT;
    }

    @Override
    public KeyReleasedEvent asKeyReleasedEvent()
    {
        return this;
    }  
}
