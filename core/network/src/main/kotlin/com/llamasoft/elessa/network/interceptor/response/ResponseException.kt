package com.llamasoft.elessa.network.interceptor.response

class ApiErrorException(message: String) : Exception(message)
class NetworkErrorException(message: String) : Exception(message)
class UnknownErrorException(message: String) : Exception(message)
class JsonParseException(message: String) : Exception(message)
