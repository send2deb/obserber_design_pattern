package com.debdroid.hf.dp.observer

interface Subject {
    fun registerObserver(o : Observer)
    fun unRegisterObserver(o : Observer)
    fun notifyObserver()
}