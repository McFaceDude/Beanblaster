package blaster;

import blaster.entity.Entity;
import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Created by Samuel on 2016-04-27.
 */
public interface CollisonElement {

    void collide(CollisionVisitor collisionVisitor);
    void collisionResponse(Planet planet);
    void collisionResponse(Projectile projectile);
    void collisionResponse(Player player);

}
