/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Color;

/**
 *
 * @author tog
 */
public class ColorImpl implements Color
{
    private final java.awt.Color col;
    
    ColorImpl(int c)
    {
        col = new java.awt.Color(c, true);
    }
    
    ColorImpl(float r, float g, float b, float a)
    {
        col = new java.awt.Color(r, g, b, a);
    }
    
    java.awt.Color getAWTColor()
    {
        return col;
    }

    @Override
    public float getRed()
    {
        return col.getRed();
    }

    @Override
    public float getGreen()
    {
        return col.getGreen();
    }

    @Override
    public float getBlue()
    {
        return col.getBlue();
    }

    @Override
    public float getAlpha()
    {
        return col.getAlpha();
    }

    @Override
    public int getRGBA()
    {
        return col.getRGB();
    }
    
}
