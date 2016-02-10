package priority_slider;

import javax.swing.JSlider;

public class SliderThread extends Thread{
	JSlider slider;
	int delta;
	SliderThread(JSlider slider,int delta){
	this.slider=slider;
	this.delta=delta;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(slider.getValue()>10&&slider.getValue()<90)
		slider.setValue(slider.getValue()+delta);
		
		}
	}
	
}