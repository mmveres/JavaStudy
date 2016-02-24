package doubt;

import java.io.Serializable;
import java.rmi.Remote;

import entities.cells.CoordinateCell;
import entities.cells.ShotResult;

public interface ClientConnection extends Serializable{
	void putShot(CoordinateCell cell);
	ShotResult getMessage();
	void doStop();

}
