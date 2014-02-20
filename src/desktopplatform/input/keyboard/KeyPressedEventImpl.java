/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input.keyboard;

import applicationapi.input.InputEventType;
import applicationapi.input.keyboard.Key;
import applicationapi.input.keyboard.KeyPressedEvent;

/**
 *
 * @author tog
 */
public class KeyPressedEventImpl extends AbstractKeyEvent implements KeyPressedEvent
{
    public KeyPressedEventImpl(long when, Key key)
    {
        super(when, key);
    }
    
    @Override
    public InputEventType getType()
    {
        return InputEventType.KEY_PRESSED_EVENT;
    }

    @Override
    public KeyPressedEvent asKeyPressedEvent()
    {
        return this;
    }
}
