/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input.keyboard;

import applicationapi.input.keyboard.Key;
import applicationapi.input.keyboard.KeyEvent;
import desktopplatform.input.AbstractInputEvent;

/**
 *
 * @author tog
 */
public abstract class AbstractKeyEvent extends AbstractInputEvent implements KeyEvent
{
    private final Key key;

    public AbstractKeyEvent(long when, Key key)
    {
        super(when);
        this.key = key;
    }
   
    @Override
    public Key getKey()
    {
        return key;
    }   
}
