// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/VariadicFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import com.linkedin.dagli.util.exception.Exceptions;


@FunctionalInterface
public interface FunctionVariadic<A, R> extends FunctionBase {
  R apply(A... args);

  static <A, R> FunctionVariadic<A, R> unchecked(Checked<A, R, ?> checkedFunction) {
    return (A... args) -> {
      try {
        return checkedFunction.apply(args);
      } catch (Throwable e) {
        throw Exceptions.asRuntimeException(e);
      }
    };
  }

  @FunctionalInterface
  interface Checked<A, R, X extends Throwable> extends FunctionBase {
    R apply(A... args) throws X;
  }

  interface Serializable<A, R> extends FunctionVariadic<A, R>, java.io.Serializable {
  }
}