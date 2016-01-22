package main;

import java.awt.*;
import java.awt.event.*;

public class Board extends Frame{
	private static final int Width = 400; //窗口的宽度与高度
	private static final int Height = 300;
	private static final int TileWidth = 16; //每一格的宽度与高度，Tile本意指瓷砖，
	private static final int TileHeight = 16; //在游戏在专门指每一个单元
	public static final int Row = 15; //游戏盘的行数与列数
	public static final int Column = 20;
	private static final int XOffset = (Width - Column*TileWidth)/2; //当我们确定游戏盘大小后，
	private static final int YOffset = (Height- Row*TileHeight)/2; //也就是蛇运动的区域，这个左上角的坐标叫XOffset 和 YOffset
	private Snake mSnake;
	private Updater mUpdater;
	public Board(String title)                                      
	{
	super(title);
	setSize(Width, Height);
	setVisible(true);
	setResizable(false);
	mSnake = new Snake();
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
	mUpdater = new Updater(mBoard, mSnake);
	}
	public static void main(String args[]){
		Board Snake = new Board("Snake");
	}
	
	public void drawDecoration(Graphics g)
	{
	g.setColor(Color.RED);
	g.drawRect(XOffset, YOffset, Column*TileWidth, Row*TileHeight);
	}
	
	public void paint(Graphics g)
	{
		drawSnake(g);
	    drawDecoration(g);
	}
	
	public void drawSnake(Graphics g)
	{
	    g.setColor(Color.GREEN); //将画笔设为绿色
	    for (int i=0; i<mSnake.getLength(); i++)
	    {
	        Body body = mSnake.getBody(i);
	        g.fillRect( body.col*TileWidth+XOffset,
	        body.row*TileHeight+YOffset,
	        TileWidth, TileHeight);
	    }
	}
}
