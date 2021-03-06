// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the transformer/PreparableTransformerX.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.transformer;

import com.linkedin.dagli.dag.DAG;
import com.linkedin.dagli.dag.DAG1x1;
import com.linkedin.dagli.dag.SimpleDAGExecutor;
import com.linkedin.dagli.preparer.PreparerContext;
import com.linkedin.dagli.preparer.PreparerResultMixed;
import com.linkedin.dagli.placeholder.Placeholder;
import com.linkedin.dagli.transformer.internal.PreparableTransformer1InternalAPI;
import com.linkedin.dagli.util.collection.Iterables;


public interface PreparableTransformer1<A, R, N extends PreparedTransformer1<A, R>> extends Transformer1<A, R>,
    PreparableTransformer<R, N> {

  @Override
  PreparableTransformer1InternalAPI<A, R, N, ? extends PreparableTransformer1<A, R, N>> internalAPI();

  /**
   * Casts a preparable transformer to a "supertype".  This cast is safe due to the semantics of preparable
   * transformers.
   *
   * @param preparable the preparable transformer to cast
   * @param <A> the new type of input #1
   * @param <R> the new result type
   * @param <N> the new prepared transformer type
   * @return the provided {@code preparable}, cast to the desired "supertype"
   */
  @SuppressWarnings("unchecked")
  static <A, R, N extends PreparedTransformer1<A, R>> PreparableTransformer1<A, R, N> cast(
      PreparableTransformer1<? super A, ? extends R, ? extends N> preparable) {
    // safe due to semantics of preparable transformers:
    return (PreparableTransformer1<A, R, N>) preparable;
  }

  /**
   * Casts a preparable transformer to a "supertype" with an unknown type of prepared transformer.  This cast is safe
   * due to the semantics of preparable transformers.
   *
   * @param preparable the preparable transformer to cast
   * @param <A> the new type of input #1
   * @param <R> the new result type
   * @return the provided {@code preparable}, cast to the desired "supertype"
   */
  @SuppressWarnings("unchecked")
  static <A, R> PreparableTransformer1<A, R, PreparedTransformer1<A, R>> castWithGenericPrepared(
      PreparableTransformer1<? super A, ? extends R, ?> preparable) {
    // safe due to semantics of preparable transformers:
    return (PreparableTransformer1<A, R, PreparedTransformer1<A, R>>) preparable;
  }

  /**
   * Prepares a preparable transformer and returns the result (which includes the prepared transformer for both the
   * "preparation" data (in this case, the values passed to this method) and "new" data.
   *
   * @param preparable the transformer to prepare
   * @param values1 the values for the first input to the transformer for each example
   * @param <A> the type of the first input
   * @param <R> the type of the result of the prepared transformers
   * @param <N> the type of the prepared transformer ("for new data")
   * @return a {@link PreparerResultMixed} containing the prepared transformers for "preparation data" (the provided
   *         values)
   */
  @SuppressWarnings("unchecked")
  static <A, R, N extends PreparedTransformer1<A, R>> PreparerResultMixed<PreparedTransformer1<A, R>, N> prepare(
      PreparableTransformer1<A, R, N> preparable, Iterable<? extends A> values1) {
    return (PreparerResultMixed<PreparedTransformer1<A, R>, N>) preparable.internalAPI().prepare(
        PreparerContext.builder(Iterables.size64(values1)).setExecutor(new SimpleDAGExecutor()).build(), values1);
  }

  /**
   * Creates a trivial DAG that wraps the provided transformer, with the DAG retaining the transformer's existing
   * inputs or, if the transformer is already a DAG, simply returns it unaltered.
   *
   * @param transformer the transformer to wrap
   * @param <A> the type of transformer input #1
   * @param <R> the type of result produced by the transformer
   * @return a trivial DAG that wraps the provided transformer, or the transformer itself if it is already a DAG
   */
  @SuppressWarnings("unchecked")
  static <A, R> DAG1x1<A, R> toDAG(PreparableTransformer1<A, R, ?> transformer) {
    if (transformer instanceof DAG1x1) {
      return (DAG1x1<A, R>) transformer;
    }

    Placeholder<A> placeholder1 = new Placeholder<>("Input #1");
    return DAG.withPlaceholders(placeholder1).withNoReduction()
        .withOutput(transformer.internalAPI().withInputs(placeholder1))
        .withAllInputs(transformer.internalAPI().getInput1());
  }
}
