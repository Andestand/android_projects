package project.productsandservice.data.interfaces

interface DataBaseConnection {

    fun connect(): Boolean

    fun isConnect(): Boolean

    fun disconnect(): Boolean
}