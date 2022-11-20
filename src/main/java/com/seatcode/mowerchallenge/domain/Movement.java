package com.seatcode.mowerchallenge.domain;

public enum Movement {
	   L{
	        @Override
	        public MovementHandler executeCommand()
	        {
	            return new LeftHandler();
	        }
	    },
	    R{
	        @Override
	        public MovementHandler executeCommand()
	        {
	        	return new RightHandler();
	        }
	    },
	    M{
	        @Override
	        public MovementHandler executeCommand()
	        {
	        	return new MoveHandler();
	        }
	    };

	    public abstract MovementHandler executeCommand();
}
