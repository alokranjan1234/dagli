// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/TupledX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.annotation.equality.ValueEquality;
import com.linkedin.dagli.producer.Producer;
import com.linkedin.dagli.tuple.Tuple3;


/**
 * A transformer that produces a tuple of the values it receives as inputs.
 */
@ValueEquality
public class Tupled3<A, B, C> extends AbstractPreparedTransformer3<A, B, C, Tuple3<A, B, C>, Tupled3<A, B, C>> {
  private static final long serialVersionUID = 1;

  /**
   * Creates a new instance with the specified inputs.
   */
  public Tupled3(Producer<? extends A> input1, Producer<? extends B> input2, Producer<? extends C> input3) {
    super(input1, input2, input3);
  }

  @Override
  public Tuple3<A, B, C> apply(A value1, B value2, C value3) {
    return Tuple3.of(value1, value2, value3);
  }
}