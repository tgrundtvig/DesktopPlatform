/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input.mouse;

import applicationapi.input.InputEventType;
import applicationapi.input.mouse.MouseMovedEvent;

/**
 *
 * @author tog
 */
public class MouseMovedEventImpl extends AbstractMouseEvent implements MouseMovedEvent
{
    public MouseMovedEventImpl(long when, int x, int y)
    {
        super(when, x, y);
    }
    
    @Override
    public InputEventType getType()
    {
        return InputEventType.MOUSE_MOVED_EVENT;
    }

    @Override
    public MouseMovedEvent asMouseMovedEvent()
    {
        return this;
    }  
}
