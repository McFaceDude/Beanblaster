package blaster.visitor;

import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Created by Samuel on 2016-04-27.
 * This class is part of the implementation of the visitor design pattern to handle the collison
 * of different entities.
 * Entity implements this interface and its methods so that the different entities can have different
 * collisonResponse methods depending on which type of entity they collide with.
 * If a entitie doesn't have a collisonResponse for a sertain entitie the empty method in the Entity class
 * will be called and nothing will happen.
 */

//The methods are implemented in Entity and these methods are not used but they exist so that Entity knows which
//collisonResponse methods to implement.
@SuppressWarnings("unused")
public interface CollisionElement {

    void collide(CollisionVisitor collisionVisitor);

    void collisionResponse(Planet planet);

    void collisionResponse(Projectile projectile);

    //The method is never implemented but called when someone collides with a player.
    @SuppressWarnings("EmptyMethod")
    void collisionResponse(Player player);

}
