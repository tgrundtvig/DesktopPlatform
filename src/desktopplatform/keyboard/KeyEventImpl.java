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
                
                
                
            /*    
            
            case KeyEvent.VK_0:
            {
                if(jk.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD)
                {
                    key = Key.VK_NUM_0;
                }
                else
                {
                    key = Key.VK_0;
                }
            }
            break;
            */
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
