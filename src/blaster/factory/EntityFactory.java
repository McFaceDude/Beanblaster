package blaster.factory;

import blaster.EntityManager;
import blaster.Updatable;
import blaster.entity.Entity;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-21.
 */
public abstract interface EntityFactory extends Updatable {

    public abstract boolean wantsToProduce(float deltaTime, Input input);

    public abstract Entity produce(EntityManager manager) throws SlickException;

}