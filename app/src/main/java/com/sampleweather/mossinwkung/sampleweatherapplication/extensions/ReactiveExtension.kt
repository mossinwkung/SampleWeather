package com.sampleweather.mossinwkung.sampleweatherapplication.extensions

import io.reactivex.Notification
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction

fun Disposable.addTo(composite: CompositeDisposable): Boolean = composite.add(this)

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Observable<Notification<T>>.elements() = this.filter { it.value != null }.map { it.value!! }

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Observable<Notification<T>>.completed() = this.filter { it.isOnComplete }.map { true }

@Suppress("NOTHING_TO_INLINE")
inline fun <T> Observable<Notification<T>>.error() = this.filter { it.error != null }.map { it.error!! }

inline fun <T, U, R> Observable<T>.withLatest(other: ObservableSource<out U>, crossinline combiner: (T, U) -> R): Observable<R> {
    return this.withLatestFrom(other, BiFunction<T, U, R> { t1, t2 ->
        return@BiFunction combiner(t1, t2)
    })
}