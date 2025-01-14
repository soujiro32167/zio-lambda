package zio.lambda.internal

import zio._
import zio.lambda.ZLambda

trait LambdaLoader {
  def loadLambda: UIO[Either[Throwable, ZLambda[_, _]]]
}

object LambdaLoader {
  def loadLambda: URIO[LambdaLoader, Either[Throwable, ZLambda[_, _]]] =
    ZIO.serviceWithZIO(_.loadLambda)
}
