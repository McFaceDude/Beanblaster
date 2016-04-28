package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import blaster.utility.Updatable;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Project: Beanblaster.
 * Created by Samuel on 2016-04-21.
 */
public interface EntityFactory extends Updatable {

    boolean wantsToProduce(float deltaTime, Input input);

    Entity produce(EntityManager manager) throws SlickException;

}
