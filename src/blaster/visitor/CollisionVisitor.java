package blaster.visitor;

import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Created by Samuel on 2016-04-27.
 * This class is part of the implementation of the visitor design pattern to handle the collison
 * of different entities.
 * Entity implements this interface and its methods so that the different entities can have different
 * visit methods depending on which type of entity that has visited it.
 * The visit method will call both of the collionRespons methods of the two entities that collided.
 */

public interface CollisionVisitor {

    void visit(Planet planet);

    void visit(Projectile projectile);

    void visit(Player player);


}
