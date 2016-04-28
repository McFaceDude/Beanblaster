package blaster.factory;

import blaster.entity.Entity;
import blaster.entity.EntityManager;
import blaster.utility.Updatable;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-21.
 * All the Factories implements EntityFactory.
 * the factories be asked if they want to produce any entities and if so they are asked to produce.
 */
public interface EntityFactory extends Updatable {

    boolean wantsToProduce(float deltaTime, Input input);

    Entity produce(EntityManager manager) throws SlickException;

}
