/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.Device;
import applicationapi.graphics.Screen;
import applicationapi.input.keyboard.Keyboard;

/**
 *
 * @author tog
 */
public class DeviceImpl implements Device
{
    private final Screen screen;
    private final Keyboard kb;

    public DeviceImpl(Screen screen, Keyboard kb)
    {
        this.screen = screen;
        this.kb = kb;
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
    
}
