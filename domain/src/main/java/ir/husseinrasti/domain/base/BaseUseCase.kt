package ir.husseinrasti.domain.base

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface BaseUseCase<in Params, Type> {

    operator fun invoke(params: Params): Single<Type>
//    operator fun invoke(params: Params): Observable<Type>

}