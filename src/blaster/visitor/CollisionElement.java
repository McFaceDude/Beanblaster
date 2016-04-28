package blaster.visitor;

import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Created by Samuel on 2016-04-27.
 * This class is part of the implementation of the visitor design pattern to handle the collison
 * of different entities.
 * Entitie implements this interface and its methods so that the different entities can have different
 * collisonResponse methods depending on which type of entity they collide with.
 * If a entitie doesn't have a collisonResponse for a sertain entitie the empty method in the Entity class
 * will be called and nothing will happen.
 * TODO explain more!
 */
public interface CollisionElement {

    void collide(CollisionVisitor collisionVisitor);

    void collisionResponse(Planet planet);

    void collisionResponse(Projectile projectile);

    //The method is never implemented but called when someone collides with a player.
    @SuppressWarnings({"EmptyMethod", "UnusedParameters"})
    void collisionResponse(Player player);

}
