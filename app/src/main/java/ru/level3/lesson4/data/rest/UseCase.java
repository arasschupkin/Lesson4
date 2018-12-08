package ru.level3.lesson4.data.rest;

import io.reactivex.Observable;

public interface UseCase<REQUEST, RESPONSE> {
    Observable<RESPONSE> execute(REQUEST request);
}
