package blaster.visitor;

import blaster.entity.Planet;
import blaster.entity.Player;
import blaster.entity.Projectile;

/**
 * Project: Beanblaster.
 * Created by Samuel on 2016-04-27.
 */
public interface CollisionVisitor {

    void visit(Planet planet);

    void visit(Projectile projectile);

    void visit(Player player);


}
