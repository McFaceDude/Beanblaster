package Blaster;

import org.newdawn.slick.SlickException;

/**
 * Created by Samuel on 2016-04-21.
 */
public abstract interface EntityFactory extends Updatable{

    public abstract boolean wantsToProduce();

    public abstract Entity produce(EntityManager manager) throws SlickException;


}
