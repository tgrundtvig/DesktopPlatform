/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Color;
import applicationapi.graphics.Sprite;
import applicationapi.graphics.SpriteBuilder;
import java.awt.image.BufferedImage;

/**
 *
 * @author tog
 */
public class SpriteBuilderImpl implements SpriteBuilder
{
    private BufferedImage img;
    private int anchorX;
    private int anchorY;

    public SpriteBuilderImpl(BufferedImage img)
    {
        this.img = img;
        anchorX = 0;
        anchorY = 0;
    }
   
    @Override
    public void setPixel(int x, int y, Color c)
    {
        img.setRGB(x, y, c.getRGBA());
    }

    @Override
    public void setAnchor(int x, int y)
    {
        anchorX = x;
        anchorY = y;
    }

    @Override
    public Sprite build()
    {
        if(img == null) throw new IllegalStateException("Sprite has already been build");
        Sprite res = new SpriteImpl(img, anchorX, anchorY);
        img = null;
        return res;
    }
    
}
