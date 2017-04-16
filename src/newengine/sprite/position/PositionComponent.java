package newengine.sprite.position;

import newengine.event.sprite.MoveEvent;
import newengine.sprite.Sprite;
import newengine.sprite.component.Component;
import newengine.sprite.component.ComponentType;
import newengine.sprite.speed.SpeedComponent;
import newengine.utils.Target;
import newengine.utils.point.GamePoint;

public class PositionComponent extends Component {

	public static final ComponentType<PositionComponent> TYPE = new ComponentType<>();
	
	@Override
	public ComponentType<? extends Component> getType() {
		return TYPE;
	}
	
	private Sprite sprite;
	private GamePoint pos;
	
	public PositionComponent(GamePoint pos) {
		this.pos = pos;
	}

	@Override
	public void onAdded(Sprite sprite) {
		this.sprite = sprite;
		initHandlers();
	}

	@Override
	public void onUpdated(double dt) {
		double speed = sprite.getComponent(SpeedComponent.TYPE).getSpeed();
		double heading = sprite.getComponent(SpeedComponent.TYPE).getHeading();
		double x = pos.x() + dt * speed * Math.cos(Math.toRadians(heading));
		double y = pos.y() - dt * speed * Math.sin(Math.toRadians(heading));
		pos = new GamePoint(x, y);
		System.out.println("x: " + x + ", y: " + y);
	}
	
	private void initHandlers() {
		sprite.on(MoveEvent.SPECIFIC, e -> {
			moveTo(e.getTarget());
		});
	}

	private void moveTo(Target target) {
		System.out.print("Sprite at (" + pos.x() + ", " + pos.y() + ")" );
		// needs speed data
		if (target.getLocation().isPresent()) {
			pos = target.getLocation().get();			
		}
		else {
			
		}
		System.out.println(" has been moved to (" + pos.x() + ", " + pos.y() + ")");
	}
	
	
}
