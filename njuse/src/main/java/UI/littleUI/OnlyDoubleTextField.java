package UI.littleUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class OnlyDoubleTextField extends TextField {
	private OnlyDoubleTextField me =this;
	public double value=0;
	public OnlyDoubleTextField() {
		make();
	}
	
	public OnlyDoubleTextField(String a) {
		super(a);
		make();
		me.setText(a);
	}	
	
	private void make() {
		this.setText("");
	
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				boolean isDouble = false;
				double inn = 0;

				try {
					inn = Double.valueOf(newValue.trim());
					if(inn>=0&&inn<100000000) {
						isDouble = true;
					}
					
				} catch (Exception e) {
					isDouble = false;
				}
				
				if(newValue==""||newValue==null||newValue.length()==0) {
					value =0;
				}
				else if(!isDouble) {
					me.setText(oldValue);
				}
				else {
					value =inn;
				}
			}
		});
	}
}
