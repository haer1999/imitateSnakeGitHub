package main;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	enum DIRECTION{
		UP,DOWN,LEFT,RIGHT;
	}
	private List<Body> mBody;
	private DIRECTION mDirection;
	public Snake(){
		mBody = new ArrayList<Body>();
		reset();
	}
	public void reset(){
	    mBody.clear(); //清空链表先
	    mBody.add(new Body(7, 4));
	    mBody.add(new Body(7, 3));
	    mBody.add(new Body(7, 2));
	    mBody.add(new Body(7, 1));
	    mDirection = DIRECTION.RIGHT;
	}
	public void move(Board b){
		Body head;
		Body headold = mBody.get(0);
		switch (mDirection)
		{
		case UP:
		head = new Body(headold.row-1, headold.col);
		break;
		case DOWN:
		head = new Body(headold.row+1, headold.col);
		break;
		case LEFT:
		head = new Body(headold.row, headold.col-1);
		break;
		case RIGHT:
		head = new Body(headold.row, headold.col+1);
		break;
		default:
		head = new Body(0, 0);
		break;
		}
		mBody.add(0, head);
		mBody.remove(mBody.size()-1);
	}
	public void setNextDirection(DIRECTION d)
	{
	    mDirection = d;
	}
	
	public Body getBody(int index)
	{
	    return mBody.get(index);
	}
	
	public int getLength()
	{
	    return mBody.size();
	}
}
