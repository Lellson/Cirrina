package at.ac.uibk.dps.cirrina.core.object.action;

import at.ac.uibk.dps.cirrina.core.io.plantuml.Exportable;
import at.ac.uibk.dps.cirrina.core.io.plantuml.PlantUmlVisitor;
import java.util.Optional;

/**
 * Base action, can represent and action.
 */
public abstract class Action implements Exportable {

  /**
   * The action name. An action name can be omitted, in which case it is an inline action and cannot be referenced.
   */
  private final Optional<String> name;

  /**
   * Initializes this action.
   *
   * @param name Name, can be optional in which case this action is inline.
   */
  Action(Optional<String> name) {
    this.name = name;
  }

  public Optional<String> getName() {
    return name;
  }

  /**
   * To string.
   *
   * @return String representation.
   */
  @Override
  public String toString() {
    return name.orElse("Inline Action");
  }

  @Override
  public void accept(PlantUmlVisitor visitor) {
    visitor.visit(this);
  }

}
