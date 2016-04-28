package blaster.visitor;

import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Package: ${PACKAGE_NAME}
 * Created by Samuel on 2016-04-27.
 */
public interface CollisionElement {

    void collide(CollisionVisitor collisionVisitor);

    void collisionResponse(Planet planet);

    void collisionResponse(Projectile projectile);

    void collisionResponse(Player player);

}
