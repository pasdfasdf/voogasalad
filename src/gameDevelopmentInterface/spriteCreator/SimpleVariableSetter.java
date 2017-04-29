package gameDevelopmentInterface.spriteCreator;

import exception.UnsupportedTypeException;
import javafx.scene.control.TextField;

/**
 * 
 * @author Daniel
 * Only works for primitive variables and strings.
 * @param <T>
 */
public class SimpleVariableSetter<T> extends VariableSetter<T>{
	private TextField value;
	Class<T> type;
	
	public SimpleVariableSetter(Class<T> type,String descriptor) throws UnsupportedTypeException{
		super(type, descriptor);
		this.type=type;
		value=new TextField();
		this.getChildren().add(value);
		this.setSpacing(20);
	}
	
	public T getValue() throws UnsupportedTypeException{
		PrimitiveConverter<T> converter=new PrimitiveConverter<T>();
		return converter.convertString(type, value.getText());
	}

	@Override
	public void setField(T initialValue) {
		value.setText(initialValue.toString());
	}

}

