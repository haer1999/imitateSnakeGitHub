package main;

public class Updater extends Thread{
	public Updater(Board b, Snake s)
	{
	mBoard = b;
	mSnake = s;
	}
	public void run()
	{
	while (true)
	{
	mSnake.move(mBoard);
	mBoard.repaint();
	try
	{
	sleep(500); //线程暂停500毫秒，详见API手册，这个函数会产生异常，这里直接打印出来了，并未做进一步处理。
	} catch (Exception e)
	{
	System.out.println(e.toString());
	}
	}
	}
	private Board mBoard;
	private Snake mSnake;
}
