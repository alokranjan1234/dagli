package com.linkedin.dagli.nn.layer;

import com.linkedin.dagli.annotation.visitor.VisitedBy;
import com.linkedin.dagli.math.vector.DenseVector;
import com.linkedin.dagli.nn.result.NNResult;
import com.linkedin.dagli.producer.Producer;
import com.linkedin.dagli.transformer.DynamicInputs;
import java.util.Map;

@VisitedBy("NNLayerVisitor")
public class NNEmbeddingLayer extends AbstractUnaryIntegerLayer<DenseVector, NNEmbeddingLayer>
    implements NonTerminalLayer {
  private static final long serialVersionUID = 1;

  private int _embeddingSize = 64;

  @Override
  Producer<DenseVector> outputFromNNResult(Producer<? extends NNResult> nnResultProducer, int outputIndex) {
    return NNResult.InternalAPI.toVector(nnResultProducer, (outputIndex));
  }

  /**
   * @return the size of the embedding generated by this layer
   */
  public int getEmbeddingSize() {
    return _embeddingSize;
  }

  /**
   * Returns a copy of this layer that will generate embeddings of the specified size.
   *
   * The default embedding size is 64.
   *
   * @param embeddingSize the size of the embedding to be generated
   * @return a copy of this layer that will generate embeddings of the specified size
   */
  public NNEmbeddingLayer withEmbeddingSize(int embeddingSize) {
    return clone(c -> c._embeddingSize = embeddingSize);
  }

  @Override
  public <R> R accept(NNLayerVisitor<R> visitor) {
    return visitor.visit(this);
  }

  @Override
  DynamicLayerConfig getDynamicConfig(Map<NNLayer<?, ?>, DynamicLayerConfig> ancestorConfigs,
      DynamicInputs dynamicInputs, DynamicInputs.ConstantInputs constantInputs) {
    return DynamicLayerConfig.Builder.setOutputShape(new long[] {_embeddingSize}).build();
  }
}