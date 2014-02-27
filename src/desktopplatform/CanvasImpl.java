/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopplatform;

import applicationapi.graphics.Canvas;
import applicationapi.graphics.Color;
import applicationapi.graphics.Sprite;
import java.awt.Graphics;

/**
 *
 * @author tog
 */
public class CanvasImpl implements Canvas
{
    private final Graphics graphics;
    
    CanvasImpl(Graphics g)
    {
        this.graphics = g;
    }
    
    @Override
    public void drawSprite(int x, int y, Sprite sp)
    {
        SpriteImpl sprite = (SpriteImpl) sp;
        int aX = sprite.getAnchorX();
        int aY = sprite.getAnchorY();
        int posX = x - aX;
        int posY = y - aY;
        graphics.drawImage(sprite.getImage(), posX, posY, null);
    }

    @Override
    public void drawLine(int ax, int ay, int bx, int by, Color c)
    {
        ColorImpl color = (ColorImpl) c;
        graphics.setColor(color.getAWTColor());
        graphics.drawLine(ax, ay, bx, by);
    }
    
}
