package newengine.collision;

import bus.EventBus;
import newengine.event.collision.CollisionEvent;
import newengine.sprite.Sprite;

public class CollisionManager {

	private EventBus bus;
	
	public CollisionManager(EventBus bus) {
		this.bus = bus;
		initHandlers();
	}
	
	private void initHandlers() {
		bus.on(CollisionEvent.ANY, (e) -> {
			Sprite s1 = e.getSprite1();
			Sprite s2 = e.getSprite2();
			System.out.println("Collision Detected!");
		});
	}

	
}
