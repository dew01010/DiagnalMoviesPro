package com.example.diagnal.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val status: Status
) {

    class Success<T>(data: T) : Resource<T>(data = data, status = Status.SUCCESS)

    class Error<T>(
        errorMessage: String,
        errorType: ErrorType? = null
    ) : Resource<T>(message = errorMessage, status = Status.ERROR)

    class Loading<T> : Resource<T>(status = Status.LOADING)
}


enum class ErrorType {
    NETWORK,
    UNKNOWN
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
