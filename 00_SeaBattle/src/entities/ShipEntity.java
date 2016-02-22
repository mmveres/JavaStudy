package entities;

import java.util.Arrays;

public class ShipEntity implements Ship {
	
	private final ShipType type;
	private ShipCell[] sections;
	private ShipLayout layout;

	public ShipEntity(ShipCell start, ShipLayout layout, ShipType type) {
		if(start==null||layout==null||type==null)throw new IllegalArgumentException("Ship creation error - one of needed params set null!");
		this.type=type;
		sections = new ShipCell[type.getLength()];
		sections[0] = start;
		this.layout=layout;
		switch (layout) {
		case Horizontal: {
			for (int i = 1; i < sections.length; i++) {
				sections[i] = new ShipCell(start.getX() + i, start.getY());

			}
			break;
		}
		case Vertical: {
			for (int i = 1; i < sections.length; i++) {
				sections[i] = new ShipCell(start.getX(), start.getY() + i);

			}
			break;
		}

		default:
			break;
		}
	}

	@Override
	public boolean isAlive() {
		for (ShipCell shipCell : sections) {
			if (!shipCell.isHit())
				return true;
		}
		return false;
	}

	@Override
	public boolean isShip(ShipCell cell, boolean markHit) {
		for (int i = 0; i < sections.length; i++) {
			if(sections[i].equals(cell)){
				sections[i].setHit(markHit);
				return true;
			}
		}
		return false;
	}

	@Override
	public ShipType getType() {
		return type;
	}

	
	
	
	@Override
	public String toString() {
		return "" + type + " ("+sections[0].getX()+","+sections[0].getY()+" "+ layout+")";
	}

	@Override
	public ShipCell []getPosition() {
		// TODO Auto-generated method stub
		return sections;
	}

}
