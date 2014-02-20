/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.Device;
import applicationapi.graphics.Screen;
import applicationapi.input.keyboard.Keyboard;
import applicationapi.input.mouse.Mouse;

/**
 *
 * @author tog
 */
public class DeviceImpl implements Device
{
    private final Screen screen;
    private final Keyboard kb;
    private final Mouse mouse;

    public DeviceImpl(Screen screen, Keyboard kb, Mouse mouse)
    {
        this.screen = screen;
        this.kb = kb;
        this.mouse = mouse;
    }
    
    
    @Override
    public Screen getScreen()
    {
        return screen;
    }

    @Override
    public Keyboard getKeyboard()
    {
        return kb;
    }

    @Override
    public Mouse getMouse()
    {
        return mouse;
    }
    
}
