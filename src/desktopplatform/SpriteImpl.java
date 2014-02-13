/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Color;
import applicationapi.graphics.Sprite;
import java.awt.image.BufferedImage;

/**
 *
 * @author tog
 */
public class SpriteImpl implements Sprite
{
    private final BufferedImage img;
    private final int anchorX;
    private final int anchorY;
    
    public SpriteImpl(BufferedImage img, int anchorX, int anchorY)
    {
        this.img = img;
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }
    
    BufferedImage getImage()
    {
        return img;
    }

    @Override
    public int getWidth()
    {
        return img.getWidth();
    }

    @Override
    public int getHeight()
    {
        return img.getHeight();
    }

    @Override
    public Color getPixel(int x, int y)
    {
        return new ColorImpl(img.getRGB(x, y));
    }

    @Override
    public int getAnchorX()
    {
        return anchorX;
    }

    @Override
    public int getAnchorY()
    {
        return anchorY;
    }   
}
