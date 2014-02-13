/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Screen;
import applicationapi.graphics.SpriteFactory;

/**
 *
 * @author tog
 */
public class ScreenImpl implements Screen
{
    private final int width;
    private final int height;
    private final SpriteFactory sf;

    public ScreenImpl(int width, int height, SpriteFactory sf)
    {
        this.width = width;
        this.height = height;
        this.sf = sf;
    }
    
    @Override
    public int getWidth()
    {
        return width;
    }

    @Override
    public int getHeight()
    {
        return height;
    }

    @Override
    public SpriteFactory getSpriteFactory()
    {
        return sf;
    }
    
}
