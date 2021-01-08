package ir.husseinrasti.data.base

interface ResponseObject<out DomainObject : Any?> {

    fun toDomain(): DomainObject

}