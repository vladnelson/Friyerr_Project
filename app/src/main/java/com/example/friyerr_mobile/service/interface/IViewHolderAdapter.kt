package com.example.friyerr_mobile.service.`interface`

interface IViewHolderAdapter<T> {
    fun LoadView(item:T,listerner: OnItemClickListenerList<T>)
}