/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform.input.mouse;

import applicationapi.input.InputEventType;
import applicationapi.input.mouse.MouseButton;
import applicationapi.input.mouse.MousePressedEvent;

/**
 *
 * @author tog
 */
public class MousePressedEventImpl extends AbstractMouseEvent implements MousePressedEvent
{
    private final MouseButton button;

    public MousePressedEventImpl(long when, int x, int y, MouseButton button)
    {
        super(when, x, y);
        this.button = button;
    }

    @Override
    public MouseButton getButton()
    {
        return button;
    }

    @Override
    public InputEventType getType()
    {
        return InputEventType.MOUSE_PRESSED_EVENT;
    }

    @Override
    public MousePressedEvent asMousePressedEvent()
    {
        return this;
    }   
}
