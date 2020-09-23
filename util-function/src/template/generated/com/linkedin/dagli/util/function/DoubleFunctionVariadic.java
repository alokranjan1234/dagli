// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/VariadicFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.exception.Exceptions;


@FunctionalInterface
public interface DoubleFunctionVariadic<A> extends FunctionBase {
  double apply(A... args);

  static <A> DoubleFunctionVariadic<A> unchecked(Checked<A, ?> checkedFunction) {
    return (A... args) -> {
      try {
        return checkedFunction.apply(args);
      } catch (Throwable e) {
        throw Exceptions.asRuntimeException(e);
      }
    };
  }

  @FunctionalInterface
  interface Checked<A, X extends Throwable> extends FunctionBase {
    double apply(A... args) throws X;
  }

  interface Serializable<A> extends DoubleFunctionVariadic<A>, java.io.Serializable {
  }
}