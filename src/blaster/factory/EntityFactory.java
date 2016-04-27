package blaster.factory;

import blaster.EntityManager;
import blaster.Updatable;
import blaster.entity.Entity;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-21.
 */
interface EntityFactory extends Updatable {

    boolean wantsToProduce(float deltaTime, Input input);

    Entity produce(EntityManager manager) throws SlickException;

}
