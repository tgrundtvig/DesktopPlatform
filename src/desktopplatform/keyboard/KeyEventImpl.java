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

import applicationapi.input.keyboard.Key;
import java.awt.event.KeyEvent;

/**
 *
 * @author tog
 */
public class KeyEventImpl implements applicationapi.input.keyboard.KeyEvent
{
    private final long when;
    private final Key key;
    private final boolean pressed;

    public KeyEventImpl(long when, KeyEvent jk, boolean pressed)
    {
        this.when = when;
        this.pressed = pressed;
        switch(jk.getKeyCode())
        {
            //Normal letters and numbers
            case KeyEvent.VK_A:
                key = Key.VK_A;
                break;
            case KeyEvent.VK_B:
                key = Key.VK_B;
                break;
            case KeyEvent.VK_C:
                key = Key.VK_C;
                break;
            case KeyEvent.VK_D:
                key = Key.VK_D;
                break;
            case KeyEvent.VK_E:
                key = Key.VK_E;
                break;
            case KeyEvent.VK_F:
                key = Key.VK_F;
                break;
            case KeyEvent.VK_G:
                key = Key.VK_G;
                break;
            case KeyEvent.VK_H:
                key = Key.VK_H;
                break;
            case KeyEvent.VK_I:
                key = Key.VK_I;
                break;
            case KeyEvent.VK_J:
                key = Key.VK_J;
                break;
            case KeyEvent.VK_K:
                key = Key.VK_K;
                break;
            case KeyEvent.VK_L:
                key = Key.VK_L;
                break;
            case KeyEvent.VK_M:
                key = Key.VK_M;
                break;
            case KeyEvent.VK_N:
                key = Key.VK_N;
                break;
            case KeyEvent.VK_O:
                key = Key.VK_O;
                break;
            case KeyEvent.VK_P:
                key = Key.VK_P;
                break;
            case KeyEvent.VK_Q:
                key = Key.VK_Q;
                break;
            case KeyEvent.VK_R:
                key = Key.VK_R;
                break;
            case KeyEvent.VK_S:
                key = Key.VK_S;
                break;
            case KeyEvent.VK_T:
                key = Key.VK_T;
                break;
            case KeyEvent.VK_U:
                key = Key.VK_U;
                break;
            case KeyEvent.VK_V:
                key = Key.VK_V;
                break;
            case KeyEvent.VK_W:
                key = Key.VK_W;
                break;
            case KeyEvent.VK_X:
                key = Key.VK_X;
                break;
            case KeyEvent.VK_Y:
                key = Key.VK_Y;
                break;
            case KeyEvent.VK_Z:
                key = Key.VK_Z;
                break;
           
                
            
            case KeyEvent.VK_0:
                key = Key.VK_0;
                break;
            case KeyEvent.VK_1:
                key = Key.VK_1;
                break;
            case KeyEvent.VK_2:
                key = Key.VK_2;
                break;
            case KeyEvent.VK_3:
                key = Key.VK_3;
                break;
            case KeyEvent.VK_4:
                key = Key.VK_4;
                break;
            case KeyEvent.VK_5:
                key = Key.VK_5;
                break;
            case KeyEvent.VK_6:
                key = Key.VK_6;
                break;
            case KeyEvent.VK_7:
                key = Key.VK_7;
                break;
            case KeyEvent.VK_8:
                key = Key.VK_8;
                break;
            case KeyEvent.VK_9:
                key = Key.VK_9;
                break;
                
            //Arrow keys
            case KeyEvent.VK_UP:
                key = Key.VK_UP;
                break;
            case KeyEvent.VK_DOWN:
                key = Key.VK_DOWN;
                break;
            case KeyEvent.VK_LEFT:
                key = Key.VK_LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                key = Key.VK_RIGHT;
                break;
            
            //Special keys    
            case KeyEvent.VK_SPACE:
                key = Key.VK_SPACE;
                break;
            case KeyEvent.VK_ENTER:
                if(jk.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD) key = Key.VK_NUM_ENTER;
                else key = Key.VK_ENTER;
                break;
            case KeyEvent.VK_ESCAPE:
                key = Key.VK_ESC;
                break;
            case KeyEvent.VK_SHIFT:
                if(jk.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT) key = Key.VK_LSHIFT;
                else key = Key.VK_RSHIFT;
                break;
            case KeyEvent.VK_CONTROL:
                if(jk.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT) key = Key.VK_LCTRL;
                else key = Key.VK_RCTRL;
                break;
            case KeyEvent.VK_TAB:
                key = Key.VK_TAB;
                break;
            case KeyEvent.VK_ALT:
                key = Key.VK_ALT;
                break;
            case KeyEvent.VK_ALT_GRAPH:
                key = Key.VK_ALT_GRAPH;
                break;  
            
            //Numpad numbers
            case KeyEvent.VK_NUMPAD0:
                key = Key.VK_NUM_0;
                break;
            case KeyEvent.VK_NUMPAD1:
                key = Key.VK_NUM_1;
                break;
            case KeyEvent.VK_NUMPAD2:
                key = Key.VK_NUM_2;
                break;
            case KeyEvent.VK_NUMPAD3:
                key = Key.VK_NUM_3;
                break;
            case KeyEvent.VK_NUMPAD4:
                key = Key.VK_NUM_4;
                break;
            case KeyEvent.VK_NUMPAD5:
                key = Key.VK_NUM_5;
                break;
            case KeyEvent.VK_NUMPAD6:
                key = Key.VK_NUM_6;
                break;
            case KeyEvent.VK_NUMPAD7:
                key = Key.VK_NUM_7;
                break;
            case KeyEvent.VK_NUMPAD8:
                key = Key.VK_NUM_8;
                break;
            case KeyEvent.VK_NUMPAD9:
                key = Key.VK_NUM_9;
                break;
                
                
            
                
            
            default:
                key = Key.UNKNOWN;
                       
            
        }
    }
    
    
    boolean pressed()
    {
        return pressed;
    }
    
    @Override
    public Key getKey()
    {
        return key;
    }

    @Override
    public long getWhen()
    {
        return when;
    }
    
}
