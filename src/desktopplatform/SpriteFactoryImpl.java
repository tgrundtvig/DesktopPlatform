/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Color;
import applicationapi.graphics.SpriteBuilder;
import applicationapi.graphics.SpriteFactory;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;

/**
 *
 * @author tog
 */
public class SpriteFactoryImpl implements SpriteFactory
{
    private final GraphicsConfiguration gc;
    
    SpriteFactoryImpl(GraphicsConfiguration gc)
    {
        this.gc = gc;
    }
    
    @Override
    public SpriteBuilder newSprite(int width, int height)
    {
        BufferedImage img = gc.createCompatibleImage(width, height);
        if(img == null) throw new RuntimeException("Could not create a compatible buffered image!");
        return new SpriteBuilderImpl(img);
    }

    @Override
    public Color newColor(float r, float g, float b, float alpha)
    {
        return new ColorImpl(r, g, b, alpha);
    }
    
}
